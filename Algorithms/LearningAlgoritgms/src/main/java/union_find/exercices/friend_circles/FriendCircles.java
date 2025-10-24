package union_find.exercices.friend_circles;

public class FriendCircles {

    private final int[] parent;
    private final int [] size;

    public FriendCircles(int n) {

        parent = new int[n];
        size = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i; // Cada persona es su propio padre al inicio
            size[i] = 1;   // Cada círculo de amigos tiene tamaño 1
        }
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q); // Verifica si p y q están en el mismo círculo
    }

    public void union (int p, int q) {
        int rootP = find(p); // Encontrar la raíz del componente de p
        int rootQ = find(q); // Encontrar la raíz del componente de q

        if (rootP == rootQ) return; // Ya están conectados

        // Unir los componentes
        if(size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ; // Hacer que el padre de rootP sea rootQ
            size[rootQ] += size[rootP]; // Aumentar el tamaño del componente de rootQ
        } else {
            parent[rootQ] = rootP; // Hacer que el padre de rootQ sea rootP
            size[rootP] += size[rootQ]; // Aumentar el tamaño del componente de rootP
        }

    }

    public int find(int p) {
        int root = p;

        while(root != parent[root]) {
            root = parent[root]; // Encontrar la raíz
        }

        // Comprimir el camino
        while(p != root) {
            int next = parent[p]; // Guardar el siguiente nodo
            parent[p] = root; // Hacer que p apunte directamente a la raíz
            p = next; // Mover p al siguiente nodo
        }

        return root;
    }

    public int getDistinctFriendCircles() {

        int distinctCircles = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) { // Si es su propio padre, es una raíz de un círculo
                distinctCircles++;
            }
        }
        return distinctCircles;
    }



    public static void main(String[] args) {

        FriendCircles fc = new FriendCircles(5);

        fc.union(0, 1); // Persona 0 y 1 están en el mismo círculo
        fc.union(1, 2); // Persona 1 y 2 están en el mismo círculo
        fc.union(3, 4); // Persona 3 y 4 están en el mismo círculo

        System.out.println("¿Están conectados 0 y 2? " + fc.connected(0, 2)); // Salida: true
        System.out.println("¿Están conectados 0 y 3? " + fc.connected(0, 3)); // Salida: false
        System.out.println("¿Están conectados 3 y 4? " + fc.connected(3, 4)); // Salida: true
        System.out.println("¿Están conectados 2 y 4? " + fc.connected(2, 4)); // Salida: false

        System.out.println("Número de círculos de amigos distintos: " + fc.getDistinctFriendCircles()); // Salida: 2

    }

}
