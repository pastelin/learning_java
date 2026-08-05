package comparing.comparable_natural_order;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0, 5, 10, -50, 50};

        for (Integer number : others) {
            int value = five.compareTo(number);
            System.out.printf("%d %s %d: compareTo=%d%n", five, (value < 0 ? "<" : (value > 0 ? ">" : "==")), number, value);
        }

        String banana = "banana";
        String[] fruits = {"apple", "banana", "orange", "grape", "BANANA"};

        for (String fruit : fruits) {
            int value = banana.compareTo(fruit);
            System.out.printf("%s %s %s: compareTo=%d%n", banana, (value < 0 ? "<" : (value > 0 ? ">" : "==")), fruit, value);
        }

        Arrays.sort(fruits);
        System.out.println("Sorted fruits: " + Arrays.toString(fruits));

        System.out.println("A:" + (int) 'A' + " " + "a:" + (int) 'a');
        System.out.println("B:" + (int) 'B' + " " + "b:" + (int) 'b');
        System.out.println("P:" + (int) 'P' + " " + "p:" + (int) 'p');

        Student[] students = {
                new Student("Alice"),
                new Student("Bob"),
                new Student("Charlie")
        };

        Arrays.sort(students);
        System.out.println("Sorted students: " + Arrays.toString(students));

        System.out.println("result = " + students[0].compareTo(new Student("Bob")));

        Comparator<Student> gpaComparator = new StudentGPAComparator();
        Arrays.sort(students, gpaComparator.reversed());
        System.out.println("Sorted students by GPA: " + Arrays.toString(students));
    }
}

class StudentGPAComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}

class Student implements Comparable<Student> {
    String name;
    private int id;
    protected double gpa;

    private static int LAST_ID = 1000;
    private static Random random = new Random();

    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0, 4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id, name, gpa);
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(id, o.id);
    }
}