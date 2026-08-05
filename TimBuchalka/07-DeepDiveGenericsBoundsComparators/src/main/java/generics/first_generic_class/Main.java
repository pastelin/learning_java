package generics.first_generic_class;

/**
 * Interfaz que define el contrato para un jugador.
 * Cualquier jugador debe implementar este contrato.
 */
interface Player {
    /**
     * Obtiene el nombre del jugador.
     * @return nombre del jugador
     */
    String name();
}

/**
 * Record que representa un jugador de béisbol.
 * @param name nombre del jugador
 * @param position posición en el equipo
 */
record BaseballPlayer(String name, String position) implements Player {
}

/**
 * Record que representa un jugador de fútbol.
 * @param name nombre del jugador
 * @param position posición en el equipo
 */
record FootballPlayer(String name, String position) implements Player {
}

/**
 * Record que representa un jugador de voleibol.
 * @param name nombre del jugador
 * @param position posición en el equipo
 */
record VolleyballPlayer(String name, String position) implements Player {}

/**
 * Clase principal que demuestra el uso de genéricos en Java.
 *
 * En este ejemplo se demuestran tres niveles de evolución de clases de equipo:
 * 1. BaseballTeam: Clase específica para béisbol (sin genéricos)
 * 2. SportsTeam: Clase genérica que acepta cualquier tipo de jugador (un parámetro genérico)
 * 3. Team: Clase completamente genérica con dos parámetros (tipo de jugador y afiliación)
 */
public class Main {

