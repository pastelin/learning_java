import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Aplicacion {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nSistema de administración de citas médicas");
            System.out.println("=".repeat(30));
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            switch (scanner.nextLine()) {
                case "1":
                    iniciarSesion();
                    break;
                case "2":
                    registrarse();
                    break;
                case "3":
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    public static void iniciarSesion() {
        System.out.println("\nInicio de Sesión");
        System.out.println("=".repeat(30));

        System.out.println("Ingrese su nombre de usuario:");
        String nombreUsuario = scanner.nextLine();

        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.nextLine();

        ArchivoDatos archivoUsuarios = new ArchivoDatos(Path.of("data", "usuarios.csv"));
        Map<String, List<String>> usuarios = archivoUsuarios.leerArchivo();

        if (usuarios.containsKey(nombreUsuario) && usuarios.get(nombreUsuario).get(0).equals(contrasena)) {
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + nombreUsuario + "!");
            menuPrincipal();
        } else {
            System.out.println("Nombre de usuario o contraseña incorrectos. Intente nuevamente.");
        }
    }

    public static void menuPrincipal() {
        while (true) {
            System.out.println("\nMenú Principal");
            System.out.println("=".repeat(30));
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar doctor");
            System.out.println("2. Registrar paciente");
            System.out.println("3. Crear cita");
            System.out.println("4. Ver citas");
            System.out.println("5. Cerrar sesión");

            switch (scanner.nextLine()) {
                case "1":
                    registrarDoctor();
                    break;
                case "2":
                    registrarPaciente();
                    break;
                case "3":
                    crearCita();
                    break;
                case "4":
                    verCitas();
                    break;
                case "5":
                    System.out.println("Cerrando sesión...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    public static void registrarse() {
        System.out.println("\nRegistro de Usuario");
        System.out.println("=".repeat(30));

        System.out.println("Ingrese un nombre de usuario:");
        String nombreUsuario = scanner.nextLine();

        System.out.println("Ingrese una contraseña:");
        String contrasena = scanner.nextLine();

        ArchivoDatos archivoUsuarios = new ArchivoDatos(Path.of("data", "usuarios.csv"));
        Map<String, List<String>> usuarios = archivoUsuarios.leerArchivo();

        if (usuarios.containsKey(nombreUsuario)) {
            System.out.println("El nombre de usuario ya existe. Intente con otro.");
            return;
        }

        usuarios.put(nombreUsuario, List.of(contrasena));
        archivoUsuarios.escribirArchivo(usuarios);

        System.out.println("Registro exitoso. Ahora puede iniciar sesión.");
        iniciarSesion();
    }

    public static void registrarDoctor() {
        System.out.println("\nRegistro de Doctor");
        System.out.println("=".repeat(30));

        System.out.println("Ingrese el nombre del doctor:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la especialidad del doctor:");
        String especialidad = scanner.nextLine();

        Doctor doctor = new Doctor(nombre, especialidad);
        ArchivoDatos archivoDoctores = new ArchivoDatos(Path.of("data", "doctores.csv"));
        Map<String, List<String>> doctores = archivoDoctores.leerArchivo();

        doctores.put(doctor.getId(), List.of(doctor.getNombre(), doctor.getEspecialidad()));
        archivoDoctores.escribirArchivo(doctores);

        System.out.println("Doctor registrado exitosamente: " + doctor.getNombre() + " - Especialidad: " + doctor.getEspecialidad());
    }

    public static void registrarPaciente() {
        System.out.println("\nRegistro de Paciente");
        System.out.println("=".repeat(30));

        System.out.println("Ingrese el nombre del paciente:");
        String nombre = scanner.nextLine();

        Paciente paciente = new Paciente(nombre);
        ArchivoDatos archivoPacientes = new ArchivoDatos(Path.of("data", "pacientes.csv"));
        Map<String, List<String>> pacientes = archivoPacientes.leerArchivo();

        pacientes.put(paciente.getId(), List.of(paciente.getNombre()));
        archivoPacientes.escribirArchivo(pacientes);

        System.out.println("Paciente registrado exitosamente: " + paciente.getNombre());
    }

    public static void crearCita() {
        System.out.println("\nCreación de Cita");
        System.out.println("=".repeat(30));

        ArchivoDatos archivoDoctores = new ArchivoDatos(Path.of("data", "doctores.csv"));
        Map<String, List<String>> doctores = archivoDoctores.leerArchivo();

        ArchivoDatos archivoPacientes = new ArchivoDatos(Path.of("data", "pacientes.csv"));
        Map<String, List<String>> pacientes = archivoPacientes.leerArchivo();

        if (doctores.isEmpty()) {
            System.out.println("No hay doctores registrados. Por favor registre un doctor primero.");
            return;
        }

        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados. Por favor registre un paciente primero.");
            return;
        }

        System.out.println("Seleccione el id de un doctor:");
        doctores.forEach((id, info) -> System.out.println(id + ": " + info.get(0) + " - Especialidad: " + info.get(1)));

        String idDoctor = scanner.nextLine();
        if (!doctores.containsKey(idDoctor)) {
            System.out.println("ID de doctor inválido. Intente nuevamente.");
            return;
        }

        System.out.println("Seleccione el id de un paciente:");
        pacientes.forEach((id, info) -> System.out.println(id + ": " + info.get(0)));

        String idPaciente = scanner.nextLine();
        if (!pacientes.containsKey(idPaciente)) {
            System.out.println("ID de paciente inválido. Intente nuevamente.");
            return;
        }

        System.out.println("Ingrese la fecha (ejemplo: 2026-09-29)");
        String fecha = scanner.nextLine();

        System.out.println("Ingrese la hora de la cita (ejemplo: 15:00):");
        String hora = scanner.nextLine();

        Cita cita = new Cita(fecha, hora, idDoctor, idPaciente);
        ArchivoDatos archivoCitas = new ArchivoDatos(Path.of("data", "citas.csv"));
        Map<String, List<String>> citas = archivoCitas.leerArchivo();

        citas.put(cita.getId(), List.of(cita.getFecha(), cita.getHora(), cita.getIdDoctor(), cita.getIdPaciente()));
        archivoCitas.escribirArchivo(citas);

        System.out.println("Cita creada exitosamente: Doctor ID: " + cita.getIdDoctor() + ", Paciente ID: " + cita.getIdPaciente() + ", Fecha y Hora: " + cita.getFecha() + " " + cita.getHora());

    }

    public static void verCitas() {
        System.out.println("\nListado de Citas");
        System.out.println("=".repeat(30));

        ArchivoDatos archivoCitas = new ArchivoDatos(Path.of("data", "citas.csv"));
        Map<String, List<String>> citas = archivoCitas.leerArchivo();

        if (citas.isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }

        citas.forEach((id, info) -> {
            System.out.println("ID: " + id + ", Fecha: " + info.get(0) + ", Hora: " + info.get(1) + ", Paciente ID: " + info.get(2) + ", Doctor ID: " + info.get(3));
        });
    }
}
