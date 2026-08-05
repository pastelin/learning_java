package matrices;

import java.util.Arrays;

public class Ejercicio05 {

    public static void main(String[] args) {
        int[] matriz = new int[10];
        Arrays.fill(matriz,1);
        System.out.println("Valores de la matriz: " + Arrays.toString(matriz));

        int[] matrizCopia = Arrays.copyOf(matriz, matriz.length);
        System.out.println("Valores de la matriz copia: " + Arrays.toString(matrizCopia));
    }
}
