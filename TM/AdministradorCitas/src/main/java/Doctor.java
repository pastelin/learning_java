import java.util.UUID;

public class Doctor {

    private String id;
    private String nombre;
    private String especialidad;

    public Doctor(String nombre, String especialidad) {
        this.id = "DOC-" + UUID.randomUUID();
        this.especialidad = especialidad;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}
