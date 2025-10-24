package sorting.selection_sort;

public class SortingExamples {

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // Itera a través de todo el arreglo para establecer la posición correcta
        for (int i = 0; i < n - 1; i++) {
            // Asume que el elemento actual es el mínimo
            int minIndex = i;

            // Busca el elemento realmente mínimo en el resto del arreglo
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Encontró un nuevo mínimo, guarda su índice
                }
            }

            // Intercambia el mínimo encontrado con el elemento de la posición actual (i)
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] data = {29, 20, 73, 34, 64};
        selectionSort(data);
        // data ahora es {20, 29, 34, 64, 73}
        System.out.println("Selection Sort: " + java.util.Arrays.toString(data));
    }
}