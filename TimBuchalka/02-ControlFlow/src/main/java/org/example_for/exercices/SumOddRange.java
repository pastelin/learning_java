package org.example_for.exercices;

public class SumOddRange {

    public static boolean isOdd(int number) {

        if (number < 0) {
            return false; // No consideramos números negativos
        }

        return number % 2 != 0; // Retorna true si el número es impar
    }

    public static int sumOdd(int start, int end) {

        int sum = 0;

        if(start < 0 || end < 0 || start > end) {
            return -1; // Retorna -1 si los parámetros son inválidos
        }

        for (int i = start; i <= end; i++) {
            if(isOdd(i)) {
                sum += i; // Suma el número impar a la suma total
            }
        }

        return sum; // Retorna la suma total de los números impares
    }

    public static void main(String[] args) {
        System.out.println("Sum of odd numbers between 1 and 100: " + sumOdd(1, 100)); // Debería imprimir 2500
        System.out.println("Sum of odd numbers between -1 and 100: " + sumOdd(-1, 100)); // Debería imprimir -1 (parámetros inválidos)
        System.out.println("Sum of odd numbers between 100 and 50: " + sumOdd(100, 50)); // Debería imprimir -1 (parámetros inválidos)
        System.out.println("Sum of odd numbers between 10 and 20: " + sumOdd(10, 20)); // Debería imprimir 75
    }

}
