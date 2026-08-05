package ejercicios;

public class ValidaSiUNumeroEsPar {

    public static void main(String[] args) {
        System.out.println("Ingresa un número:");
        int numero = new java.util.Scanner(System.in).nextInt();

        if (numero % 2 == 0) {
            System.out.println("El número " + numero + " es par.");
        } else {
            System.out.println("El número " + numero + " es impar.");
        }
    }
}
