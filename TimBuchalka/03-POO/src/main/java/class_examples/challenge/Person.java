package class_examples.challenge;

public class Person {

    private String firstName;
    private String lastName;
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        if (age < 0 || age > 100) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public boolean isTeen() {
        return (age > 12 && age < 20);
    }

    public String getFullName() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstName == null ? "" : firstName);
        if (firstName != null && lastName != null && !firstName.isEmpty() && !lastName.isEmpty()) {
            sb.append(" ");
        }
        sb.append(lastName == null ? "" : lastName);
        return sb.toString();
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("");   // firstName is set to empty string
        person.setLastName("Smith");    // lastName is set to Smith
        person.setAge(18);

        System.out.println("fullName= " + person.getFullName());
    }
}
