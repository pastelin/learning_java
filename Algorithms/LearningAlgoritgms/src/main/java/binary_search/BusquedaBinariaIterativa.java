package binary_search;

public class BusquedaBinariaIterativa {

    public int busquedaBinaria(int[] arreglo, int objetivo) {
        int left = 0;
        int right = arreglo.length - 1; // Límite derecho del arreglo

        while (left <= right) {
            // Calculamos el medio para evitar desbordamiento (overflow) con números grandes
            int middle = left + (right - left) / 2;

            // 1. Comparamos el valor del medio con el objetivo
            if (arreglo[middle] == objetivo) {
                return middle; // ¡Elemento encontrado! Devolvemos su índice.
            }

            // 2. Si el objetivo es más grande, ignoramos la mitad izquierda
            if (arreglo[middle] < objetivo) {
                left = middle + 1;
            }
            // 3. Si el objetivo es más pequeño, ignoramos la mitad derecha
            else {
                right = middle - 1;
            }
        }

        // Si el bucle termina, el elemento no se encontró
        return -1;
    }

    public static void main(String[] args) {
        BusquedaBinariaIterativa buscador = new BusquedaBinariaIterativa();
        int[] numeros = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91}; // Arreglo ORDENADO

        int objetivo1 = 23;
        int indice1 = buscador.busquedaBinaria(numeros, objetivo1);
        System.out.println("Buscando el número " + objetivo1 + "...");
        if (indice1 != -1) {
            System.out.println("Elemento encontrado en el índice: " + indice1);
        } else {
            System.out.println("Elemento no encontrado.");
        }

        System.out.println("---");

        int objetivo2 = 40;
        int indice2 = buscador.busquedaBinaria(numeros, objetivo2);
        System.out.println("Buscando el número " + objetivo2 + "...");
        if (indice2 != -1) {
            System.out.println("Elemento encontrado en el índice: " + indice2);
        } else {
            System.out.println("Elemento no encontrado.");
        }
    }
}
