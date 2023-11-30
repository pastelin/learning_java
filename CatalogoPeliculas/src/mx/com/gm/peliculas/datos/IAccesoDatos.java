package mx.com.gm.peliculas.datos;

import java.util.List;

import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.AccesoDatosEx;
import mx.com.gm.peliculas.excepciones.EscrituraDatosEx;
import mx.com.gm.peliculas.excepciones.LecturaDatosEx;

public interface IAccesoDatos {

	/**
	 * Firma de metodo que indica si el archivo indicado existe o no
	 * 
	 * @param nombreRecurso : recurso a buscar
	 * @return boolean
	 * @throws AccesoDatosEx clase que se ejecuta al haber un error
	 */
	boolean existe(String nombreRecurso) throws AccesoDatosEx;

	/**
	 * Firma de metodo que obtiene una lista (Collection) de Peliculas
	 * 
	 * @param nombreRecurso : recurso a buscar
	 * @return List
	 * @throws LecturaDatosEx
	 */
	abstract List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;

	/**
	 * Firma de metodo que escribe sobre archivo especificado
	 * 
	 * @param pelicula      objeto a insertar
	 * @param nombreRecurso recurso a editar
	 * @throws EscrituraDatosEx
	 */
	void escribir(Pelicula pelicula, String nombreRecurso) throws EscrituraDatosEx;

	/**
	 * Firma de metodo para buscar una pelicula dentro del recurso especificado
	 * 
	 * @param nombreRecurso recurso donde se buscara la pelicula
	 * @param buscar        nombre de la pelicula a buscar
	 * @return String
	 * @throws LecturaDatosEx
	 */
	String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;

	/**
	 * Firma de metodo para crear un recurso
	 * 
	 * @param nombreRecurso recurso a crear
	 * @throws AccesoDatosEx
	 */
	void crear(String nombreRecurso) throws AccesoDatosEx;

	/**
	 * Firma de metodo para eliminar un recurso
	 * 
	 * @param nombreRecurso recurso a eliminar
	 * @throws AccesoDatosEx
	 */
	void borrar(String nombreRecurso) throws AccesoDatosEx;

}
