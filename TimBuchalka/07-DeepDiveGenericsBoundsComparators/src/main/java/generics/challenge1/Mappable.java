package generics.challenge1;

import java.util.Arrays;

/**
 * Interfaz que define el contrato para elementos que pueden ser renderizados en un mapa.
 * Esta es la interfaz que se utiliza como "bound" en la clase genérica Layer<T extends Mappable>.
 * Cualquier clase que implemente Mappable debe proporcionar un método render().
 */
public interface Mappable {

    /**
     * Método que debe implementar cualquier elemento que quiera ser mapeado/renderizado.
     */
    void render();

    /**
     * Método estático auxiliar que convierte una cadena de ubicación en coordenadas [latitud, longitud].
     * Ejemplo: "44.6,-110.5" se convierte en [44.6, -110.5]
     *
     * @param location String con formato "latitud,longitud"
     * @return Array de doubles [latitud, longitud]
     */
    static double[] stringToLatLon(String location) {
        var splits = location.split(",");
        return new double[]{Double.parseDouble(splits[0]), Double.parseDouble(splits[1])};
    }
}

/**
 * Clase abstracta que representa un punto en el mapa (una ubicación única).
 * Implementa Mappable y sirve como clase base para elementos de un solo punto (como Park).
 * Es abstracta porque Point es un concepto genérico; se utiliza principalmente como superclase.
 */
abstract class Point implements Mappable {
    // Array de tamaño 2: [latitud, longitud]
    private double[] location = new double[2];

    /**
     * Constructor que recibe la ubicación como un String y la convierte en coordenadas.
     * Utiliza el método estático de Mappable para parsear el String.
     *
     * @param location String con formato "latitud,longitud"
     */
    public Point(String location) {
        this.location = Mappable.stringToLatLon(location);
    }

    /**
     * Implementa render() para mostrar un punto en el mapa.
     * Imprime el nombre del objeto (del toString()) y sus coordenadas.
     */
    @Override
    public void render() {
        System.out.println("Render " + this + " as POINT (" + location() + ")");
    }

    /**
     * Método auxiliar privado para formatear la ubicación como String.
     * @return Representación en String del array de coordenadas
     */
    private String location() {
        return Arrays.toString(location);
    }
}

/**
 * Clase abstracta que representa una línea en el mapa (una serie de puntos conectados).
 * Implementa Mappable y sirve como clase base para elementos con múltiples puntos (como River).
 * Es abstracta porque Line es un concepto genérico; se utiliza principalmente como superclase.
 */
abstract class Line implements Mappable {
    // Matriz bidimensional: cada fila es un conjunto de coordenadas [latitud, longitud]
    private double[][] locations;

    /**
     * Constructor que recibe múltiples ubicaciones (varargs) y las convierte en coordenadas.
     * Crea un array bidimensional donde cada fila contiene un par de coordenadas.
     * Ejemplo: River("Mississippi", "47.2,-95.2", "29.1,-89.2") crea una línea con 2 puntos.
     *
     * @param locations Número variable de Strings con formato "latitud,longitud"
     */
    public Line(String... locations) {
        this.locations = new double[locations.length][];
        int index = 0;
        for(var l : locations) {
            this.locations[index++] = Mappable.stringToLatLon(l);
        }
    }

    /**
     * Implementa render() para mostrar una línea en el mapa.
     * Imprime el nombre del objeto (del toString()) y todos sus puntos de coordenadas.
     */
    @Override
    public void render() {
        System.out.println("Render" + this + " as LINE (" + locations() + ")");
    }

    /**
     * Método auxiliar privado para formatear todas las ubicaciones como String.
     * Utiliza Arrays.deepToString para representar la matriz bidimensional de coordenadas.
     * @return Representación en String de la matriz de coordenadas
     */
    private String locations() {
        return Arrays.deepToString(locations);
    }
}