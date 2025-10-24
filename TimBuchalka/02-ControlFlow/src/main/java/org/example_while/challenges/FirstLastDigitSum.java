package org.example_while.challenges;

public class FirstLastDigitSum {

    public static int sumFirstAndLastDigit(int number) {

        if(number < 0) {
            return -1; // Retorna -1 si el número es negativo
        }

        int firstDigit = 0;
        int lastDigit = number % 10;

        while(number != 0) {
            firstDigit = number % 10;
            number /= 10; // Elimina el último dígito
        }

        return firstDigit + lastDigit; // Retorna la suma del primer y último dígito
    }
}
