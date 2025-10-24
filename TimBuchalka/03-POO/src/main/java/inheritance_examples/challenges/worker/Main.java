package inheritance_examples.challenges.worker;

public class Main {

    public static void main(String[] args) {
        Employee tim = new Employee("Tim", "01/01/1990", "01/01/2020");
        System.out.println(tim);
        System.out.println("Age: " + tim.getAge());
        System.out.println("Pay: " + tim.collectPay());

        SalariedEmployee jane = new SalariedEmployee("Jane", "02/02/1985", "02/02/2015", 85000);
        System.out.println(jane);
        System.out.println("jane's Pay: " + jane.collectPay());
        jane.retire();
        System.out.println("jane's Pay after retirement: " + jane.collectPay());

        HourlyEmployee bob = new HourlyEmployee("Bob", "03/03/1995", "03/03/2020", 15.50);
        System.out.println(bob);
        System.out.println("bob's Pay: " + bob.collectPay());
        System.out.println("bob's Double Pay: " + bob.getDoublePay());
        
    }
}
