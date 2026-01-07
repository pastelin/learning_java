package arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SomeMethods {

    public static void main(String[] args) {
        // Crear un arreglo de Strings
        String[] items = {"apple", "banana", "cherry", "elderberry"};
        // Convertir el arreglo en una lista inmutable (no se puede modificar)
        List<String> list = List.of(items);
        System.out.println(list); // Imprime la lista
        System.out.println(list.getClass().getName()); // Imprime el tipo de clase de la lista
        // list.add("fig"); // Esto lanzará UnsupportedOperationException porque la lista es inmutable

        // Crear un ArrayList mutable a partir de la lista inmutable
        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("fig"); // Agregar un nuevo elemento al ArrayList
        System.out.println(groceries); // Imprime el ArrayList

        // Crear otro ArrayList directamente con elementos
        ArrayList<String> nextList = new ArrayList<>(
                List.of("grape", "honeydew", "kiwi"));
        System.out.println(nextList); // Imprime el nuevo ArrayList

        // Combinar dos listas usando addAll
        groceries.addAll(nextList); // Agrega todos los elementos de nextList a groceries
        System.out.println(groceries); // Imprime la lista combinada

        // Obtener un elemento por su índice
        System.out.println("Third item: " + groceries.get(2)); // Accede al tercer elemento (índice 2)

        // Verificar si un elemento está en la lista
        if (groceries.contains("banana")) { // contains verifica si "banana" está en la lista
            System.out.println("Banana is in the list.");
        }

        // Agregar un elemento duplicado y buscar sus índices
        groceries.add("banana"); // Agrega un duplicado de "banana"
        System.out.println("First index of banana: " + groceries.indexOf("banana")); // Índice de la primera ocurrencia
        System.out.println("Last index of banana: " + groceries.lastIndexOf("banana")); // Índice de la última ocurrencia

        // Eliminar elementos por índice y por valor
        groceries.remove(1); // Elimina el elemento en el índice 1
        System.out.println(groceries); // Imprime la lista después de eliminar
        groceries.remove("banana"); // Elimina la primera ocurrencia de "banana"
        System.out.println(groceries); // Imprime la lista después de eliminar

        // Eliminar todos los elementos que coincidan con una lista dada
        groceries.removeAll(List.of("apples", "eggs")); // Elimina todos los elementos que coincidan
        System.out.println(groceries); // Imprime la lista después de eliminar

        // Retener solo los elementos que coincidan con una lista dada
        groceries.retainAll(List.of("banana", "fig", "kiwi")); // Retiene solo los elementos especificados
        System.out.println(groceries); // Imprime la lista después de retener

        // Limpiar la lista
        groceries.clear(); // Elimina todos los elementos de la lista
        System.out.println(groceries); // Imprime la lista vacía
        System.out.println("Is the groceries list empty? " + groceries.isEmpty()); // Verifica si la lista está vacía

        // Agregar múltiples elementos usando addAll y Arrays.asList
        groceries.addAll(List.of("apples", "milk", "mustard", "cheese")); // Agrega elementos usando List.of
        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham")); // Agrega elementos usando Arrays.asList

        // Ordenar la lista en orden natural
        groceries.sort(Comparator.naturalOrder()); // Ordena en orden alfabético ascendente
        System.out.println(groceries); // Imprime la lista ordenada

        // Ordenar la lista en orden inverso
        groceries.sort(Comparator.reverseOrder()); // Ordena en orden alfabético descendente
        System.out.println(groceries); // Imprime la lista ordenada en orden inverso

        // Convertir la lista a un arreglo
        var groceryArray = groceries.toArray(new String[groceries.size()]); // Convierte la lista a un arreglo
        System.out.println(Arrays.toString(groceryArray)); // Imprime el arreglo


    }
}
