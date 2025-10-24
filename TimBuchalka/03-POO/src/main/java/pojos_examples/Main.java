package pojos_examples;

public class Main {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {
            LPAStudent s = new LPAStudent(
                    "S00" + i,
                    switch (i) {
                        case 1 -> "Alice";
                        case 2 -> "Bob";
                        case 3 -> "Charlie";
                        case 4 -> "Diana";
                        case 5 -> "Ethan";
                        default -> "Unknown";
                    },
                    "200" + i + "-01-01",
                    "Class " + ((i % 3) + 1)
            );
            System.out.println(s);
        }

        Student pojoStudent = new Student("S001", "Alice", "2001-01-01", "Class 1");
        LPAStudent recordStudent = new LPAStudent("S001", "Alice", "2001-01-01", "Class 1");

        System.out.println(pojoStudent);
        System.out.println(recordStudent);

        System.out.println("POJO Student ID: " + pojoStudent.getId());
        System.out.println("Record Student ID: " + recordStudent.id());
    }
}
