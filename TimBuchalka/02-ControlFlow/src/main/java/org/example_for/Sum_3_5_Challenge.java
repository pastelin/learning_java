package org.example_for;

public class Sum_3_5_Challenge {

    public static void main(String[] args) {

        int count = 1;
        for(int i = 1; count <= 5 && i <= 1000; i++) {
            if((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println(i + " is a multiple of 3 or 5");
                count += 1;
            }
        }
    }
}
