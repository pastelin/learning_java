package org.example_for.challenge;

public class GreatestCommonDivisor {

    public static int getGreatestCommonDivisor(int first, int second) {
        if(first < 10 || second < 10) {
            return -1;
        }

        int min = Math.min(first, second);
        int max = Math.max(first, second);

        for(int i = min; i > 0; i--) {
            if((min % i == 0) && (max % i == 0) ) {
                return i;
            }
        }
        return -1; // This line should never be reached if inputs are valid
    }

}
