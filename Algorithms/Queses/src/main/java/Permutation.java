import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {

    /**
     * Programa cliente que toma un entero k, lee strings de la entrada estándar 
     * e imprime k de ellas uniformemente al azar.
     * @param args el número de strings a imprimir (k)
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            StdOut.println("Uso: java Permutation k");
            return;
        }

        int k = Integer.parseInt(args[0]);

        if (k < 0) {
            throw new IllegalArgumentException("k debe ser no negativo.");
        }

        // Usamos RandomizedQueue para almacenar el reservorio de items.
        RandomizedQueue<String> rq = new RandomizedQueue<>();
        int n = 0; // Contador de strings leídas

        // Algoritmo de Reservorio de Muestreo (Reservoir Sampling)
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            n++;

            if (n <= k) {
                // Si el reservorio no está lleno, simplemente agregamos el item
                rq.enqueue(item);
            } else {
                // El reservorio está lleno (tiene k items).
                // Reemplazar un item aleatorio con probabilidad k/n.
                // StdRandom.uniformInt(n) retorna un entero entre [0, n-1].
                int r = StdRandom.uniformInt(n);
                if (r < k) {
                    // Si el índice aleatorio está en el rango [0, k-1],
                    // removemos un item aleatorio y agregamos el nuevo.
                    // Esto implementa la selección con probabilidad k/n.
                    // Si n=k+1, la probabilidad es k/(k+1) de reemplazar.
                    // El sampleo es de tamaño k, así que si r < k, se reemplaza.
                    // Como el RandomizedQueue elige un item al azar para dequeue,
                    // esto simula la selección aleatoria de un item a reemplazar
                    // del reservorio actual.
                    rq.dequeue();
                    rq.enqueue(item);
                }
            }
        }

        // Imprime los k items del randomized queue (el reservorio)
        for (String item : rq) {
            StdOut.println(item);
        }
    }
}