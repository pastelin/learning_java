import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int n;         // Número de elementos en el deque
    private Node first;   // Nodo del frente
    private Node last;    // Nodo del final

    // Clase interna para el nodo de la lista doblemente enlazada
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    /**
     * Construye un deque vacío.
     */
    public Deque() {
        first = null;
        last = null;
        n = 0;
    }

    /**
     * ¿Está el deque vacío?
     * @return true si el deque está vacío, false en caso contrario.
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Retorna el número de elementos en el deque.
     * @return el número de elementos.
     */
    public int size() {
        return n;
    }

    /**
     * Agrega el item al frente.
     * @param item el item a agregar.
     * @throws IllegalArgumentException si el item es null.
     */
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("El argumento no puede ser null.");
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.prev = null;
        first.next = oldFirst;
        if (isEmpty()) {
            last = first;
        } else {
            oldFirst.prev = first;
        }
        n++;
    }

    /**
     * Agrega el item al final.
     * @param item el item a agregar.
     * @throws IllegalArgumentException si el item es null.
     */
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("El argumento no puede ser null.");
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.prev = oldLast;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    /**
     * Remueve y retorna el item del frente.
     * @return el item del frente.
     * @throws NoSuchElementException si el deque está vacío.
     */
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("El deque está vacío.");
        }
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) {
            last = null; // Mantiene el invariante
        } else {
            first.prev = null;
        }
        return item;
    }

    /**
     * Remueve y retorna el item del final.
     * @return el item del final.
     * @throws NoSuchElementException si el deque está vacío.
     */
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("El deque está vacío.");
        }
        Item item = last.item;
        last = last.prev;
        n--;
        if (isEmpty()) {
            first = null; // Mantiene el invariante
        } else {
            last.next = null;
        }
        return item;
    }

    /**
     * Retorna un iterador sobre los items en orden del frente hacia atrás.
     * @return un iterador sobre los items.
     */
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // Clase interna para el iterador
    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException("El método remove() no es compatible.");
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más items para retornar.");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Unit testing (requerido).
     */
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        System.out.println("isEmpty (true): " + deque.isEmpty()); // true

        // addFirst y addLast
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0); // Deque: 0 -> 1 -> 2
        System.out.println("size (3): " + deque.size()); // 3

        // removeFirst
        System.out.println("removeFirst (0): " + deque.removeFirst()); // 0
        System.out.println("size (2): " + deque.size()); // 2

        // removeLast
        System.out.println("removeLast (2): " + deque.removeLast()); // 2
        System.out.println("size (1): " + deque.size()); // 1

        // Iterador
        deque.addLast(3); // Deque: 1 -> 3
        System.out.println("Items en el deque (1, 3):");
        for (int item : deque) {
            System.out.print(item + " "); // 1 3
        }
        System.out.println();
        System.out.println("size (2): " + deque.size()); // 2

        // Probar excepciones
        try {
            deque.addFirst(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción de argumento nulo atrapada: " + e.getMessage());
        }

        System.out.println("removeFirst (1): " + deque.removeFirst());
        System.out.println("removeLast (3): " + deque.removeLast());

        try {
            deque.removeFirst();
        } catch (NoSuchElementException e) {
            System.out.println("Excepción de deque vacío atrapada: " + e.getMessage());
        }
    }
}