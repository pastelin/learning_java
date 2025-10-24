package org.example_while.challenges;

public class DiagonalStar {

    public static void printSquareStar(int number) {

        if (number < 5) {
            System.out.println("Invalid Value");
            return; // Exit the method if the number is less than 5
        }

        for (int i = 1; i <= number; i++) {

            for (int j = 1; j <= number; j++) {
                if ((i == 1 || i == number) || (j == 1 || j == number) || i == j || j == number - i + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printSquareStar(5); // Example usage
        printSquareStar(8); // Another example
        printSquareStar(3); // Should print "Invalid Value"
    }
}
