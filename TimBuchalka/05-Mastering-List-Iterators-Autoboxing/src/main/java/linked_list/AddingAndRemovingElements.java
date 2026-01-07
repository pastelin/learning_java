package linked_list;

import java.util.LinkedList;
import java.util.ListIterator;

public class AddingAndRemovingElements {

    public static void main(String[] args) {
        // Crear una LinkedList de tipo String
        // LinkedList es una estructura de datos que permite agregar y eliminar elementos de manera eficiente
        var placesToVisit = new LinkedList<String>();

        // Agregar elementos a la lista
        placesToVisit.add("Sydney"); // Agrega "Sydney" al final de la lista
        placesToVisit.add(0, "Melbourne"); // Agrega "Melbourne" en el índice 0 (al inicio de la lista)
        System.out.println(placesToVisit); // Imprime la lista actual

        // Llamar al método para agregar más elementos
        addMoreElements(placesToVisit);
        System.out.println(placesToVisit); // Imprime la lista después de agregar más elementos

        // Llamar al método para eliminar elementos
//        removeElements(placesToVisit);
//        System.out.println(placesToVisit); // Imprime la lista después de eliminar elementos

        // Llamar al método para obtener elementos
//        gettingElements(placesToVisit);

        // Imprimir el itinerario del viaje
        printItinerary(placesToVisit);
    }

    private static void addMoreElements(LinkedList<String> list) {
        // Agregar elementos al inicio y al final de la lista
        list.addFirst("Adelaide"); // Agrega "Adelaide" al inicio de la lista
        list.addLast("Perth"); // Agrega "Perth" al final de la lista

        // Métodos de cola (Queue)
        list.offer("Darwin"); // Agrega "Darwin" al final de la lista (similar a addLast)
        list.offerFirst("Alice Springs"); // Agrega "Alice Springs" al inicio de la lista
        list.offerLast("Canberra"); // Agrega "Canberra" al final de la lista
    }

    private static void removeElements(LinkedList<String> list) {
        // Eliminar elementos por valor y por índice
        list.remove("Alice Springs"); // Elimina "Alice Springs" de la lista
        list.remove(3); // Elimina el elemento en el índice 3
        System.out.println(list); // Imprime la lista después de las eliminaciones

        // Eliminar el último y el primer elemento
        String perth = list.removeLast(); // Elimina y devuelve el último elemento
        System.out.println("Removed last element: " + perth);
        String adelaide = list.removeFirst(); // Elimina y devuelve el primer elemento
        System.out.println("Removed first element: " + adelaide);

        // Eliminar el primer elemento usando remove()
        String s1 = list.remove(); // Elimina y devuelve el primer elemento
        System.out.println("Removed using remove(): " + s1);

        // Métodos de cola para eliminar elementos
        String p1 = list.poll(); // Elimina y devuelve el primer elemento (similar a remove())
        System.out.println("Removed using poll(): " + p1);
        String c1 = list.pollFirst(); // Elimina y devuelve el primer elemento
        System.out.println("Removed using pollFirst(): " + c1);
        String d1 = list.pollLast(); // Elimina y devuelve el último elemento
        System.out.println("Removed using pollLast(): " + d1);

        // Métodos de pila (Stack)
        list.push("Brisbane"); // Agrega "Brisbane" al inicio de la lista (como una pila)
        list.push("Cairns"); // Agrega "Cairns" al inicio de la lista
        list.push("Townsville"); // Agrega "Townsville" al inicio de la lista
        System.out.println("After pushing elements: " + list); // Imprime la lista después de agregar elementos

        // Eliminar el primer elemento usando pop() (como en una pila)
        String t1 = list.pop(); // Elimina y devuelve el primer elemento
        System.out.println("Popped element: " + t1);
    }

    private static void gettingElements(LinkedList<String> list) {
        System.out.println("Retrieved element: " + list.get(4)); // Obtiene el elemento en el índice 4
        System.out.println("First element: " + list.getFirst()); // Obtiene el primer elemento
        System.out.println("Last element: " + list.getLast()); // Obtiene el último elemento

        System.out.println("Adelaide is at index: " + list.indexOf("Adelaide")); // Obtiene el índice de "Adelaide"
        System.out.println("Darwin is at index: " + list.lastIndexOf("Darwin")); // Obtiene el índice de "Darwin"

        // Queue methods to retrieve elements
        System.out.println("Element from element(): " + list.element()); // Obtiene el primer elemento (similar a getFirst())

        // Stack methods to retrieve elements
        System.out.println("Peek first element: " + list.peek()); // Obtiene el primer elemento sin eliminarlo
        System.out.println("Peek first element using peekFirst(): " + list.peekFirst()); // Obtiene el primer elemento sin eliminarlo
        System.out.println("Peek last element using peekLast(): " + list.peekLast()); // Obtiene el último elemento sin eliminarlo
    }

    public static void printItinerary(LinkedList<String> list) {
        // Este método imprime el itinerario del viaje utilizando un bucle for.
        // Se asume que la lista contiene una secuencia de lugares a visitar.

        // Imprime el punto de inicio del viaje (primer elemento de la lista).
        System.out.println("Trip starts at: " + list.getFirst());

        // Recorre la lista desde el segundo elemento hasta el último.
        for (int i = 1; i < list.size(); i++) {
            // Imprime el trayecto desde el lugar anterior al actual.
            System.out.println("--> From: " + list.get(i - 1) + " to " + list.get(i));
        }

        // Imprime el punto final del viaje (último elemento de la lista).
        System.out.println("Trip ends at: " + list.getLast());
    }

    public static void printItinerary2(LinkedList<String> list) {
        // Este método imprime el itinerario del viaje utilizando un ListIterator.
        // Es útil cuando se necesita más control sobre la iteración.

        // Imprime el punto de inicio del viaje (primer elemento de la lista).
        System.out.println("Trip starts at: " + list.getFirst());

        // Variable para rastrear la ubicación anterior durante la iteración.
        String previousLocation = list.getFirst();

        // Crea un ListIterator que comienza desde el segundo elemento (índice 1).
        ListIterator<String> iterator = list.listIterator(1);

        // Itera sobre los elementos restantes de la lista.
        while (iterator.hasNext()) {
            // Obtiene el siguiente lugar en el itinerario.
            String town = iterator.next();

            // Imprime el trayecto desde la ubicación anterior al lugar actual.
            System.out.println("--> From: " + previousLocation + " to " + town);

            // Actualiza la ubicación anterior al lugar actual.
            previousLocation = town;
        }

        // Imprime el punto final del viaje (último elemento de la lista).
        System.out.println("Trip ends at: " + list.getLast());
    }

    private static void testIterator(LinkedList<String> list) {
        // Este método demuestra el uso de un ListIterator para modificar y recorrer una LinkedList.

        // Crea un ListIterator para recorrer la lista desde el principio.
        var iterator = list.listIterator();

        // Itera sobre los elementos de la lista.
        while (iterator.hasNext()) {
            // Si el elemento actual es "Brisbane", agrega "Lake Wivenhoe" después de él.
            if (iterator.next().equals("Brisbane")) {
                iterator.add("Lake Wivenhoe");
            }
        }

        // Recorre la lista en sentido inverso (de atrás hacia adelante).
        while (iterator.hasPrevious()) {
            System.out.println("Iterator next: " + iterator.previous());
        }

        // Imprime la lista después de las modificaciones.
        System.out.println(list);

        // Crea un nuevo ListIterator que comienza desde el índice 3.
        var iterator2 = list.listIterator(3);

        // Imprime el siguiente elemento desde el índice 3.
        System.out.println(iterator2.next());
    }
}