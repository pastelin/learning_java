package matrices;

// Importamos la clase Arrays que nos da herramientas para trabajar con arreglos
// Ejemplo: como una caja de herramientas que ya tiene todo listo para usar
import java.util.Arrays;

public class Ejercicio08 {

    public static void main(String[] args) {

        // Creamos una lista de números desordenados
        // Ejemplo del mundo real: imagina los números de expediente de pacientes
        // en un hospital, ingresados en desorden durante el día
        int[] matriz = new int[]{51, 23, 64, 12, 87, 34, 45, 29, 78, 56};

        // Ordenamos la lista de menor a mayor automáticamente
        // Ejemplo: como cuando el administrativo del hospital ordena los expedientes
        // por número antes de empezar a buscar alguno
        Arrays.sort(matriz);

        // Mostramos en pantalla la lista ya ordenada para verificar el resultado
        // Ejemplo: como ver el listado de expedientes ordenados en la pantalla del ordenador
        System.out.println("Valores de la matriz ordenada: " + Arrays.toString(matriz));

        // Definimos el número que queremos buscar dentro de la lista
        // Ejemplo: el administrativo quiere encontrar el expediente número 56
        int target = 56;

        // Llamamos al método que buscará el número dentro de la lista ordenada
        // Le pasamos la lista (matriz) y el número a buscar (target)
        encontrarValor(matriz, target);
    }

    // Método que busca un valor dentro de un arreglo usando BÚSQUEDA BINARIA
    // Ejemplo del mundo real: es como buscar una palabra en un diccionario.
    // No lees desde la página 1, abres por la mitad, ves si tu palabra va
    // antes o después, y así reduces la búsqueda a la mitad cada vez.
    private static void encontrarValor(int[] matriz, int target) {

        // Puntero que apunta al primer elemento de la lista (posición 0)
        // Ejemplo: el dedo izquierdo apuntando a la primera página del diccionario
        int left = 0;

        // Puntero que apunta al último elemento de la lista
        // Ejemplo: el dedo derecho apuntando a la última página del diccionario
        int right = matriz.length - 1;

        // Mientras el espacio de búsqueda tenga al menos un elemento, seguimos buscando
        // Ejemplo: mientras todavía haya páginas entre los dos dedos, seguimos buscando
        while (left <= right) {

            // Calculamos la posición del elemento del medio entre left y right
            // Usamos esta fórmula especial (en lugar de (left+right)/2)
            // para evitar errores con números muy grandes (desbordamiento de memoria)
            // Ejemplo: abrimos el diccionario exactamente por la mitad de las páginas restantes
            int mid = left + (right - left) / 2;

            // Comprobamos si el elemento del medio ES el que buscamos
            // Ejemplo: abrimos el diccionario y la palabra justo en esa página ES la que buscamos
            if (matriz[mid] == target) {
                // ¡Encontrado! Mostramos en qué posición está el número
                // Ejemplo: "La palabra está en la página 234 del diccionario"
                System.out.println("Valor encontrado en la posición: " + mid);

                // Salimos del método, ya no hay nada más que buscar
                return;

            // Si el elemento del medio es MENOR que el que buscamos...
            // Ejemplo: la palabra del diccionario va DESPUÉS alfabéticamente
            } else if (matriz[mid] < target) {

                // Movemos el puntero izquierdo a la mitad derecha
                // Ejemplo: descartamos toda la mitad izquierda del diccionario
                // y ahora solo buscamos en la mitad derecha
                left = mid + 1;

            // Si el elemento del medio es MAYOR que el que buscamos...
            // Ejemplo: la palabra del diccionario va ANTES alfabéticamente
            } else {

                // Movemos el puntero derecho a la mitad izquierda
                // Ejemplo: descartamos toda la mitad derecha del diccionario
                // y ahora solo buscamos en la mitad izquierda
                right = mid - 1;
            }
        }

        // Si salimos del bucle sin haber encontrado el número, significa que NO existe
        // Ejemplo: buscamos el expediente número 99 pero no está registrado en el hospital
        System.out.println("Valor no encontrado en la matriz.");
    }
}
