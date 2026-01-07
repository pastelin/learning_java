package arraylist;

import java.util.ArrayList;
import java.util.Arrays;

record GroceryItem(String name, String type, int count) {
    public GroceryItem(String name) {
        this(name, "Dairy", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}

public class Main {

    public static void main(String[] args) {

        // Crear un arreglo de GroceryItem con tamaño fijo
        GroceryItem[] groceryArray = new GroceryItem[3];
        groceryArray[0] = new GroceryItem("Milk"); // Usar el constructor con valores predeterminados
        groceryArray[1] = new GroceryItem("Bread", "Bakery", 2); // Usar el constructor completo
        groceryArray[2] = new GroceryItem("oranges", "Produce", 5); // Otro ejemplo
        System.out.println(Arrays.toString(groceryArray)); // Imprime el arreglo

        // Crear un ArrayList sin tipo específico (no recomendado)
        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Eggs", "Dairy", 12)); // Agregar un objeto GroceryItem
        objectList.add("Yogurt"); // Agregar un String (mezcla de tipos)

        // Crear un ArrayList tipado (recomendado)
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Eggs", "Dairy", 12)); // Agregar un GroceryItem
        groceryList.add(new GroceryItem("Yogurt", "Dairy", 6)); // Otro GroceryItem
        groceryList.add(new GroceryItem("Apples")); // Usar el constructor con valores predeterminados

        // Reemplazar un elemento en un índice específico
        groceryList.set(0, new GroceryItem("Bananas", "Produce", 8));

        // Eliminar un elemento por índice
        groceryList.remove(1);

        // Imprimir la lista
        System.out.println(groceryList);

    }
}
