package com.codewars.wave;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MexicanWave {

	public static String[] wave(String str) {

		List<String> result = new ArrayList<>();

		for (int i = 0; i < str.length(); i++) {

			if ((str.charAt(i) != ' ')) {
				char letra = Character.toUpperCase(str.charAt(i));
				String nuevaCadena = str.substring(0, i) + letra + str.substring(i + 1);
				result.add(nuevaCadena);
			}

		}

		return result.toArray(new String[0]);
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(wave("two words")));
	}

}
