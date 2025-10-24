package class_examples.challenge;

public class Main {

    public static void main(String[] args) {
        Account account = new Account();

        account.setAccountNumber("123456");
        account.setCustomerName("John Doe");
        account.setBalance(1000.0);
        account.setEmail("pruebas@gmail.com");
        account.setPhoneNumber("555-1234");

        System.out.println("Balance: " + account.getBalance());
        account.depositFunds(500.0);
        System.out.println("Balance: " + account.getBalance());
        account.withdrawFunds(200.0);
        System.out.println("Balance: " + account.getBalance());
        account.withdrawFunds(2000.0);
        System.out.println("Balance: " + account.getBalance());

    }
}
