package matrices;

import java.util.Arrays;

public class Ejercicio04 {

    public static void main(String[] args) {
        int[] matriz = new int[10];
        llenarMatrizConMetodoFill(matriz);
        System.out.println("Valores de la matriz: " + Arrays.toString(matriz));
    }

    private static void llenarMatrizConMetodoFill(int[] matriz) {
        Arrays.fill(matriz, 1, 6,5  );
    }
}
