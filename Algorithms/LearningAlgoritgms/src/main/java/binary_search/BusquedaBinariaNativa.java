package binary_search;

import java.util.Arrays;

public class BusquedaBinariaNativa {

    public static void main(String[] args) {
        int[] numeros = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91}; // Arreglo ya ordenado

        // --- Caso 1: Elemento encontrado ---
        int objetivo1 = 23;
        int indice1 = Arrays.binarySearch(numeros, objetivo1);
        System.out.println("Buscando el número " + objetivo1 + "...");
        System.out.println("El método Arrays.binarySearch() devolvió: " + indice1);

        // --- Caso 2: Elemento NO encontrado ---
        int objetivo2 = 40;
        int indice2 = Arrays.binarySearch(numeros, objetivo2);
        System.out.println("\nBuscando el número " + objetivo2 + "...");
        System.out.println("El método Arrays.binarySearch() devolvió: " + indice2);

        // Interpretación del resultado negativo:
        // El resultado es (-(punto de inserción) - 1).
        // El punto de inserción es el índice donde el elemento DEBERÍA estar si existiera.
        // Para 40, debería estar en el índice 7. Entonces, el resultado es (-(7) - 1) = -8.
        if (indice2 < 0) {
            int puntoDeInsercion = -(indice2 + 1);
            System.out.println("El elemento no se encontró. Debería insertarse en el índice " + puntoDeInsercion + " para mantener el orden.");
        }
    }
}