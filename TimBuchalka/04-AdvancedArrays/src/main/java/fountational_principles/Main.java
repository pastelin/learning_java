package fountational_principles;

import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        // Declaración e inicialización de un arreglo de enteros con tamaño 10
        int[] myIntArray = new int[10];
        // myIntArray[0] = 10.25; // Esto causará un error de compilación porque 10.25 no es un entero
        myIntArray[5] = 50; // Asignación de un valor entero al índice 5
        // myIntArray[8] = '70'; // Esto causará un error de compilación porque '70' no es un entero válido

        // Declaración e inicialización de un arreglo de números decimales (double) con tamaño 10
        double[] myDoubleArray = new double[10];
        myDoubleArray[5] = 3.14159; // Asignación de un valor decimal al índice 5

        // Imprimir valores específicos de los arreglos
        System.out.println("Integer Array Element at index 5: " + myIntArray[5]);
        System.out.println("Double Array Element at index 5: " + myDoubleArray[5]);

        // Declaración e inicialización de un arreglo con valores predefinidos
        int[] firstTen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("First element of firstTen array: " + firstTen[0]); // Primer elemento del arreglo
        int arrayLength = firstTen.length; // Obtener la longitud del arreglo
        System.out.println("Length of firstTen array: " + arrayLength); // Imprimir la longitud
        System.out.println("Last element of firstTen array: " + firstTen[arrayLength - 1]); // Último elemento

        // Declaración e inicialización de un arreglo usando la palabra clave 'new'
        int[] newArray;
        newArray = new int[]{1, 2, 3, 4, 5};

        // Recorrer el arreglo con un bucle for
        for (int i = 0; i < newArray.length; i++) {
            System.out.println("Element at index " + i + ": " + newArray[i]);
        }

        // Ejemplo adicional: Uso de un bucle for-each para recorrer un arreglo
        System.out.println("Using for-each loop:");
        for (int value : newArray) {
            System.out.println("Value: " + value);
        }

        // Ejemplo adicional: Modificar elementos de un arreglo
        System.out.println("Modifying array elements:");
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] *= 2; // Multiplicar cada elemento por 2
            System.out.println("Modified element at index " + i + ": " + newArray[i]);
        }

        // Ejemplo adicional: Manejo de índices fuera de rango
        try {
            System.out.println(newArray[10]); // Esto lanzará una excepción porque el índice 10 no existe
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Intentaste acceder a un índice fuera de rango.");
        }

        // Imprimir una línea en blanco para separar secciones
        System.out.println();

        // Imprimir el contenido del arreglo `newArray` como una cadena
        // Arrays.toString convierte el arreglo en una representación legible como "[2, 4, 6, 8, 10]"
        System.out.println(Arrays.toString(newArray));

        // Asignar el arreglo `newArray` a una variable de tipo Object
        Object objectVariable = newArray;

        // Verificar si la variable `objectVariable` es realmente un arreglo de enteros
        // instanceof se utiliza para comprobar el tipo en tiempo de ejecución
        if (objectVariable instanceof int[]) {
            System.out.println("Object Variable is really an int array");
        }

        // Declarar un arreglo de objetos con capacidad para 3 elementos
        Object[] objectArray = new Object[3];

        // Asignar diferentes tipos de objetos al arreglo
        objectArray[0] = "Hello"; // Una cadena de texto
        objectArray[1] = new StringBuilder("World"); // Un objeto StringBuilder
        objectArray[2] = newArray; // El arreglo de enteros `newArray`

        // Nota: Este ejemplo muestra cómo un arreglo de tipo Object puede almacenar diferentes tipos de datos,
        // pero también cómo se pueden realizar comprobaciones de tipo en tiempo de ejecución.

    }
}
