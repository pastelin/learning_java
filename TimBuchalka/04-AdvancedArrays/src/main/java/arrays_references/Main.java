package arrays_references;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        // Declaración e inicialización de un arreglo de enteros con tamaño 5
        int[] myIntArray = new int[5];

        // Asignación de la referencia del arreglo myIntArray a anotherArray
        int[] anotherArray = myIntArray;

        // Imprimir los valores iniciales de ambos arreglos
        System.out.println("myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("anotherArray = " + Arrays.toString(anotherArray));

        // Modificar el primer elemento del arreglo anotherArray
        anotherArray[0] = 1;

        // Llamar al método modifyArray para modificar el segundo elemento del arreglo
        modifyArray(myIntArray);

        // Imprimir los valores de ambos arreglos después de los cambios
        System.out.println("after change myIntArray = " + Arrays.toString(myIntArray));
        System.out.println("after change anotherArray = " + Arrays.toString(anotherArray));
    }

    // Método que modifica el segundo elemento del arreglo recibido como parámetro
    private static void modifyArray(int[] array) {
        array[1] = 2;
    }
}
