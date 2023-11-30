package com.codewars.number_star_ladder;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberStarLadder {

	public static String pattern(int n) {

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			StringBuilder sb1 = new StringBuilder();

			for (int x = 1; x < i; x++) {
				sb1.append("*");
			}

			sb = (i != 1) 
					? sb.append("\n").append("1").append(sb1).append(i) 
					: sb.append("1");
		}

		return sb.toString();

	}
	
	public static String patternV2(int n) {

		return IntStream.rangeClosed(1, n)
				.mapToObj( i -> "1" +  
						String.join("", Collections.nCopies( i - 1, "*")) + 
						((i != 1) ? i : "") )
				.collect(Collectors.joining("\n"));

	}

	public static void main(String[] args) {
		System.out.println(patternV2(5));
	}

}
