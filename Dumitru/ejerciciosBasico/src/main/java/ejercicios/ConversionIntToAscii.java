package ejercicios;

import java.util.Scanner;

public class ConversionIntToAscii {
    public static void main(String[] args) {
        System.out.println("Ingresa un número entero para convertirlo a su carácter ASCII correspondiente:");
        int numero = new Scanner(System.in).nextInt();
        char caracter = (char) numero;
        System.out.println("El número " + numero + " corresponde al carácter ASCII: " + caracter);
    }
}
