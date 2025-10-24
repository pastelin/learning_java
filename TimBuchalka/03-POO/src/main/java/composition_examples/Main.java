package composition_examples;

public class Main {

    public static void main(String[] args) {
        ComputerCase theCase = new ComputerCase("220B", "Dell", "240");
        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, "2540x1440");
        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

        PersonalComputer personalComputer = new PersonalComputer("2208", "Dell", theCase, theMonitor, theMotherboard);

//        personalComputer.getMonitor().drawPixelAt(1500, 1200, "red");
//        personalComputer.getMotherboard().loadProgram("Windows 1.0");
//        personalComputer.getComputerCase().pressPowerButton();

        personalComputer.powerUp();
    }
}
