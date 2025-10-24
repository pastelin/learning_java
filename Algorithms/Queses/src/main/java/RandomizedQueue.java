import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom; // Usado para operaciones aleatorias

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a;    // Arreglo de items
    private int n;       // Número de elementos en el randomized queue

    /**
     * Construye un randomized queue vacío.
     */
    public RandomizedQueue() {
        a = (Item[]) new Object[2];
        n = 0;
    }

    /**
     * ¿Está el randomized queue vacío?
     * @return true si el queue está vacío, false en caso contrario.
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Retorna el número de items en el randomized queue.
     * @return el número de items.
     */
    public int size() {
        return n;
    }

    // Redimensiona el arreglo subyacente al tamaño capacity
    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    /**
     * Agrega el item.
     * @param item el item a agregar.
     * @throws IllegalArgumentException si el item es null.
     */
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("El argumento no puede ser null.");
        }
        if (n == a.length) {
            resize(2 * a.length);
        }
        a[n++] = item;
    }

    /**
     * Remueve y retorna un item aleatorio.
     * @return el item aleatorio.
     * @throws NoSuchElementException si el randomized queue está vacío.
     */
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("El randomized queue está vacío.");
        }
        int randomIndex = StdRandom.uniformInt(n);
        Item item = a[randomIndex];

        // Mover el último item al espacio del item removido para evitar agujeros
        a[randomIndex] = a[n - 1];
        a[n - 1] = null; // Evitar 'loitering'
        n--;

        // Redimensionar si es necesario (cuando el arreglo está 1/4 lleno)
        if (n > 0 && n == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    /**
     * Retorna un item aleatorio (pero no lo remueve).
     * @return el item aleatorio.
     * @throws NoSuchElementException si el randomized queue está vacío.
     */
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("El randomized queue está vacío.");
        }
        int randomIndex = StdRandom.uniformInt(n);
        return a[randomIndex];
    }

    /**
     * Retorna un iterador independiente sobre los items en orden aleatorio.
     * @return un iterador sobre los items.
     */
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    // Clase interna para el iterador
    private class RandomizedQueueIterator implements Iterator<Item> {
        private final Item[] shuffledArray;
        private int current;

        public RandomizedQueueIterator() {
            // Copia los elementos actuales
            shuffledArray = (Item[]) new Object[n];
            for (int i = 0; i < n; i++) {
                shuffledArray[i] = a[i];
            }
            // Mezcla la copia de forma aleatoria (O(n) construcción)
            StdRandom.shuffle(shuffledArray);
            current = 0;
        }

        public boolean hasNext() {
            return current < n;
        }

        public void remove() {
            throw new UnsupportedOperationException("El método remove() no es compatible.");
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más items para retornar.");
            }
            return shuffledArray[current++];
        }
    }

    /**
     * Unit testing (requerido).
     */
    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        System.out.println("isEmpty (true): " + queue.isEmpty()); // true

        // enqueue
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("size (3): " + queue.size()); // 3

        // sample
        System.out.println("sample: " + queue.sample());
        System.out.println("sample: " + queue.sample());

        // dequeue
        System.out.println("dequeue: " + queue.dequeue());
        System.out.println("size (2): " + queue.size()); // 2

        // Iterador
        System.out.print("Iterador 1 (orden aleatorio): ");
        for (String item : queue) {
            System.out.print(item + " ");
        }
        System.out.println();

        System.out.print("Iterador 2 (orden aleatorio independiente): ");
        for (String item : queue) {
            System.out.print(item + " ");
        }
        System.out.println();

        // Probar excepciones
        queue.dequeue();
        queue.dequeue();

        try {
            queue.enqueue(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción de argumento nulo atrapada: " + e.getMessage());
        }

        try {
            queue.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Excepción de queue vacío atrapada: " + e.getMessage());
        }
    }
}