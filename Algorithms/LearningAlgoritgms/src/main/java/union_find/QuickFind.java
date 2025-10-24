package union_find;

public class QuickFind {

    private int[] id; // id[i] = identificador del componente de i

    /**
     * Constructor: Inicializa la estructura con N elementos,
     * cada uno en su propio componente.
     */
    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i; // Al inicio, cada elemento es su propio componente
        }
    }

    /**
     * Verifica si p y q están en el mismo componente.
     * Esta operación es muy rápida (O(1)).
     */
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    /**
     * Une los componentes de p y q.
     * Esta operación es lenta (O(N)).
     */
    public void union(int p, int q) {
        int pID = id[p];
        int qID = id[q];

        // Si ya tienen el mismo ID, están conectados, no hacemos nada.
        if (pID == qID) {
            return;
        }

        // Recorremos todo el arreglo para cambiar el ID de los elementos
        // del componente de q al componente de p.
        for (int i = 0; i < id.length; i++) {
            if (id[i] == qID) {
                id[i] = pID;
            }
        }
    }

    public static void main(String[] args) {
        // Creamos una estructura con 10 elementos (0 a 9)
        QuickFind qf = new QuickFind(10);

        // Hacemos algunas uniones
        qf.union(1, 2); // Componente de 2 se une al de 1. id[2] ahora es 1.
        qf.union(6, 1); // Componente de 6 se une al de 1. id[6] ahora es 1.
        qf.union(7, 8); // Componente de 8 se une al de 7. id[8] ahora es 7.

        System.out.println("¿Están conectados 2 y 6? " + qf.connected(2, 6)); // Salida: true
        System.out.println("¿Están conectados 1 y 7? " + qf.connected(1, 7)); // Salida: false

        // Unimos los dos componentes
        qf.union(1, 8); // El componente de 8 (id=7) se une al de 1 (id=1).
        // id[7] y id[8] ahora serán 1.

        System.out.println("¿Están conectados 1 y 7? " + qf.connected(1, 7)); // Salida: true
    }
}