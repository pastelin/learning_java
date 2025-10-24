package constructors_examples;

public class Main {

    public static void main(String[] args) {
//        Account account = new Account("56789", 2.50, "Default name", "Default address", "default phone");

        Account account = new Account();
        System.out.println(account.getAccountNumber());
        System.out.println(account.getBalance());

//        account.setAccountNumber("123456");
//        account.setCustomerName("John Doe");
//        account.setBalance(1000.0);
//        account.setEmail("pruebas@gmail.com");
//        account.setPhoneNumber("555-1234");

        System.out.println("Balance: " + account.getBalance());
        account.depositFunds(500.0);
        System.out.println("Balance: " + account.getBalance());
        account.withdrawFunds(200.0);
        System.out.println("Balance: " + account.getBalance());
        account.withdrawFunds(2000.0);
        System.out.println("Balance: " + account.getBalance());

        Account timsAccoun = new Account("Tim", "tim@email.com", "12345");
        System.out.println(timsAccoun.getAccountNumber() + " name " + timsAccoun.getCustomerName());

    }
}
