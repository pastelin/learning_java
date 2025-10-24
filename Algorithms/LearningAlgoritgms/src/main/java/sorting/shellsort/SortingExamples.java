package sorting.shellsort;

public class SortingExamples {

    public static void shellSort(int[] arr) {
        int n = arr.length;
        int h = 1;

        // Calcula la secuencia de gaps (secuencia de Knuth: 1, 4, 13, 40, ...)
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        // Comienza con el gap más grande y lo reduce
        while (h >= 1) {
            // Realiza un h-sort (similar a insertion sort, pero con saltos de 'h')
            for (int i = h; i < n; i++) {
                // Inserta arr[i] en la sublista de elementos separados por 'h'
                int temp = arr[i];
                int j = i;
                while (j >= h && arr[j - h] > temp) {
                    arr[j] = arr[j - h];
                    j -= h;
                }
                arr[j] = temp;
            }
            // Pasa al siguiente gap (más pequeño)
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        int[] data = {81, 94, 11, 96, 12, 35, 17, 95, 28, 58};
        shellSort(data);
        // data ahora es {11, 12, 17, 28, 35, 58, 81, 94, 95, 96}
        System.out.println("Shellsort: " + java.util.Arrays.toString(data));
    }
}