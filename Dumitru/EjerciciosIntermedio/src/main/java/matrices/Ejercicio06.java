package matrices;

import java.util.Arrays;

public class Ejercicio06 {

    public static void main(String[] args) {
        int[] matriz = new int[]{1,4,7,2,5,8,3,6,9};
        System.out.println("Valores de la matriz original: " + Arrays.toString(matriz));

        ordenarMatriz(matriz);
        System.out.println("Valores de la matriz ordenada: " + Arrays.toString(matriz));

    }

    public static void ordenarMatriz(int[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz.length -1; j++) {
                if(matriz[j] > matriz[j + 1]) {
                    int aux = matriz[j];
                    matriz[j] = matriz[j + 1];
                    matriz[j + 1] = aux;
                }
            }
        }
    }
}
