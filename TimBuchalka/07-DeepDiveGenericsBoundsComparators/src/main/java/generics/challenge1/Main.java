package generics.challenge1;

/**
 * Clase principal que demuestra el uso de genéricos con bounds (límites de tipos).
 * Este challenge muestra cómo usar la clase genérica Layer<T> con diferentes tipos
 * de elementos que implementan la interfaz Mappable (Park y River).
 */
public class Main {

    public static void main(String[] args) {
        // Crear un array de parques nacionales de EE.UU. con sus coordenadas de ubicación
        var nationalUSParks = new Park[]{
                new Park("Yellowstone", "44.6,-110.5"),
                new Park("Yosemite", "37.8,-119.5"),
                new Park("Grand Canyon", "36.1,-112.1")
        };

        // Crear una Layer genérica que solo acepta elementos del tipo Park
        // Layer<T extends Mappable> garantiza que solo se puede pasar tipos que implementen Mappable
        Layer<Park> parkLayer = new Layer<>(nationalUSParks);
        parkLayer.renderLayer();

        // Crear un array de ríos importantes de EE.UU. con coordenadas de inicio y fin
        var majorUSRivers = new River[]{
                new River("Mississippi", "47.2,-95.2", "29.1,-89.2"),
                new River("Missouri", "45.0,-104.0", "38.8,-90.2")
        };

        // Crear una Layer genérica para ríos (otro tipo que implementa Mappable)
        Layer<River> riverLayer = new Layer<>(majorUSRivers);

        // Agregar elementos adicionales a la capa de ríos usando el método variádico addElements
        riverLayer.addElements(
                new River("Colorado", "40.0,-109.0", "31.8,-114.8"),
                new River("Delaware", "41.0,-75.0", "39.7,-75.5")
        );

        // Renderizar todos los ríos (que ahora incluye los nuevos agregados)
        riverLayer.renderLayer();
    }
}
