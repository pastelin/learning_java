package mx.com.gm.peliculas.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExceptionsExample {

	public static void main(String[] args) {

//		System.out.println(getNombre());
//		System.out.println(getNombreWithTryCatch());
//		System.out.println(getDivision());
		setEdad(-10);

	}

	// Ejemplo 01
	private static String getNombre() {

		List<String> nombres = new ArrayList<>(Arrays.asList(new String[] { "Ulises", "Cesar", "Alfredo" }));

		return nombres.get(nombres.size());
	}

	// Ejemplo 01
	private static String getNombreWithTryCatch() {

		String nombre = "No se obtuvo el nombre";

		try {
			List<String> nombres = new ArrayList<>(Arrays.asList(new String[] { "Ulises", "Cesar", "Alfredo" }));
			nombre = nombres.get(nombres.size());

		} catch (IndexOutOfBoundsException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}

		return nombre;
	}

	// Ejemplo 02
	private static int getDivision() {
		return 100 / 0;
	}

	// Ejemplo 03
	public static void setEdad(int edad) {
		if (edad < 0) {
			throw new IllegalArgumentException("Age cannot be negative");
		}
	}

}
