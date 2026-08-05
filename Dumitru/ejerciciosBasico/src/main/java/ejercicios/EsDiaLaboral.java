package ejercicios;

import java.util.Scanner;

public class EsDiaLaboral {

    public static void main(String[] args) {
        System.out.println("Ingresa un día de la semana:");
        String dia = new Scanner(System.in).nextLine().toLowerCase();

        switch (dia) {
            case "lunes":
            case "martes":
            case "miércoles":
            case "miercoles": // Para aceptar ambas formas de escribir miércoles
            case "jueves":
            case "viernes":
                System.out.println(dia.substring(0, 1).toUpperCase() + dia.substring(1) + " es un día laboral.");
                break;
            case "sábado":
            case "sabado": // Para aceptar ambas formas de escribir sábado
            case "domingo":
                System.out.println(dia.substring(0, 1).toUpperCase() + dia.substring(1) + " no es un día laboral.");
                break;
            default:
                System.out.println("Entrada no válida. Por favor, ingresa un día de la semana.");
        }
    }
}