    /**
     * Método principal que ejecuta demostraciones de equipos deportivos.
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        // ========== DEMOSTRACIÓN 1: BaseballTeam (Sin Genéricos) ==========
        System.out.println("=== EJEMPLO 1: BaseballTeam (Clase específica) ===\n");

        // Crear dos equipos de béisbol específicos (solo acepta BaseballPlayer)
        BaseballTeam phillies = new BaseballTeam("Philadelphia Phillies");
        BaseballTeam astros = new BaseballTeam("Houston Astros");
        scoreResult(phillies, astros, 5, 3);

        // ========== DEMOSTRACIÓN 2: SportsTeam (Un Parámetro Genérico) ==========
        System.out.println("\n=== EJEMPLO 2: SportsTeam (Genérico con un parámetro) ===\n");

        // SportsTeam acepta cualquier tipo de jugador que implemente Player
        SportsTeam philliesSports = new SportsTeam("Philadelphia Phillies");
        SportsTeam astrosSports = new SportsTeam("Houston Astros");
        scoreResult(philliesSports, astrosSports, 5, 3);

        // ========== DEMOSTRACIÓN 3: Team (Dos Parámetros Genéricos) ==========
        System.out.println("\n=== EJEMPLO 3: Team (Genérico con dos parámetros) ===\n");

        // Crear afiliación para el equipo de béisbol
        var philadelphiaAffiliation = new Affiliation("city", "Philadelphia, PA", "US");

        // Team<T, S> donde T es el tipo de jugador y S es el tipo de afiliación
        Team<BaseballPlayer, Affiliation> philliesTeam = new Team<>("Philadelphia Phillies", philadelphiaAffiliation);
        Team<BaseballPlayer, Affiliation> astrosTeam = new Team<>("Houston Astros");

        // Agregar jugadores al equipo genérico de béisbol
        var harper = new BaseballPlayer("Bryce Harper", "Outfielder");
        var alvarez = new BaseballPlayer("Yordan Alvarez", "Designated Hitter");
        philliesTeam.addTeamMember(harper);
        philliesTeam.addTeamMember(alvarez);
        philliesTeam.listTeamMembers();

        System.out.println("\n--- Registro de puntuación ---");
        scoreResult(philliesTeam, astrosTeam, 5, 3);

        // ========== DEMOSTRACIÓN 4: Team con Fútbol (Otro tipo de jugador) ==========
        System.out.println("\n=== EJEMPLO 4: Team<FootballPlayer, Affiliation> ===\n");

        // Crear equipo de fútbol con genéricos
        SportsTeam adelaideSports = new SportsTeam("Adelaide Crows");
        Team<FootballPlayer, Affiliation> adelaideFootball = new Team<>("Adelaide Crows");

        // Agregar jugador de fútbol a equipo SportsTeam
        var walkerSports = new FootballPlayer("Taylor Walker", "Forward");
        adelaideSports.addTeamMember(walkerSports);

        // Agregar jugador de fútbol a equipo Team genérico
        var laird = new FootballPlayer("Rory Laird", "Midfielder");
        adelaideFootball.addTeamMember(laird);
        adelaideFootball.listTeamMembers();

        System.out.println();
        adelaideSports.listTeamMembers();

        // ========== DEMOSTRACIÓN 5: Team con Voleibol (Afiliación como String) ==========
        System.out.println("\n=== EJEMPLO 5: Team<VolleyballPlayer, String> ===\n");

        // Crear equipo de voleibol donde la afiliación es un String simple
        Team<VolleyballPlayer, String> adelaideVolleyball = new Team<>("Adelaide Crows", "City of Adelaide, South Australia, in AU");
        adelaideVolleyball.addTeamMember(new VolleyballPlayer("Taylor Walker", "Forward"));
        adelaideVolleyball.listTeamMembers();

        // Crear otro equipo de voleibol con afiliación como record Affiliation
        var canberraAffiliation = new Affiliation("city", "Canberra", "AU");
        var canberraVolleyball = new Team<VolleyballPlayer, Affiliation>("Canberra Raiders", canberraAffiliation);
        canberraVolleyball.addTeamMember(new VolleyballPlayer("Rory Laird", "Midfielder"));
        canberraVolleyball.listTeamMembers();

        System.out.println("\n--- Registro de puntuación ---");
        scoreResult(adelaideVolleyball, canberraVolleyball, 0, 1);

        // Nota: El siguiente código no compilaría porque Team<T> requiere que T implemente Player
        // Team<Integer> melbourneVB = new Team<>("Melbourne Vipers");
    }

    /**
     * Registra el resultado de un partido entre dos equipos de béisbol.
     * Demuestra sobrecarga de métodos con tipos específicos.
     *
     * @param team1 primer equipo de béisbol
     * @param team2 segundo equipo de béisbol
     * @param team1Score puntuación del primer equipo
     * @param team2Score puntuación del segundo equipo
     */
    public static void scoreResult(BaseballTeam team1, BaseballTeam team2, int team1Score, int team2Score) {
        String message = team1.setScore(team1Score, team2Score);
        team2.setScore(team2Score, team1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    /**
     * Registra el resultado de un partido entre dos equipos deportivos genéricos.
     * Demuestra sobrecarga de métodos con interfaces.
     *
     * @param team1 primer equipo deportivo
     * @param team2 segundo equipo deportivo
     * @param team1Score puntuación del primer equipo
     * @param team2Score puntuación del segundo equipo
     */
    public static void scoreResult(SportsTeam team1, SportsTeam team2, int team1Score, int team2Score) {
        String message = team1.setScore(team1Score, team2Score);
        team2.setScore(team2Score, team1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }

    /**
     * Registra el resultado de un partido entre dos equipos genéricos.
     * Esta versión acepta cualquier Team<T, S> donde T implemente Player.
     * Demuestra la potencia de los genéricos y los wildcard types.
     *
     * @param team1 primer equipo genérico
     * @param team2 segundo equipo genérico
     * @param team1Score puntuación del primer equipo
     * @param team2Score puntuación del segundo equipo
     */
    public static void scoreResult(Team team1, Team team2, int team1Score, int team2Score) {
        String message = team1.setScore(team1Score, team2Score);
        team2.setScore(team2Score, team1Score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}
