package ejercicios;

import javax.swing.*;

public class AVGNumeros {

    public static void main(String[] args) {

        int sumaPositivos = 0;
        int sumaNegativos = 0;
        int contador = 0;
        int numeroMayor = Integer.MIN_VALUE;
        int numeroMenor = Integer.MAX_VALUE;

        while (true) {

            int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingresa un número (o '-1' para terminar):"));

            if (numero == -1) {
                break;
            } else if (numero > 0) {
                sumaPositivos += numero;
                if (numero > numeroMayor) {
                    numeroMayor = numero;
                } else if (numero < numeroMenor) {
                    numeroMenor = numero;

                }
            } else if (numero < 0) {
                sumaNegativos += numero;
                if (numero < numeroMenor) {
                    numeroMenor = numero;
                }
            }

            contador++;
        }

        JOptionPane.showMessageDialog(null,
                "\nNúmero mayor: " + (numeroMayor != Integer.MIN_VALUE ? numeroMayor : "No se ingresaron números positivos") +
                        "\nNúmero menor: " + (numeroMenor != Integer.MAX_VALUE ? numeroMenor : "No se ingresaron números negativos") +
                        "\n Suma de todos los números: " + (sumaPositivos + sumaNegativos) +
                        "\n Suma de números positivos: " + sumaPositivos +
                        "\n Suma de números negativos: " + sumaNegativos +
                        "\n Media de la suma: " + ((sumaPositivos + sumaNegativos) / (contador > 0 ? contador : 1))
        );
    }
}
