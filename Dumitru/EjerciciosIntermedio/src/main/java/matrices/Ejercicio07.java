package matrices;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio07 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] matriz = new int[10];
        llenarMatriz(matriz);
        int[] matrizConValoresPares = obtenerValoresPares(matriz);
        System.out.println("Valores pares encontrados en la matriz:"+ Arrays.toString(matrizConValoresPares));
    }

    private static void llenarMatriz(int[] matriz) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce el valor para la posición " + (i + 1));
            matriz[i] = scanner.nextInt();
        }
    }

    private static int[] obtenerValoresPares(int[] matriz) {
        int cantidadPares = 0;
        for (int valor : matriz) {
            if (valor % 2 == 0) {
                cantidadPares++;
            }
        }

        int[] matrizPares = new int[cantidadPares];
        int indicePares = 0;
        for (int valor : matriz) {
            if (valor % 2 == 0) {
                matrizPares[indicePares] = valor;
                indicePares++;
            }
        }

        return matrizPares;
    }


}
