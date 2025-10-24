package inheritance_examples;

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal("Generic Animal", "Medium", 50);
        doAnimalStuff(animal, "slowly");

        Dog dog = new Dog();
        doAnimalStuff(dog, "fast");

        Dog dog1 = new Dog("Yorkie", 10);
        doAnimalStuff(dog1, "quickly");

        Dog dog2 = new Dog("German Shepherd", 65, "Pointy", "Long");
        doAnimalStuff(dog2, "super fast");

        Dog dog3 = new Dog("Wolf", 70, "Pointy", "Long");
        doAnimalStuff(dog3, "super fast");

        Fish fish = new Fish("Goldfish", 1, 2, 6);
        doAnimalStuff(fish, "slowly");
        doAnimalStuff(fish, "fast");


    }

    public static void doAnimalStuff(Animal animal, String speed){
        animal.makeNoise();
        animal.move(speed);
        System.out.println(animal.toString());
        System.out.println("=======================");
    }
}
