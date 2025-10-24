package class_examples;

public class Main {

    public static void main(String[] args) {
        Car car1 = new Car();
        System.out.println("make: " + car1.getMake());
        System.out.println("model: " + car1.getModel());
        car1.describeCar();
    }
}
