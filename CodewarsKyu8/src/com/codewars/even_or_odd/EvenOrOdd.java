package com.codewars.even_or_odd;

import java.util.Random;

public class EvenOrOdd {

	public static void main(String[] args) {

		Random random = new Random();

		for (int i = 0; i < 10; i++) {
			int number = random.nextInt(20);
			System.out.println("Number " + number + " is " + even_or_odd(number));
		}

	}

	public static String even_or_odd(int number) {
		return (number % 2) == 0 ? "Even" : "Odd";
	}

}
