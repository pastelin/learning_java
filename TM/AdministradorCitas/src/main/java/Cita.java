import java.util.UUID;

public class Cita {

    private String id;
    private String fecha;
    private String hora;
    private String idPaciente;
    private String idDoctor;

    public Cita(String fecha, String hora, String paciente, String doctor) {
        this.id = "CIT-" + UUID.randomUUID();
        this.fecha = fecha;
        this.hora = hora;
        this.idPaciente = paciente;
        this.idDoctor = doctor;
    }

    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public String getIdDoctor() {
        return idDoctor;
    }
}
