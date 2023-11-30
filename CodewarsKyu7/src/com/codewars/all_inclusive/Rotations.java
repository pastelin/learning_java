package com.codewars.all_inclusive;

import java.util.Arrays;
import java.util.List;

public class Rotations {

	public static boolean containAllRots(String strng, List<String> arr) {
        boolean isRotate = true;
        
        String[] letters = strng.split("");
        
//        for(int i = 0; i < letters.length; i++) {
//        	
//        	for(String word : arr) {
//        		if(!word.contains(letters[i])) {
//        			isRotate = false;
//        			break;
//        		}
//        	}
//        	
//        	if(!isRotate) {
//        		break;
//        	}
//        	
//        }
        
        return arr.contains(strng);
    }
	
	
	public static void main(String[] args) {
		System.out.println("Fixed Tests containAllRots");
		
		System.out.println(Rotations.containAllRots("", Arrays.asList()));
        
		List<String> a = Arrays.asList("bsjq", "qbsj");
        System.out.println(Rotations.containAllRots("", a));
        
        a = Arrays.asList("bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs");
        System.out.println(Rotations.containAllRots("bsjq", a));
        
        a = Arrays.asList("TzYxlgfnhf", "yqVAuoLjMLy", "BhRXjYA", "YABhRXj", "hRXjYAB", "jYABhRX", "XjYABhR", "ABhRXjY");
        System.out.println(Rotations.containAllRots("XjYABhR", a));
	}
}
