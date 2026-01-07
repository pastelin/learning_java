package varargs;

public class Main {

    public static void main(String... args) {

        // Imprimir un mensaje inicial en la consola
        System.out.println("Hello World again");

        // Dividir una cadena en un arreglo de palabras utilizando el espacio como delimitador
        String[] splitStrings = "Hello World again".split(" ");
        // Llamar al método printStrings para imprimir cada palabra del arreglo
        printStrings(splitStrings);

        // Imprimir una línea separadora utilizando el carácter "_" repetido 20 veces
        System.out.println("_".repeat(20));
        // Llamar al método printStrings con un solo argumento
        printStrings("Hello");

        // Imprimir otra línea separadora
        System.out.println("_".repeat(20));
        // Llamar al método printStrings sin argumentos
        printStrings();

        // Declarar un arreglo de cadenas con nombres de lenguajes de programación
        String[] sArray = {"Java", "Python", "C++", "JavaScript"};
        // Unir los elementos del arreglo en una sola cadena separada por comas y espacios
        System.out.println(String.join(", ", sArray));
    }

    // Método que acepta un número variable de argumentos de tipo String
    private static void printStrings(String... strings) {
        // Recorrer cada cadena en el arreglo de argumentos y imprimirla
        for (String str : strings) {
            System.out.println(str);
        }
    }
}
