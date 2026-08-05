package matrices;

public class Ejercicio02 {

    public static void main(String[] args) {
        int[] matriz = new int[100];
        llenarMatriz(matriz);
        System.out.println("La suma de los valores en la matriz es: " + sumarMatriz(matriz));
        System.out.println("La media de los valores en la matriz es: " + obtenerMedia(matriz));
    }

    private static void llenarMatriz(int[] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = i + 1;
        }
    }

    private static int sumarMatriz(int[] matriz) {
        int suma = 0;
        for(int valor : matriz) {
            suma += valor;
        }
        return suma;
    }

    private static double obtenerMedia(int[] matriz){
        int suma = sumarMatriz(matriz);
        return (double) suma / matriz.length;
    }
}
