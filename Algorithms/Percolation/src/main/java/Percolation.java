import edu.princeton.cs.algs4.WeightedQuickUnionUF; // Importamos la estructura Union-Find con unión ponderada y compresión de caminos


public class Percolation {

    // grid[i][j] es true si el sitio (i,j) está abierto, false si está bloqueado.
    // Usaremos índices de 0 a n-1 internamente, pero el problema usa 1 a n.
    private boolean[][] grid;

    private int openSitesCount; // Contador de sitios abiertos

    private final int n; // Tamaño del grid (n x n)

    // Usaremos dos objetos WeightedQuickUnionUF. ¿Por qué dos?
    // Uno (uf) para el chequeo de percolación y "full".
    // El otro (ufForFull) es un truco para evitar el "backwash" (lavado a contracorriente) en isFull().
    // Explicación de backwash: Si solo tuviéramos un UF, al conectar el "sitio virtual inferior"
    // con la última fila, un sitio en la parte inferior podría parecer "full"
    // si está conectado a la fila inferior, incluso si no está conectado a la fila superior.
    // Necesitamos que isFull() solo compruebe conexión con la parte superior.
    private final WeightedQuickUnionUF uf; // Para verificar percolación (conexión top-bottom)
    private final WeightedQuickUnionUF ufForFull; // Para verificar si un sitio está "full" (conectado a la parte superior)

    // Un sitio virtual para representar la fila superior.
    // Lo conectaremos a todos los sitios de la primera fila.
    private final int virtualTopSite;

    // Un sitio virtual para representar la fila inferior.
    // Lo conectaremos a todos los sitios de la última fila.
    private final int virtualBottomSite;

    /**
     * Crea una cuadrícula de n-por-n, con todos los sitios inicialmente bloqueados.
     *
     * @param n El tamaño de la cuadrícula.
     * @throws IllegalArgumentException si n <= 0.
     */
    public Percolation(int n) {
        if(n <= 0) {
            throw new IllegalArgumentException("n debe ser mayor que 0");
        }
        this.n = n;
        this.openSitesCount = 0;
        this.grid = new boolean[n][n];

        // Inicializamos los sitios virtuales.
        // Nodos totales en UF: n*n sitios reales + 2 sitios virtuales.
        virtualTopSite = n * n; // El último índice disponible antes de virtualBottomSite
        virtualBottomSite = n * n + 1; // El siguiente índice después de virtualTopSite

        // WeightedQuickUnionUF necesita el número total de elementos.
        uf = new WeightedQuickUnionUF(n*n +2); // Para percolates()
        ufForFull = new WeightedQuickUnionUF(n * n + 1); // Para isFull() (sin el virtualBottomSite)

    }

    /**
     * Abre el sitio (fila, columna) si no está abierto ya.
     * @param row La fila del sitio (1 a n).
     * @param col La columna del sitio (1 a n).
     * @throws IllegalArgumentException si row o col están fuera de rango.
     */
    public void open(int row, int col) {
        validateIndices(row, col); // Verifica que los índices sean válidos

        // Convertimos los índices de 1-based (del problema) a 0-based (para el arreglo Java)
        int r = row - 1;
        int c = col - 1;

        // Si el sitio ya está abierto, no hacemos nada
        if(grid[r][c]) {
            return;
        }

        grid[r][c] = true; // Marcamos el sitio como abierto
        openSitesCount++; // Incrementamos el contador de sitios abiertos

        // Conectamos el sitio abierto con sus vecinos abiertos
        int currentSiteIndex = xyTo1D(row, col);

        // Vecino de arriba
        if(row > 1 && isOpen(row - 1, col)) {
            uf.union(currentSiteIndex, xyTo1D(row - 1, col));
            ufForFull.union(currentSiteIndex, xyTo1D(row - 1, col));
        }

        // Vecino de abajo
        if(row < n && isOpen(row + 1, col)) {
            uf.union(currentSiteIndex, xyTo1D(row + 1, col));
            ufForFull.union(currentSiteIndex, xyTo1D(row + 1, col));
        }

        // Vecino de la izquierda
        if (col > 1 && isOpen(row, col -1)) {
            uf.union(currentSiteIndex, xyTo1D(row, col - 1));
            ufForFull.union(currentSiteIndex, xyTo1D(row, col - 1));
        }

        // Vecino de la derecha
        if(col < n && isOpen(row, col + 1)) {
            uf.union(currentSiteIndex, xyTo1D(row, col + 1));
            ufForFull.union(currentSiteIndex, xyTo1D(row, col + 1));
        }

        // Conectamos a los sitios virtuales si estamos en la primera o última fila
        if(row == 1) { // Si estamos en la primera fila
            uf.union(currentSiteIndex, virtualTopSite);
            ufForFull.union(currentSiteIndex, virtualTopSite);
        }
        if(row == n) { // Si estamos en la última fila
            uf.union(currentSiteIndex, virtualBottomSite);
        }
    }

    /**
     * ¿Está abierto el sitio (fila, columna)?
     * @param row La fila del sitio (1 a n).
     * @param col La columna del sitio (1 a n).
     * @return true si el sitio está abierto, false en caso contrario.
     * @throws IllegalArgumentException si row o col están fuera de rango.
     */
    public boolean isOpen(int row, int col) {
        validateIndices(row, col);
        return grid[row - 1][col - 1]; // Convertimos de 1-based a 0-based
    }

    /**
     * ¿Está lleno el sitio (fila, columna)? (Es decir, ¿está abierto y conectado a la fila superior?)
     * @param row La fila del sitio (1 a n).
     * @param col La columna del sitio (1 a n).
     * @return true si el sitio está lleno, false en caso contrario.
     * @throws IllegalArgumentException si row o col están fuera de rango.
     */
    public boolean isFull(int row, int col) {
        validateIndices(row, col);

        // Un sitio está "lleno" si está abierto Y está conectado al sitio virtual superior
        // Usamos ufForFull para evitar el backwash.
        return isOpen(row, col) && ufForFull.find(xyTo1D(row, col)) == ufForFull.find(virtualTopSite);
    }

    /**
     * Devuelve el número de sitios abiertos.
     * @return El número de sitios abiertos.
     */

    public int numberOfOpenSites() {
        return openSitesCount;
    }

    /**
     * ¿Percola el sistema? (Es decir, ¿existe un camino de sitios abiertos desde la fila superior a la fila inferior?)
     * @return true si el sistema percola, false en caso contrario.
     */
    public boolean percolates() {
        // El sistema percola si el sitio virtual superior está conectado al sitio virtual inferior
        return uf.find(virtualTopSite) == uf.find(virtualBottomSite);
    }

    // --- Métodos de ayuda ---

    // Convierte coordenadas 2D (fila, columna) a un índice 1D para el arreglo Union-Find.
    // Las filas y columnas del problema son 1 a n, las convertimos a 0 a n*n-1
    private int xyTo1D(int row, int col) {
        // (fila - 1) * n nos lleva al inicio de la fila correcta (en índice 0-based)
        // + (col - 1) nos da la columna dentro de esa fila.
        return (row - 1) * n + (col - 1);
    }

    // Valida que los índices de fila y columna estén dentro del rango permitido (1 a n).
    private void validateIndices(int row, int col) {
        if(row <= 0 || row > n || col <= 0 || col > n) {
            throw new IllegalArgumentException("Índices fuera de rango: fila y columna deben estar entre 1 y " + n);

        }
    }


}
