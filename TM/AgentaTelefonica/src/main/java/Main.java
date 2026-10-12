import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        AddressBook agenda = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=".repeat(30));
            System.out.println("Seleccione una opción:");
            System.out.println("1. Listar contactos");
            System.out.println("2. Agregar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Salir");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    agenda.list();
                    break;
                case "2":
                    System.out.println("Ingrese el nombre del contacto:");
                    String name = scanner.nextLine();
                    System.out.println("Ingrese el número de teléfono del contacto:");
                    String phone = scanner.nextLine();
                    agenda.create(name, phone);
                    break;
                case "3":
                    System.out.println("Ingrese el número de teléfono del contacto a eliminar:");
                    String phoneToDelete = scanner.nextLine();
                    agenda.delete(phoneToDelete);
                    break;
                case "4":
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}
