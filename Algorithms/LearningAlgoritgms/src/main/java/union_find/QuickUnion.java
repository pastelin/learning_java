package union_find;

import com.sun.jdi.PathSearchingVirtualMachine;

// Versión simple sin optimizaciones
public class QuickUnion {
    private int[] parent;

    public QuickUnion(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    // Encuentra la raíz de p
    private int root(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ; // Unión rápida
    }

    public static void main(String[] args) {
        // Creamos una estructura con 10 elementos (0 a 9)
        QuickUnion qu = new QuickUnion(10);

        // Hacemos algunas uniones
        qu.union(1, 2); // Componente de 2 se une al de 1.
        qu.union(6, 1); // Componente de 6 se une al de 1.
        qu.union(7, 8); // Componente de 8 se une al de 7.

        System.out.println("¿Están conectados 2 y 6? " + qu.connected(2, 6)); // Salida: true
        System.out.println("¿Están conectados 1 y 7? " + qu.connected(1, 7)); // Salida: false

        // Unimos los dos componentes
        qu.union(2, 7);
        System.out.println("¿Están conectados 2 y 7? " + qu.connected(2, 7)); // Salida: true
    }
}