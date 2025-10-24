package stringbuilder_examples;

public class Main {

    public static void main(String[] args) {

        String helloWorld = "Hello, World!";
        helloWorld.concat(" and Goodbye!"); // creates a new String, does not modify the original

        printInformation(helloWorld);
        printInformation("");
        printInformation("   ");

        StringBuilder sb = new StringBuilder("Hello, World!");
        sb.append(" and Goodbye!"); // modifies the original StringBuilder
        printInformation(sb);

        StringBuilder emptySb = new StringBuilder();
        printInformation(emptySb);

        StringBuilder emptyStart = new StringBuilder();
        emptyStart.append("a".repeat(57));

        StringBuilder emptyStart32 = new StringBuilder(32);
        emptyStart32.append("a".repeat(17));

        printInformation(emptyStart);
        printInformation(emptyStart32);

        StringBuilder builderPlus = new StringBuilder("Hello, World!");
        builderPlus.append(" and Goodbye!"); // modifies the original StringBuilder

        builderPlus.deleteCharAt(16).insert(16, 'g');
        System.out.println(builderPlus);

        builderPlus.replace(16,17, "G");
        System.out.println(builderPlus);

        builderPlus.reverse().setLength(7);
        System.out.println(builderPlus);

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
    }

    public static void printInformation(StringBuilder sb) {
        int length = sb.length();
        int capacity = sb.capacity();
        System.out.printf("Length: %d, Capacity: %d%n", length, capacity);

        if (length == 0) {
            System.out.println("The StringBuilder is empty.");
            return;
        }

        System.out.printf("First character: %c%n", sb.charAt(0));
    }
}
