package inheritance_examples.challenges.worker;

public class SalariedEmployee extends Employee{

    double annualSalary;
    boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String hireDate, double annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
        this.isRetired = false;
    }

    @Override
    public double collectPay() {
        double payCheck = annualSalary / 26;
        return (int) (isRetired ? payCheck * 0.9 : payCheck);
    }

    public void retire() {
        terminate("12/31/2025");
        this.isRetired = true;
    }
}
