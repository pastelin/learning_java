package sorting.insertion_sort;

public class SortingExamples {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i]; // El elemento que vamos a insertar
            int j = i - 1;

            /*
             * Mueve los elementos de arr[0..i-1] que son mayores que key
             * a una posición adelante de su posición actual.
             */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key; // Inserta la llave en su posición correcta
        }
    }

    public static void main(String[] args) {
        int[] data = {12, 11, 13, 5, 6};
        insertionSort(data);
        // data ahora es {5, 6, 11, 12, 13}
        System.out.println("Insertion Sort: " + java.util.Arrays.toString(data));
    }
}