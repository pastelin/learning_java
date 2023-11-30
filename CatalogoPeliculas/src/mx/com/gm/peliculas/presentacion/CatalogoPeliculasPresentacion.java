package mx.com.gm.peliculas.presentacion;

import java.util.Scanner;

import mx.com.gm.peliculas.servicio.CatalogoPeliculasImpl;
import mx.com.gm.peliculas.servicio.ICatalogoPeliculas;

public class CatalogoPeliculasPresentacion {

	public static void main(String[] args) {

		int opcion = -1;
		Scanner scanner = new Scanner(System.in);
		ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

		while (opcion != 0) {
			System.out.println(menu());
			opcion = Integer.parseInt(scanner.nextLine());

			switch (opcion) {
			case 1:
				catalogo.iniciarCatalogoPeliculas();
				break;
			case 2:
				System.out.println("Introduce el nombre de la pelicula");
				String nombrePelicula = scanner.nextLine();
				catalogo.agregarPelicula(nombrePelicula);
				break;
			case 3:
				System.out.println("Lista de películas almacenadas");
				System.out.println("**********************************");
				catalogo.listarPeliculas();
				System.out.println("**********************************");
				break;
			case 4:
				System.out.println("Introduce una pelicula a buscar");
				String buscar = scanner.nextLine();
				catalogo.buscarPelicula(buscar);
				break;
			case 0:
				System.out.println("Hasta Pronto!");
				break;
			default:
				System.out.println("Opción no reconocida");
			}
		}

		scanner.close();
	}

	private static String menu() {

		StringBuilder sb = new StringBuilder();
		sb.append("----------------------------------------- \n");
		sb.append("Elige una opción: \n");
		sb.append("1. Iniciar catalogo peliculas \n");
		sb.append("2. Agregar pelicula \n");
		sb.append("3. Listar pelicula \n");
		sb.append("4. Buscar pelicula \n");
		sb.append("0. Salir \n");
		sb.append("-----------------------------------------\n");
		
		return sb.toString();
	}

}
