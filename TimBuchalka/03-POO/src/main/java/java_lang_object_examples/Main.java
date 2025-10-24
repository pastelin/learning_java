package java_lang_object_examples;

public class Main extends Object {

    public static void main(String[] args) {

        Student max = new Student("Max", 21);
        System.out.println(max.toString());

        PrimarySchoolStudent jane = new PrimarySchoolStudent("Jane", 10, "Mary");
        System.out.println(jane);
    }


}

class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class PrimarySchoolStudent extends Student {

    private String parentName;

    PrimarySchoolStudent(String name, int age, String parentName) {
        super(name, age);
        this.parentName = parentName;
    }

    public String toString() {
        return parentName + "'s child is a " + super.toString();
    }
}
