package generics.first_generic_class;

import java.util.ArrayList;
import java.util.List;

/**
 * Record que representa la afiliación de un equipo deportivo.
 * Contiene información sobre el nombre, tipo y país de la afiliación.
 *
 * @param name nombre de la afiliación (ej: "Philadelphia")
 * @param type tipo de afiliación (ej: "city")
 * @param countryCode código del país (ej: "US")
 */
record Affiliation(String name, String type, String countryCode) {
    /**
     * Representación en texto de la afiliación.
     * @return string formateado con nombre, tipo y país
     */
    @Override
    public String toString() {
        return name + " (" + type + " in " + countryCode + ")";
    }
}

/**
 * Clase genérica que representa un equipo deportivo.
 *
 * Esta clase demuestra el uso avanzado de genéricos con dos parámetros de tipo:
 * - T: Tipo de jugador (debe implementar la interfaz Player) - Bounded Type Parameter
 * - S: Tipo de afiliación (sin restricciones) - Unbounded Type Parameter
 *
 * Características principales:
 * - Mantiene una lista de miembros del equipo de tipo T
 * - Realiza seguimiento de victorias, derrotas y empates
 * - Calcula un ranking basado en el desempeño
 * - Puede tener una afiliación opcional de tipo S (puede ser Affiliation o String)
 *
 * @param <T> tipo de jugador (debe implementar Player)
 * @param <S> tipo de afiliación (sin restricciones)
 */
public class Team<T extends Player, S> {

    /** Nombre del equipo */
    private String teamName;

    /** Lista de miembros del equipo */
    private List<T> teamMembers = new ArrayList<>();

    /** Total de victorias del equipo */
    private int totalWins = 0;

    /** Total de derrotas del equipo */
    private int totalLosses = 0;

    /** Total de empates del equipo */
    private int totalTies = 0;

    /** Afiliación del equipo (puede ser null) */
    private S affiliation;

    /**
     * Constructor que crea un equipo con solo el nombre.
     * La afiliación será null.
     *
     * @param teamName nombre del equipo
     */
    public Team(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Constructor que crea un equipo con nombre y afiliación.
     *
     * @param teamName nombre del equipo
     * @param affiliation afiliación del equipo (puede ser Affiliation o String)
     */
    public Team(String teamName, S affiliation) {
        this.teamName = teamName;
        this.affiliation = affiliation;
    }

    /**
     * Agrega un miembro al equipo si no existe ya.
     * Evita duplicados verificando si el jugador ya está en la lista.
     *
     * @param playerToAdd jugador a agregar al equipo
     */
    public void addTeamMember(T playerToAdd) {
        if(!teamMembers.contains(playerToAdd)) {
            teamMembers.add(playerToAdd);
        }
    }

    /**
     * Muestra el nombre del equipo, su afiliación y lista todos los miembros.
     * Imprime el nombre de cada jugador en el equipo.
     */
    public void listTeamMembers() {
        System.out.println(teamName + " Roster:");
        System.out.println(affiliation == null ? "" : " AFFILIATION: " + affiliation);
        for(T member : teamMembers) {
            System.out.println(member.name());
        }
    }

    /**
     * Calcula el ranking del equipo basado en su desempeño.
     * Fórmula: (totalLosses * 2) + totalTies + 1
     * 
     * Nota: Un ranking más alto significa peor desempeño.
     *
     * @return ranking del equipo
     */
    public int ranking() {
        return (totalLosses * 2) + totalTies + 1;
    }

    /**
     * Registra el resultado de un partido y actualiza las estadísticas del equipo.
     *
     * @param ourScore puntuación de nuestro equipo
     * @param theirScore puntuación del equipo contrario
     * @return mensaje descriptivo del resultado ("beat", "tied" o "lost to")
     */
    public String setScore(int ourScore, int theirScore) {
        String message = "lost to";
        if(ourScore > theirScore) {
            totalWins++;
            message = "beat";
        } else if(ourScore == theirScore) {
            totalTies++;
            message = "tied";
        } else {
            totalLosses++;
        }

        return message;
    }

    /**
     * Representación en texto del equipo.
     * Incluye el nombre del equipo y su ranking.
     *
     * @return string con el nombre y ranking del equipo
     */
    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}
