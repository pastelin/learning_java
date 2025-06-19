package codeblocks.and.methods.overloading;

public class DecimalComparator {
    public static void main(String[] args) {

        // Test cases for the areEqualByThreeDecimalPlaces method
        System.out.println(areEqualByThreeDecimalPlaces(3.1756, 3.175)); // false
        System.out.println(areEqualByThreeDecimalPlaces(3.175, 3.175)); // true
        System.out.println(areEqualByThreeDecimalPlaces(3.176, 3.175)); // false
        System.out.println(areEqualByThreeDecimalPlaces(-3.175, -3.175)); // true
        System.out.println(areEqualByThreeDecimalPlaces(0.0, 0.0)); // true

    }


    public static boolean areEqualByThreeDecimalPlaces(double number1, double number2) {
        // Round both numbers to three decimal places and compare them
        int roundedNumber2 = (int) (number2 * 1000.0);
        int roundedNumber1 = (int) (number1 * 1000.0);

        System.out.println("Rounded Number 1: " + roundedNumber1);
        System.out.println("Rounded Number 2: " + roundedNumber2);
        return roundedNumber1 == roundedNumber2;



    }

}