package text_blocks_examples;

public class Main {

    public static void main(String[] args) {
        String bulletIt = "Print a bullet list of items:\n" +
                "\t\u2022 1. Apples\n" +
                "\t\t\u2022 2. Bananas\n";

        System.out.println(bulletIt);

        String textBlock = """
                Print a bullet list of items:
                    \u2022 1. Apples
                        \u2022 2. Bananas
                """;
        System.out.println(textBlock);

        int age = 25;
        System.out.printf("You are %d years old.%n", age);

        int yearOfBirth = 2024 - age;
        System.out.printf("Age: %d, Year of Birth: %d%n", age, yearOfBirth);

        System.out.printf("Your age is %.2f%n", (float)age);

        for(int i = 1; i <= 100000; i *= 10) {
            System.out.printf("Printing = %6d%n", i);
        }

        String formattedString = String.format("You are %d years old.%n", age);
        System.out.println(formattedString);

        formattedString = "Age: %d, Year of Birth: %d%n".formatted(age, yearOfBirth);
        System.out.println(formattedString);


    }
}
