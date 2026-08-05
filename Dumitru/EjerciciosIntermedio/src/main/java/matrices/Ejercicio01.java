package matrices;

import java.util.Scanner;

public class Ejercicio01 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] matriz = new int[10];

        llenarMatriz(matriz);
        mostrarMatriz(matriz);
    }

    private static void llenarMatriz(int[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Introduce el valor para la posición " + (i + 1));
            matriz[i] = scanner.nextInt();
        }
    }

    private static void mostrarMatriz(int[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Valor en la posición " + (i + 1) + ": " + matriz[i]);
        }
    }
}
