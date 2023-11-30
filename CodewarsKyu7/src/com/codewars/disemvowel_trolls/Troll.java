package com.codewars.disemvowel_trolls;

public class Troll {
	 public static String disemvowel(String str) {
		 String[] vowels = new String[]{"a", "e", "i", "o", "u"};
		 
		 for (String vowel : vowels) {
			 str = str.replaceAll(vowel, "");
			 str = str.replaceAll(vowel.toUpperCase(), "");
		 }
		 
		 return str;
	 }
	 
	 /*
	  * (?i) match the remainder of the pattern with the following effective flags: 
	  * gmi i modifier: insensitive. 
	  * Case insensitive match (ignores case of [a-zA-Z])
	  */
	 public static String disemvowelV2(String str) {
		 return str.replaceAll("(?i)[aeiou]", "");
	 }
	 
	 public static void main(String[] args) {
		 
		 System.out.println(disemvowelV2("This website is for losers LOL!"));
		 System.out.println(disemvowelV2("This website is for losers LOL!").equals("Ths wbst s fr lsrs LL!"));
		 System.out.println(disemvowelV2("No offense but,\\nYour writing is among the worst I've ever read").equals("N ffns bt,\\nYr wrtng s mng th wrst 'v vr rd"));
		 System.out.println(disemvowelV2("What are you, a communist?").equals("Wht r y,  cmmnst?"));
	}
}
