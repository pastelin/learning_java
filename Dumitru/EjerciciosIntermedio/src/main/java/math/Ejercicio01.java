package math;

import java.util.Scanner;

public class Ejercicio01 {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduce la coordenada x del punto A");
        double xA = scanner.nextDouble();
        System.out.println("Introduce la coordenada y del punto A");
        double yA = scanner.nextDouble();

        System.out.println("Introduce la coordenada x del punto B");
        double xB = scanner.nextDouble();
        System.out.println("Introduce la coordenada y del punto B");
        double yB = scanner.nextDouble();

        double distancia = calcularDistancia(xA, yA, xB, yB);
        System.out.println("La distancia entre el punto A y el punto B es: " + distancia);

    }

    private static double calcularDistancia(double xA, double yA, double xB, double yB) {

        double deltaX = xB - xA;
        double deltaY = yB - yA;

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }


}
