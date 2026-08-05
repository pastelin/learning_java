package matrices;

import java.util.Arrays;

public class Ejercicio03 {

    public static void main(String[] args) {
        int[] matriz = new int[]{1,2,3,4,5};
        int[] matrizInversa = invertirMatriz(matriz);

        System.out.println("Valores de la matriz original:" + Arrays.toString(matriz));
        System.out.println("Valores de la matriz inversa:" + Arrays.toString(matrizInversa));
    }

    private static int[] invertirMatriz(int matriz[]) {

        int[] matrizInversa = new int[matriz.length];

        for(int i = matriz.length - 1; i >= 0; i--) {
            matrizInversa[matriz.length - 1 - i] = matriz[i];
        }

        return matrizInversa;
    }
}
