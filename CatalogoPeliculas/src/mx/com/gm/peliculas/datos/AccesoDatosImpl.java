package mx.com.gm.peliculas.datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public class AccesoDatosImpl implements IAccesoDatos {

	@Override
	public boolean existe(String nombreRecurso) {
		return Files.exists(Paths.get(nombreRecurso));
	}

	@Override
	public void escribir(Pelicula pelicula, String nombreRecurso) throws EscrituraDatosEx {
		// Path: An object that may be used to locate a file in a file system

		// Paths: This class consists exclusively of static methods that return a Path by converting a path string or URI.
		Path fileDir = Paths.get(nombreRecurso);

		// Files: This class consists exclusively of static methods that operate on files,directories, or other types of files.
		
		// BufferedWriter: Writes text to a character-output stream, buffering characters so as toprovide for the efficient 
		// writing of single characters, arrays, and strings. 

		// newBufferedWriter: Opens or creates a file for writing, returning a BufferedWriterto write text to the 
		// file in an efficient manner. The text is encodedinto bytes for writing using the UTF-8 charset.
		try (BufferedWriter bw = Files.newBufferedWriter(fileDir, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
			bw.write(pelicula.toString());
			bw.newLine();
			System.out.println("Se ha escrito informacion al archivo: " + pelicula);
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new EscrituraDatosEx("Exepcion al escribir peliculas: " + ex.getMessage());
		}

	}
	
	@Override
	public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {

		List<Pelicula> peliculas = new ArrayList<>();

		// BufferedReader: Reads text from a character-input stream, buffering characters so as toprovide for the efficient 
		// reading of characters, arrays, and lines.
		
		// newBufferedReader: Opens a file for reading, returning a BufferedReader to read textfrom the file in an efficient 
		// manner. Bytes from the file are decoded intocharacters using the UTF-8 charset. 
		try (BufferedReader entrada = Files.newBufferedReader(Paths.get(nombreRecurso))) {
			// Stream: A sequence of elements supporting sequential and parallel aggregate operations.
			// Collectors.toList() : acumula los elementos de la secuencia en una nueva lista
			peliculas = entrada.lines()
					.map(item -> new Pelicula(item))
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return peliculas;
	}

	@Override
	public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
		String resultado = "";

		try(BufferedReader entrada = Files.newBufferedReader(Paths.get(nombreRecurso))) {
			
			resultado = entrada.lines()
					.filter(item -> item.equalsIgnoreCase(buscar))
					.collect(Collectors.joining());
			
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new LecturaDatosEx("Exepcion al buscar peliculas: " + ex.getMessage());
		}

		return resultado.equals("") ? "No se encontraron coincidencias" : "La pelicula '" + resultado + "' existe en el catalogo!!!";
	}

	@Override
	public void crear(String nombreRecurso) throws AccesoDatosEx {
		Path fileDir = Paths.get(nombreRecurso);

		try (BufferedWriter bw = Files.newBufferedWriter(fileDir, StandardOpenOption.CREATE)) {
			System.out.println("Se ha creado el archivo");
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new EscrituraDatosEx("Exepcion al escribir peliculas: " + ex.getMessage());
		}
		
	}

	@Override
	public void borrar(String nombreRecurso) {
		Path fileDir = Paths.get(nombreRecurso);
		
		try {
			Files.deleteIfExists(fileDir);
			System.out.println("Se ha borrado el archivo");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
