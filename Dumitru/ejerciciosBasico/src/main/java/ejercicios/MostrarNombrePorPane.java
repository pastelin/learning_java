package ejercicios;

import javax.swing.*;
import java.util.Scanner;

public class MostrarNombrePorPane {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Ingresa tu nombre:");

        JOptionPane.showMessageDialog(null, "¡Bienvenido, " + nombre + "!");

    }
}
