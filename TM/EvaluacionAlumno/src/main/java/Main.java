import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CalcularCalificaciones calificaciones = new CalcularCalificaciones();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del estudiante: ");
        calificaciones.setNombreAlumno(scanner.nextLine());

        int[] calificacionesArray = new int[5];
        for (int i = 0; i < calificacionesArray.length; i++) {
            System.out.print("Ingrese la calificación " + (i + 1) + ": ");
            calificacionesArray[i] = scanner.nextInt();
        }
        calificaciones.setCalificaciones(calificacionesArray);

        String nombreAlumno = calificaciones.getNombreAlumno();
        double promedio = calificaciones.calcularPromedio(calificacionesArray);
        char nota = calificaciones.obtenerNotaCalificacion(promedio);
        calificaciones.imprimirResultados(nombreAlumno, calificacionesArray, nota);
    }
}
