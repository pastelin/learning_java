package polymorphism_examples.challenge_01;

public class Main {

    public static void main(String[] args) {

        Car car = new Car("2022 Blue Ford Mustang");
        runRace(car);

        GasPoweredCar gasPoweredCar = new GasPoweredCar("2022 Green Ford F150", 15.5, 8);
        runRace(gasPoweredCar);

        ElectricCar electricCar = new ElectricCar("2022 Red Tesla Model S", 25.0, 100);
        runRace(electricCar);

        HybridCar hybridCar = new HybridCar("2022 Silver Toyota Prius", 20.0, 6, 75);
        runRace(hybridCar);
    }

    public static void runRace(Car car) {
        car.startEngine();
        car.drive();
    }
}
