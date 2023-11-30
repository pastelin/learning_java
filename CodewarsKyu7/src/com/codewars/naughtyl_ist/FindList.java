package com.codewars.naughtyl_ist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindList {

	/*
	 * Puntos relevantes del problema
	 * 
	 * 1. Regresar una lista de los niños que aparecen en la lista de santa 
	 * 2. Nopuede haber niños duplicados 
	 * 3. La lista debe estar ordenada
	 * 
	 */
	public static List<String> findChildren(List<String> santasList, List<String> children) {

		List<String> newSantaList = new ArrayList<>();

		for (String child : children) {

			if (santasList.contains(child) && !newSantaList.contains(child)) {
				newSantaList.add(child);
			}

		}

		newSantaList.sort(Comparator.naturalOrder());

		return newSantaList;
	}

	public static void main(String[] args) {

		System.out.println("Test #1");
		List<String> santaList = Arrays.asList(new String[] { "Jason", "Jackson", "Jordan", "Johnny" });
		List<String> children = Arrays.asList(new String[] { "Jason", "Jordan", "Jennifer" });
		System.out.println(findChildren(santaList, children));

		System.out.println("Test #2");
		santaList = Arrays.asList(new String[] { "Jason", "Jackson", "Johnson", "JJ" });
		children = Arrays.asList(new String[] { "Jason", "James", "JJ" });
		System.out.println(findChildren(santaList, children));

		System.out.println("Test #3");
		santaList = Arrays.asList(new String[] { "jASon", "JAsoN", "JaSON", "jasON" });
		children = Arrays.asList(new String[] { "JasoN", "jASOn", "JAsoN", "jASon", "JASON" });
		System.out.println(findChildren(santaList, children));
	}

}
