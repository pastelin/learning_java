package com.codewars.kata;

import java.util.Arrays;

/**
 * Keyword	Type							Example
 * boolean	- true or false					- true
 * byte 	- 8-bit integral value			- 123
 * short 	- 16-bit integral value 		- 123
 * int 		- 32-bit integral value 		- 123
 * long 	- 64-bit integral value 		- 123
 * float 	- 32-bit floating-point value 	- 123.45f
 * double 	- 64-bit floating-point value 	- 123.456
 * char 	- 16-bit Unicode value 			- 'a'
 */

public class Kata {
	public static boolean CheckIfFlush(String[] cards) {
		
		if(cards == null || cards.length == 0) {
			return false;
		}
		
		byte firstCardLength = (byte) (cards[0].length() - 1);
		
		char suitBase = cards[0].charAt(firstCardLength);
		
		for(String card : cards) {
			char suit = card.charAt(card.length() - 1);
			
			if(suitBase != suit) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean CheckIfFlushOptimized(String[] cards) {

		final char suitBase = cards[0].charAt(cards[0].length() - 1);

		return Arrays.stream(cards).allMatch(suit -> suit.charAt(suit.length() - 1) == suitBase);
	}
     
	public static void main(String[] args) {
		System.out.println(CheckIfFlushOptimized(new String[] {}));
		System.out.println(CheckIfFlushOptimized(new String[] {}));
	}
}
