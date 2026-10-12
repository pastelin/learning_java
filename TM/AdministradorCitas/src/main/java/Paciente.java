import java.util.UUID;

public class Paciente {

    private String id;
    private String nombre;

    public Paciente(String nombre) {
        this.id = "PAC-" + UUID.randomUUID();
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
