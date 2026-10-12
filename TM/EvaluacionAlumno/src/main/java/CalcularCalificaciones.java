public class CalcularCalificaciones {

    private String nombreAlumno;
    private int[] calificaciones = new int[5];

    public double calcularPromedio(int[] calificaciones) {
        int sumaCalificaciones = 0;
        for (int i = 0; i < calificaciones.length; i++) {
            sumaCalificaciones += calificaciones[i];
        }

        return (double) sumaCalificaciones / calificaciones.length;
    }

    public char obtenerNotaCalificacion(double promedio) {

        if (promedio > 90) {
            return 'A';
        } else if (promedio > 80) {
            return 'B';
        } else if (promedio > 70) {
            return 'C';
        } else if (promedio > 60) {
            return 'D';
        } else if (promedio > 50) {
            return 'E';
        } else {
            return 'F';
        }

    }

    public void imprimirResultados(String nombreAlumno, int[] calificaciones, char nota) {

        System.out.println("Nombre del estudiante: " + nombreAlumno);
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Calificación " + (i + 1) + ": " + calificaciones[i]);
        }
        System.out.println("Promedio: " + calcularPromedio(calificaciones));
        System.out.println("Calificación: " + nota);
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public int[] getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(int[] calificaciones) {
        this.calificaciones = calificaciones;
    }
}
