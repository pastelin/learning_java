package ejercicios;

import java.util.Scanner;

public class ValidandoPassword {

    public static void main(String[] args) {

        String password = "12345";
        int numeroDeIntentos = 3;
        int intentosRealizados = 0;

        while(intentosRealizados < numeroDeIntentos) {
            intentosRealizados++;
            System.out.println("Ingresa tu contraseña:");
            String input = new Scanner(System.in).nextLine();

            if(input.equals(password)) {
                System.out.println("Enhorabuena");
                break;
            } else {
                System.out.println("Contraseña incorrecta. Intento " + intentosRealizados + " de " + numeroDeIntentos);
            }

            if (intentosRealizados == numeroDeIntentos) {
                System.out.println("Has agotado tus intentos. Acceso bloqueado.");
            }
        }

    }
}
