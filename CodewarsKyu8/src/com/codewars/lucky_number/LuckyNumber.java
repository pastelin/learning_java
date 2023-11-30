package com.codewars.lucky_number;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LuckyNumber {

	public static boolean isLucky(long n) {

		int sum = 0;

		while (n > 0) {

			sum += (int) (n % 10);
			n /= 10;

		}

		return (sum == 0 || sum % 9 == 0);
	}

	public static boolean isLuckyV2(long n) {

		int sum = 0;
		
		((IntStream) IntStream.iterate((int) n, i -> i = i / 10))
				.takeWhile(i -> i > 0);
//				.summaryStatistics();
				//			.limit(5)
//			.forEach(System.out::println);
				
			
		return (sum == 0 || sum % 9 == 0);
	}

	public static void main(String[] args) {

		System.out.println(isLucky(0));
		System.out.println(isLucky(1892376));
		System.out.println(isLuckyV2(189237));
	}

}
