package ejercicios;

import java.util.Random;

public class OperacionesBasicas {

    static Random random = new Random();

    public static void main(String[] args) {
        int num1 = random.nextInt(100); // Genera un número aleatorio entre 0 y 99
        int num2 = random.nextInt(50); // Genera otro número aleatorio entre


        System.out.println("La suma de " + num1 + " y " + num2 + " es: " + (num1 + num2));
        System.out.println("La resta de " + num1 + " y " + num2 + " es: " + (num1 - num2));
        System.out.println("La multiplicación de " + num1 + " y " + num2 + " es: " + (num1 * num2));
        System.out.println("La división de " + num1 + " y " + num2 + " es: " + (num1 / num2));
        System.out.println("El módulo de " + num1 + " y " + num2 + " es: " + (num1 % num2));

    }
}
