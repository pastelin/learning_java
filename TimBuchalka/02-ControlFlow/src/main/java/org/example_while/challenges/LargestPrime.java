package org.example_while.challenges;

public class LargestPrime {

    public static int getLargestPrime(int number) {

        if (number <= 1) {
            return -1; // Return -1 for numbers less than or equal to 1
        }

        int largestPrime = -1;

        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {

                // Cada vez que encuentras un factor, lo comparas
                // con el más grande que ya tenías.
                largestPrime = Math.max(largestPrime, i);

                number /= i;

                i--; // Tu truco para re-evaluar con el mismo factor
            }
        }
        return largestPrime;
    }

    public static int getLargestPrimeV2(int number) {
        if (number <= 1) {
            return -1;
        }

        int divisor = 2;

        // Continuamos mientras el número no se haya reducido a 1
        while (number > 1) {
            // ¿Podemos dividir entre el divisor actual?
            if (number % divisor == 0) {
                // Si sí, lo hacemos y no cambiamos de divisor
                number /= divisor;
            } else {
                // Si no, probamos con el siguiente número
                divisor++;
            }
        }
        // El último divisor que funcionó es el primo más grande
        return divisor;
    }

    public static void main(String[] args) {
        System.out.println(getLargestPrime(217)); // Output: 7
    }
}
