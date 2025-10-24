package union_find;

public class UnionFind {

    private int[] parent; // parent[i] = padre del elemento i
    private int[] size;   // size[i] = tamaño del componente con raíz i
    private int count;    // Número de componentes

    /**
     * Constructor: Inicializa la estructura con N elementos,
     * cada uno en su propio componente.
     */
    public UnionFind(int n) {
        if (n < 0) throw new IllegalArgumentException();
        count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Cada elemento es su propio padre al inicio
            size[i] = 1;   // Cada componente tiene tamaño 1
        }
    }

    /**
     * Encuentra la raíz del componente al que pertenece 'p'.
     * Usa "path compression" para aplanar el árbol.
     */
    public int find(int p) {
        validate(p);
        int root = p;
        while (root != parent[root]) {
            root = parent[root];
        }
        // Path compression: hacer que todos los nodos en el camino apunten a la raíz.
        while (p != root) {
            int newp = parent[p];
            parent[p] = root;
            p = newp;
        }
        return root;
    }

    /**
     * Devuelve true si p y q están en el mismo componente.
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Fusiona el componente que contiene a 'p' con el que contiene a 'q'.
     * Usa "weighted union" para mantener los árboles planos.
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return; // Ya están conectados

        // Weighted union: une el árbol más pequeño al más grande.
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count--; // Se reduce el número de componentes
    }

    // Método para validar que el índice está en el rango permitido
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("El índice " + p + " no está entre 0 y " + (n - 1));
        }
    }

    public static void main(String[] args) {
        // Creamos una red con 10 personas (0 a 9)
        UnionFind redSocial = new UnionFind(10);

        System.out.println("¿Están conectados 1 y 5? " + redSocial.connected(1, 5)); // false

        // Creamos algunas amistades
        redSocial.union(1, 2); // 1 y 2 son amigos
        redSocial.union(2, 5); // 2 y 5 son amigos -> ahora 1, 2 y 5 están conectados
        redSocial.union(6, 7); // 6 y 7 son amigos
        redSocial.union(8, 9); // 8 y 9 son amigos
        redSocial.union(1, 9); // 1 y 9 son amigos -> ahora 1,2,5,8,9 están conectados

        System.out.println("¿Están conectados 1 y 5? " + redSocial.connected(1, 5)); // true
        System.out.println("¿Están conectados 5 y 9? " + redSocial.connected(5, 9)); // true
        System.out.println("¿Están conectados 5 y 6? " + redSocial.connected(5, 6)); // false

        // Conectamos los dos grandes grupos
        redSocial.union(5, 6);
        System.out.println("¿Están conectados 5 y 6 (después de la unión)? " + redSocial.connected(5, 6)); // true
    }
}