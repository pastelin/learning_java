package arrays_helper_class;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Crear un arreglo de enteros con valores aleatorios
        int[] firstArray = getRandomArray(10);
        System.out.println("Arreglo aleatorio inicial: " + Arrays.toString(firstArray));

        // Ordenar el arreglo en orden ascendente
        Arrays.sort(firstArray);
        System.out.println("Arreglo ordenado: " + Arrays.toString(firstArray));

        // Crear un arreglo de enteros con valores predeterminados (0 por defecto)
        int[] secondArray = new int[10];
        System.out.println("Arreglo vacío: " + Arrays.toString(secondArray));

        // Llenar el arreglo con el valor 5
        Arrays.fill(secondArray, 5);
        System.out.println("Arreglo lleno con 5: " + Arrays.toString(secondArray));

        // Crear otro arreglo aleatorio
        int[] thirdArray = getRandomArray(10);
        System.out.println("Otro arreglo aleatorio: " + Arrays.toString(thirdArray));

        // Copiar el contenido de un arreglo a otro
        int[] fourthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println("Copia del tercer arreglo: " + Arrays.toString(fourthArray));

        // Ordenar el arreglo copiado y comparar con el original
        Arrays.sort(fourthArray);
        System.out.println("Tercer arreglo sin ordenar: " + Arrays.toString(thirdArray));
        System.out.println("Cuarto arreglo ordenado: " + Arrays.toString(fourthArray));

        // Crear un arreglo más pequeño a partir de una copia
        int[] smallerArray = Arrays.copyOf(thirdArray, 5);
        System.out.println("Arreglo más pequeño: " + Arrays.toString(smallerArray));

        // Crear un arreglo más grande a partir de una copia
        int[] largerArray = Arrays.copyOf(thirdArray, 15);
        System.out.println("Arreglo más grande: " + Arrays.toString(largerArray));

        // Trabajar con arreglos de cadenas
        String[] sArray = {"Able", "Jane", "Mark", "Ralph", "David"};
        Arrays.sort(sArray); // Ordenar alfabéticamente
        System.out.println("Arreglo de cadenas ordenado: " + Arrays.toString(sArray));

        // Buscar un elemento en el arreglo ordenado
        if (Arrays.binarySearch(sArray, "Mark") >= 0) {
            System.out.println("Se encontró 'Mark' en el arreglo.");
        }

        // Comparar dos arreglos para verificar si son iguales
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {1, 2, 3, 4, 5};

        if (Arrays.equals(s1, s2)) {
            System.out.println("Los arreglos s1 y s2 son iguales.");
        } else {
            System.out.println("Los arreglos s1 y s2 no son iguales.");
        }
    }

    // Método para generar un arreglo de enteros aleatorios
    private static int[] getRandomArray(int len) {
        Random random = new Random();
        int[] newInt = new int[len];

        // Llenar el arreglo con números aleatorios entre 0 y 99
        for (int i = 0; i < len; i++) {
            newInt[i] = random.nextInt(100);
        }

        return newInt;
    }
}
