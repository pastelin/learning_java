package inheritance_examples;

import java.util.Objects;

public class Dog extends Animal {

    private String earShape;
    private String tailShape;

    public Dog() {
        super("Dog", "Medium", 30);
    }

    public Dog(String type, double weight) {
        this(type, weight, "Floppy", "Curled");
    }

    public Dog(String type, double weight, String earShape, String tailShape) {
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"), weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "earShape='" + earShape + '\'' +
                ", tailShape='" + tailShape + '\'' +
                "} " + super.toString();
    }

    @Override
    public void makeNoise() {
        if (Objects.equals(type, "Wolf")) {
            System.out.println("Ow Wooooo!");
        }
        bark();
        System.out.println();
    }

    public void move(String speed) {
        super.move(speed);
//        System.out.println("Dog wagging its tail");
        if(speed.equals("fast") || speed.equals("quickly") || speed.equals("super fast")){
            run();
            bark();
        } else {
            walk();
            bark();
        }
    }

    private void bark(){
        System.out.println("Woof Woof");
    }

    private void run(){
        System.out.println("Dog is running");
    }

    private void walk(){
        System.out.println("Dog is walking");
    }

    private void wagTail() {
        System.out.println("Tail Wagging");
    }


}
