package union_find;

// Versión optimizada con Weighted Union y Path Compression
public class WeightedQuickUnionPathCompression {

    private int[] parent; // parent[i] = padre de i
    private int[] size;   // size[i] = tamaño del componente con raíz i

    public WeightedQuickUnionPathCompression(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    /**
     * Encuentra la raíz de 'p' con compresión de camino.
     */
    public int find(int p) {
        int root = p;
        // 1. Encontrar la raíz
        while (root != parent[root]) {
            root = parent[root];
        }
        // 2. Comprimir el camino
        while (p != root) {
            int next = parent[p];
            parent[p] = root;
            p = next;
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Une p y q usando unión ponderada.
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;

        // Une el árbol más pequeño al más grande
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
    }

    public static void main(String[] args) {
        WeightedQuickUnionPathCompression uf = new WeightedQuickUnionPathCompression(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);

        System.out.println("¿8 y 9 están conectados? " + uf.connected(8, 9)); // true
        System.out.println("¿5 y 4 están conectados? " + uf.connected(5, 4)); // false

        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        uf.union(1, 0);

        System.out.println("¿5 y 4 están conectados ahora? " + uf.connected(5, 4)); // true
    }
}