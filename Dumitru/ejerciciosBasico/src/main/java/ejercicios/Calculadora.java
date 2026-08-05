package ejercicios;

import javax.swing.*;

public class Calculadora {

    public static void main(String[] args) {
        int num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el primer número:"));
        String operacion = "";
        do {
            operacion = JOptionPane.showInputDialog("Ingresa la operación a realizar (+, -, *, /, %):");
            if (operacion.equals("+") || operacion.equals("-") || operacion.equals("*") || operacion.equals("/") || operacion.equals("%")) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Operación no válida. Por favor, ingresa una operación válida.");
            }
        } while (true);

        int num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el segundo número:"));

        switch (operacion) {
            case "+":
                JOptionPane.showMessageDialog(null, "La suma de " + num1 + " y " + num2 + " es: " + (num1 + num2));
                break;
            case "-":
                JOptionPane.showMessageDialog(null, "La resta de " + num1 + " y " + num2 + " es: " + (num1 - num2));
                break;
            case "*":
                JOptionPane.showMessageDialog(null, "La multiplicación de " + num1 + " y " + num2 + " es: " + (num1 * num2));
                break;
            case "/":
                if (num2 != 0) {
                    JOptionPane.showMessageDialog(null, "La división de " + num1 + " entre " + num2 + " es: " + (num1 / num2));
                } else {
                    JOptionPane.showMessageDialog(null, "Error: No se puede dividir entre cero.");
                }
                break;
            case "%":
                if (num2 != 0) {
                    JOptionPane.showMessageDialog(null, "El módulo de " + num1 + " entre " + num2 + " es: " + (num1 % num2));
                } else {
                    JOptionPane.showMessageDialog(null, "Error: No se puede calcular el módulo entre cero.");
                }
                break;

        }
    }
}
