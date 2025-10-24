package org.example_while.challenges;

public class NumberPalindrome {

    public static boolean isPalindrome(int number) {

        int reverse = 0;
        int originalNumber = number; // Guarda el número original para la comparación final

        while (number != 0) {
            reverse = reverse * 10 + number % 10; // Construye el número invertido
            number /= 10; // Elimina el último dígito del número original
        }

        return reverse == originalNumber; // Compara el número invertido con el original
    }

    public static void main(String[] args) {
        System.out.println("¿Es 121 un palíndromo? " + isPalindrome(121)); // Debería imprimir true
        System.out.println("¿Es -121 un palíndromo? " + isPalindrome(-121)); // Debería imprimir false (los números negativos no son palíndromos)
        System.out.println("¿Es 123 un palíndromo? " + isPalindrome(123)); // Debería imprimir false
        System.out.println("¿Es 12321 un palíndromo? " + isPalindrome(12321)); // Debería imprimir true
    }
}
