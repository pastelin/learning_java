import edu.princeton.cs.algs4.StdRandom; // Para generar números aleatorios
import edu.princeton.cs.algs4.StdStats;   // Para calcular la media y la desviación estándar

public class PercolationStats {

    private final double[] percolationThresholds; // Array para almacenar los umbrales de percolación
    private final int trials; // Número de experimentos a realizar

    /**
     * Realiza 'trials' experimentos independientes en una cuadrícula de n-por-n.
     *
     * @param n      El tamaño de la cuadrícula.
     * @param trials El número de experimentos.
     * @throws IllegalArgumentException si n <= 0 o trials <= 0.
     */
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("n y trials deben ser mayores que 0");
        }

        this.trials = trials;
        percolationThresholds = new double[trials]; // Arreglo para guardar los resultados de cada prueba

        // Bucle principal para ejecutar 'trials' experimentos
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n); // Crear una nueva cuadrícula de percolación
            int openedSites = 0; // Bucle principal para ejecutar 'trials' experimentos

            // Bucle que abre sitios al azar hasta que el sistema percole
            while(!percolation.percolates()){ // Repite hasta que percole
                int row, col;

                do {
                    // Elige un sitio uniformemente al azar entre todos los sitios (1 a n)
                    row = StdRandom.uniformInt(1, n + 1);
                    col = StdRandom.uniformInt(1, n + 1);
                } while (percolation.isOpen(row, col));

                percolation.open(row, col); // Abre el sitio seleccionado
                openedSites++; // Incrementa el contador de sitios abiertos
            }

            // Cuando percola, calcula la fracción de sitios abiertos para este experimento
            percolationThresholds[i] = (double) openedSites / (n * n);
        }
    }

    /**
     * Media muestral del umbral de percolación.
     * @return La media de los umbrales de percolación.
     */
    public double mean() {
        return StdStats.mean(percolationThresholds);
    }

    /**
     * Desviación estándar muestral del umbral de percolación.
     * @return La desviación estándar de los umbrales de percolación.
     */
    public double stddev() {
        // Si solo hay un ensayo, la desviación estándar es NaN (no se puede calcular).
        if(trials == 1) {
            return Double.NaN;
        }

        return StdStats.stddev(percolationThresholds);
    }

    /**
     * Extremo inferior del intervalo de confianza del 95%.
     * @return El límite inferior del intervalo de confianza.
     */
    public double confidenceLo() {
        // Fórmula del intervalo de confianza: media - (1.96 * stddev / sqrt(trials))
        return mean() - (1.96 * stddev() / Math.sqrt(trials));
    }

    /**
     * Extremo superior del intervalo de confianza del 95%.
     * @return El límite superior del intervalo de confianza.
     */
    public double confidenceHi() {
        // Fórmula del intervalo de confianza: media + (1.96 * stddev / sqrt(trials))
        return mean() + (1.96 * stddev() / Math.sqrt(trials));
    }

    /**
     * Cliente de prueba: toma n y T como argumentos de línea de comandos,
     * realiza T experimentos y imprime los resultados.
     * @param args n (tamaño de la cuadrícula) y T (número de ensayos).
     */
    public static void main(String[] args) {
//        int n = Integer.parseInt(args[0]); // Lee n de los argumentos de línea de comandos
//        int trials = Integer.parseInt(args[1]); // Lee T (trials) de los argumentos de línea de comandos

        int n = 20; // Tamaño de la cuadrícula (puedes cambiarlo para pruebas)
        int trials = 10; // Número de ensayos (puedes cambiarlo para pruebas)

        // Crea una instancia de PercolationStats para ejecutar las simulaciones
        PercolationStats stats = new PercolationStats(n, trials);

        // Imprime los resultados formateados
        System.out.printf("mean                    = %f%n", stats.mean()); // [cite: 1]
        System.out.printf("stddev                  = %f%n", stats.stddev());// [cite: 1]
        System.out.printf("95%% confidence interval = [%f, %f]%n", stats.confidenceLo(), stats.confidenceHi()); //[cite: 1]
    }

}
