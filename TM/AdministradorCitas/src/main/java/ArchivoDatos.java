import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArchivoDatos {

    private Path rutaArchivo;

    public ArchivoDatos(Path rutaArchivo) {
        this.rutaArchivo = rutaArchivo;

        Path path = rutaArchivo.getParent();
        if(Files.notExists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                System.out.println("Error al crear el directorio: " + e.getMessage());
            }
        }

        if(Files.notExists(rutaArchivo)) {
            try {
                Files.createFile(rutaArchivo);
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
        }
    }

    public Map<String, List<String>> leerArchivo() {

        try (BufferedReader reader = Files.newBufferedReader(rutaArchivo)) {
            String line;
            Map<String, List<String>> datos = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String key = parts[0];
                    List<String> values = Arrays.asList(Arrays.copyOfRange(parts, 1, parts.length));
                    datos.put(key, values);
                }
            }
            return datos;
        } catch (IOException e) {
            throw new RuntimeException(e);

        }
    }

    public void escribirArchivo(Map<String, List<String>> datos) {
        StringBuilder contenido = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : datos.entrySet()) {
            contenido.append(entry.getKey());
            for (String value : entry.getValue()) {
                contenido.append(",").append(value);
            }
            contenido.append(System.lineSeparator());
        }

        try {
            Files.writeString(rutaArchivo, contenido.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
