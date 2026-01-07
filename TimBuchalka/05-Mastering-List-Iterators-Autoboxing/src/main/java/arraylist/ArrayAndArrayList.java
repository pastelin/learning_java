package arraylist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArrayAndArrayList {


    /*
    Explicaciones adicionales:

    ** Arrays.asList:
    Convierte un arreglo en una lista fija respaldada por el arreglo original.
    Los cambios en la lista afectan al arreglo y viceversa.
    No permite agregar ni eliminar elementos, ya que el tamaño de la lista es fijo.

    ** sort:
    Ordena la lista en orden natural (alfabético para Strings).
    Si la lista está respaldada por un arreglo, este también se ordenará.

    ** Excepciones comunes:
    Intentar agregar o eliminar elementos de una lista creada con Arrays.asList lanzará UnsupportedOperationException.

    ** Ejemplo complementario: Si necesitas una lista mutable, puedes usar:
    List<String> mutableList = new ArrayList<>(Arrays.asList("Sunday", "Monday", "Tuesday"));
    mutableList.add("Wednesday"); // Esto funcionará
    System.out.println(mutableList);
     */
    public static void main(String[] args) {

        // Crear un arreglo de Strings con tres elementos
        String[] originalArray = new String[]{"First", "Second", "Third"};

        // Convertir el arreglo en una lista fija respaldada por el arreglo original
        // Nota: Los cambios en la lista afectarán al arreglo y viceversa
        var originalList = Arrays.asList(originalArray);

        // Modificar el primer elemento de la lista (y del arreglo, ya que están vinculados)
        originalList.set(0, "one");
        System.out.println("list: " + originalList); // Imprime la lista modificada
        System.out.println("array: " + Arrays.toString(originalArray)); // Imprime el arreglo modificado

        // Ordenar la lista en orden natural (alfabético)
        // Esto también ordenará el arreglo original, ya que están vinculados
        originalList.sort(Comparator.naturalOrder());
        System.out.println("Array: " + Arrays.toString(originalArray)); // Imprime el arreglo ordenado

        // Intentar agregar un nuevo elemento a la lista lanzará UnsupportedOperationException
        // Esto se debe a que Arrays.asList crea una lista de tamaño fijo
        // originalList.add("Fourth"); // Descomentar para ver la excepción

        // Crear una nueva lista fija directamente con elementos
        List<String> newList = Arrays.asList("Sunday", "Monday", "Tuesday");
        System.out.println(newList); // Imprime la nueva lista

        // Intentar agregar un nuevo elemento a esta lista también lanzará UnsupportedOperationException
        // newList.add("Wednesday"); // Descomentar para ver la excepción
    }
}
