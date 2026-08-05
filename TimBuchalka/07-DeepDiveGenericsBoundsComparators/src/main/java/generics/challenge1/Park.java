package generics.challenge1;

/**
 * Clase que representa un parque nacional.
 * Extiende Point porque un parque tiene una ubicación única en el mapa.
 * Implementa indirectamente Mappable a través de Point.
 * Por lo tanto, puede ser utilizado como tipo genérico en Layer<Park>.
 */
public class Park extends Point {

    // Nombre del parque nacional
    String name;

    /**
     * Constructor que crea un parque con su nombre y ubicación.
     *
     * @param name Nombre del parque nacional
     * @param location String con formato "latitud,longitud" que se pasa al constructor de Point
     */
    public Park(String name, String location) {
        super(location);
        this.name = name;
    }

    /**
     * Retorna una representación en String amigable del parque.
     * Se utiliza en el método render() de Point para mostrar qué elemento se está renderizando.
     *
     * @return Cadena con el formato "Nombre National Park"
     */
    @Override
    public String toString() {
        return name + " National Park";
    }
}
