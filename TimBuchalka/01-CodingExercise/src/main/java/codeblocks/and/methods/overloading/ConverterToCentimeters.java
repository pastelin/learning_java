package codeblocks.and.methods.overloading;

public class ConverterToCentimeters {


    public static void main(String[] args) {
        System.out.println("5ft, 8in = " + convertToCentimeters(5, 8) + " cm");
        System.out.println("68in = " + convertToCentimeters(68) + " cm");
    }

    public static double convertToCentimeters(int ft, int inc) {

        // Convert feet to inches (1 foot = 12 inches)
        int totalInches = ft * 12 + inc;

        // Convert inches to centimeters (1 inch = 2.54 cm)
        return totalInches * 2.54;
    }

    public static double convertToCentimeters(int inc) {
        // Convert inches to centimeters (1 inch = 2.54 cm)
        return inc * 2.54;
    }

}
