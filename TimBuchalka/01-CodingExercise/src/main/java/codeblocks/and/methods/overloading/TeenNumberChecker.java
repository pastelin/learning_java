package codeblocks.and.methods.overloading;

public class TeenNumberChecker {

    public static boolean hasTeen(int firstNumber, int secondNumber, int thirdNumber) {

        return isTeen(firstNumber) || isTeen(secondNumber) || isTeen(thirdNumber);

    }

    public static boolean isTeen(int number) {
        // Check if the number is between 13 and 19 (inclusive)
        return number >= 13 && number <= 19;
    }
}
