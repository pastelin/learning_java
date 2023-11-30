package com.codewars.AtoZ;

import java.util.stream.IntStream;

public class FromAtoZ {

	// a-z	
	public static String gimmeTheLetters(String s) {

		char firstLetter = s.charAt(0); //a
		char lastLetter = s.charAt(s.length() - 1); // z

		String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";
		String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		return Character.isUpperCase(firstLetter) ? getLetters(alphabetUpperCase, firstLetter, lastLetter)
				: getLetters(alphabetLowerCase, firstLetter, lastLetter);

	}

	private static String getLetters(String alphabet, char firstLetter, char lastLetter) {

		int beginIndex = alphabet.indexOf(firstLetter);
		int endIndex = alphabet.indexOf(lastLetter) + 1;

		return alphabet.substring(beginIndex, endIndex);
	}

	/*
	 * 65 => A ... 90 => Z 97 => a ... 122 => z
	 * 
	 */
	public static String gimmeTheLettersOptimized(String s) {
		StringBuilder sb = new StringBuilder();

		for (char c = s.charAt(0); c <= s.charAt(s.length() - 1); c++) {
			sb.append(c);
		}

		return sb.toString();
	}

	private static String gimmeTheLettersWithStream(String s) {

		StringBuilder sb = new StringBuilder();

		IntStream.iterate((int) s.charAt(0), i -> i + 1)
				.limit(s.charAt(2) - s.charAt(0) + 1)
				.forEach(letter -> sb.append((char) letter));

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println("---------------- Strings ---------------------");
		System.out.println(gimmeTheLetters("a-z"));
		System.out.println(gimmeTheLetters("h-o"));
		System.out.println(gimmeTheLetters("Q-Z"));
		System.out.println(gimmeTheLetters("J-J"));

		System.out.println("---------------- For ---------------------");
		System.out.println(gimmeTheLettersOptimized("a-z"));
		System.out.println(gimmeTheLettersOptimized("h-o"));
		System.out.println(gimmeTheLettersOptimized("Q-Z"));
		System.out.println(gimmeTheLettersOptimized("J-J"));

		System.out.println("---------------- Streams ---------------------");
		System.out.println(gimmeTheLettersWithStream("a-z"));
		System.out.println(gimmeTheLettersWithStream("h-o"));
		System.out.println(gimmeTheLettersWithStream("Q-Z"));
		System.out.println(gimmeTheLettersWithStream("J-J"));
	}

}
