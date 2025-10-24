package org.example_while.challenges;

public class FlourPacker {

    public static boolean canPack(int bigCount, int smallCount, int goal) {

        // 1. Check for invalid inputs first.
        if (bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        // 2. Check if there is enough flour in total.
        if (bigCount * 5 + smallCount < goal) {
            return false;
        }

        // 3. Check if the small bags can cover the remainder.
        return (goal % 5 <= smallCount);
    }

    public static void main(String[] args) {
        System.out.println(canPack(1, 0, 4)); // false
    }
}
