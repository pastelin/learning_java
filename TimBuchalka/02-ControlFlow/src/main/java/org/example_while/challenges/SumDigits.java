package org.example_while.challenges;

public class SumDigits {


    public static int sumDigits(int number) {

        int sum = 0;

        if(number < 0) {
            return -1;
        }

        while (number > 0) {
            sum += number % 10; // Suma el último dígito al total
            number /= 10; // Elimina el último dígito del número
        }


        return sum; // Retorna la suma total de los dígitos
    }

    public static void main(String[] args) {
        System.out.println("Suma de los dígitos de 123: " + sumDigits(123)); // Debería imprimir 6
        System.out.println("Suma de los dígitos de -123: " + sumDigits(-123)); // Debería imprimir -1 (parámetros inválidos)
        System.out.println("Suma de los dígitos de 0: " + sumDigits(0)); // Debería imprimir 0
        System.out.println("Suma de los dígitos de 987654321: " + sumDigits(987654321)); // Debería imprimir 45
    }

}
