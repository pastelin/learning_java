package generics.challenge1;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase genérica que representa una capa de elementos en un mapa.
 * El parámetro de tipo T está limitado por un "upper bound" (T extends Mappable),
 * lo que significa que solo acepta tipos que implementen la interfaz Mappable.
 * Esto garantiza que todos los elementos tengan el método render().
 */
public class Layer<T extends Mappable> {

    // Lista interna que almacena los elementos de la capa
    private List<T> layerElements;

    /**
     * Constructor que inicializa la capa con un array de elementos.
     * El array se convierte en una ArrayList para permitir agregar más elementos después.
     *
     * @param layerElements Array de elementos que implementan Mappable
     */
    public Layer(T[] layerElements) {
        this.layerElements = new ArrayList<>(List.of(layerElements));
    }

    /**
     * Método que permite agregar múltiples elementos a la capa de una sola vez.
     * Utiliza parámetros variádicos (varargs) para aceptar cantidad variable de argumentos.
     *
     * @param elements Número variable de elementos del tipo T que implementan Mappable
     */
    @SafeVarargs
    public final void addElements(T... elements) {
        layerElements.addAll(List.of(elements));
    }

    /**
     * Renderiza todos los elementos de la capa.
     * Itera sobre cada elemento y llama su método render(),
     * que es garantizado por la interfaz Mappable.
     */
    public void renderLayer() {
        for (T element : layerElements) {
            element.render();
        }
    }
}
