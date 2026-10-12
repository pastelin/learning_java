import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AddressBook {

    private HashMap<String, String> contacts;
    private static Path filePath;


    public AddressBook() {
        this.contacts = new HashMap<>();
        filePath = Path.of("data", "contacts.csv");
        load();
    }

    private void load() {

        Path path = filePath.getParent();

        if (Files.notExists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                System.out.println("Error al crear el directorio: " + e.getMessage());
            }
        }

        if (Files.notExists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
        }

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length == 2) {
                    contacts.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void save() {
        try {
            List<String> lines = new ArrayList<>();

            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                String phone = entry.getKey();
                String name = entry.getValue();
                lines.add(phone + "," + name);
            }
            Files.write(filePath, lines);
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public void list() {
        if (contacts.isEmpty()) {
            System.out.println("No hay contactos en la agenda.");
            return;
        }

        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            String phone = entry.getKey();
            String name = entry.getValue();

            System.out.println("Contactos");
            System.out.println(phone + " : " + name);
        }
    }

    public void create(String name, String phone) {

        if (name == null || name.isBlank() || phone == null || phone.isBlank()) {
            System.out.println("Nombre o teléfono no pueden estar vacíos.");
            return;
        }

        if (contacts.containsKey(phone)) {
            System.out.println("El contacto ya existe.");
        } else {
            contacts.put(phone.trim(), name.trim());
            this.save();
            System.out.println("Contacto agregado: " + name + " con teléfono: " + phone);
        }
    }

    public void delete(String phone) {

        if (contacts.containsKey(phone)) {
            contacts.remove(phone);
            this.save();
            System.out.println("Contacto eliminado correctamente.");
        } else {
            System.out.println("Contacto no encontrado.");
        }
    }

}
