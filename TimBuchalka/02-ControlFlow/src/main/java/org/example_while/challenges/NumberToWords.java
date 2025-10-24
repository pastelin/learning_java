package org.example_while.challenges;

public class NumberToWords {

    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
        }

        int reversedNumber = reverse(number);
        int digitCount = getDigitCount(number);

        for (int i = digitCount; i > 0; i--) {
            switch (reversedNumber % 10) {
                case 0 -> System.out.println("Zero");
                case 1 -> System.out.println("One");
                case 2 -> System.out.println("Two");
                case 3 -> System.out.println("Three");
                case 4 -> System.out.println("Four");
                case 5 -> System.out.println("Five");
                case 6 -> System.out.println("Six");
                case 7 -> System.out.println("Seven");
                case 8 -> System.out.println("Eight");
                case 9 -> System.out.println("Nine");
            }

            reversedNumber /= 10;
        }


    }

    public static int reverse(int number) {

        long reversedNumber = 0L;

        do {
            reversedNumber = reversedNumber * 10 + number % 10;
            number /= 10;
        } while (number != 0);

        if (reversedNumber > Integer.MAX_VALUE || reversedNumber < Integer.MIN_VALUE) {
            return 0; // The reversed number is too big or too small
        }
        return (int) reversedNumber;
    }

    public static int getDigitCount(int number) {

        if (number <= 0) {
            return number == 0 ? 1 : -1;
        }

        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
//        numberToWords(0); // Expected output: Zero
        numberToWords(10); // Expected output: One, Two, Three
    }
}
