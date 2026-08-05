package ejercicios;

import java.util.Scanner;

public class MostrarBienvenidaPorConsola {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Ingresa tu nombre:");
        String nombre = scanner.nextLine();
        System.out.println("¡Bienvenido, " + nombre + "!");
    }
}
