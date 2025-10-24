package union_find.exercices.friend_circles;

class UnionFind {
    private int[] parent; // Almacena el padre de cada elemento
    private int count;    // Almacena el número de conjuntos disjuntos

    // Constructor: Inicializa n elementos, cada uno en su propio conjunto
    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Cada elemento es su propio padre al inicio
        }
    }

    // Método para encontrar el representante (raíz) de un conjunto con compresión de ruta
    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        // Compresión de ruta: Asigna el nodo directamente a la raíz
        parent[i] = find(parent[i]);
        return parent[i];
    }

    // Método para unir dos conjuntos
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        // Si no están ya en el mismo conjunto, los unimos
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
            count--; // Decrementamos el contador de conjuntos
        }
    }

    // Método para obtener el número actual de conjuntos disjuntos
    public int getCount() {
        return count;
    }
}