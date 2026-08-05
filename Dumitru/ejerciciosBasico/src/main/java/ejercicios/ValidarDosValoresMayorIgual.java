package ejercicios;

import java.util.Random;

public class ValidarDosValoresMayorIgual {

    static Random random = new Random();

    public static void main(String[] args) {
        int num1 = random.nextInt(100); // Genera un número aleatorio entre 0 y 99
        int num2 = random.nextInt(100); // Genera otro número aleatorio entre 0 y 99

        if (num2 > num1) {
            System.out.println("El número " + num2 + " es mayor que " + num1);
        } else if (num1 > num2) {

            System.out.println("El número " + num1 + " es mayor que " + num2);
        } else {
            System.out.println("Los números " + num1 + " y " + num2 + " son iguales");
        }
    }
}
