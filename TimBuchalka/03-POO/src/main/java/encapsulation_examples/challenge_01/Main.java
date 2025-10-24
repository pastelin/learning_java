package encapsulation_examples.challenge_01;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer(50, false);
        System.out.println("Initial page count = " + printer.getPagesPrinted());

        int pagesPrinted = printer.printPages(4);
        System.out.printf("Current Job pages: %d, Printer Total: %d%n", pagesPrinted, printer.getPagesPrinted());

        pagesPrinted = printer.printPages(10);
        System.out.printf("Current Job pages: %d, Printer Total: %d%n", pagesPrinted, printer.getPagesPrinted());
    }

}
