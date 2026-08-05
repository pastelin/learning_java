package generics.challenge1;

/**
 * Clase que representa un río en un mapa.
 * Extiende Line porque un río está representado por múltiples puntos conectados (desde su origen hasta su desembocadura).
 * Implementa indirectamente Mappable a través de Line.
 * Por lo tanto, puede ser utilizado como tipo genérico en Layer<River>.
 */
public class River extends Line {

    // Nombre del río
    String name;

    /**
     * Constructor que crea un río con su nombre y múltiples ubicaciones.
     * Las ubicaciones típicamente representan el origen y la desembocadura del río.
     *
     * @param name Nombre del río
     * @param locations Número variable de Strings con formato "latitud,longitud"
     *                  que se pasan al constructor de Line
     */
    public River(String name, String... locations) {
        super(locations);
        this.name = name;
    }

    /**
     * Retorna una representación en String amigable del río.
     * Se utiliza en el método render() de Line para mostrar qué elemento se está renderizando.
     *
     * @return Cadena con el formato "Nombre River"
     */
    @Override
    public String toString() {
        return name + " River";
    }
}
