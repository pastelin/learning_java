package strings_examples;

public class Main {

    public static void main(String[] args) {

        printInformation("Hello, World!");
        printInformation("");
        printInformation("   ");

        String helloWorld = "Hello, World!";
        System.out.printf("index of W: %d%n", helloWorld.indexOf('W'));
        System.out.printf("index of o: %d%n", helloWorld.indexOf('o'));

        System.out.printf("last index of o: %d%n", helloWorld.lastIndexOf('o'));
        System.out.printf("index of o after index 5: %d%n", helloWorld.indexOf('o', 5));
        System.out.printf("index of Java: %d%n", helloWorld.indexOf("Java"));

        String helloWorldLower = helloWorld.toLowerCase();
        if (helloWorldLower.equals("hello, world!")) {
            System.out.println("Strings are equal (case insensitive)");
        }

        if (helloWorld.equalsIgnoreCase("hello, world!")) {
            System.out.println("Strings are equal (case insensitive)");
        }

        if (helloWorld.startsWith("Hello")) {
            System.out.println("String starts with Hello");
        }

        if (helloWorld.endsWith("!")) {
            System.out.println("String ends with !");
        }

        if (helloWorld.contains("lo, Wo")) {
            System.out.println("String contains lo, Wo");
        }

        if (helloWorld.contentEquals("Java")) {
            System.out.println("String content equals Java");
        }

    }

    public static void printInformation(String string) {
         int length = string.length();
        System.out.printf("Length: %d%n", length);

        if (string.isEmpty()) {
            System.out.println("The string is empty.");
            return;
        }

        if(string.isBlank()) {
            System.out.println("The string is blank.");
            return;
        }

        System.out.printf("First character: %c%n", string.charAt(0));

        System.out.printf("Last character: %c%n", string.charAt(length - 1));
    }

}
