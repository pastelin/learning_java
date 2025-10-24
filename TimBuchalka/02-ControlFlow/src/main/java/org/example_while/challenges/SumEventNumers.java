package org.example_while.challenges;

public class SumEventNumers {

    public static boolean isEvenNumber(int number) {
        if (number < 0) {
            return false; // No consideramos números negativos
        }

        return number % 2 == 0;
    }

    public static void main(String[] args) {


        int i = 5;
        int count = 0;
        while (i <= 20) {
            if (isEvenNumber(i)) {
                System.out.println("El número " + i + " es par.");
                count++;
            } else {
                System.out.println("El número " + i + " es impar.");
            }

            if (count == 5) {
                break;
            }
            i++;
        }
    }
}
