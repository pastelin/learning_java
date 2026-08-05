package generics.first_generic_class;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un equipo de béisbol específico.
 *
 * Esta es la PRIMERA evolución sin usar genéricos.
 * Solo puede contener jugadores de tipo BaseballPlayer.
 *
 * Características:
 * - Mantiene una lista de jugadores de béisbol
 * - Realiza seguimiento de victorias, derrotas y empates
 * - Calcula un ranking basado en el desempeño
 * - Proporciona métodos para agregar jugadores y listar el equipo
 *
 * Limitación: No es reutilizable para otros tipos de deportes sin duplicar el código.
 */
public class BaseballTeam {

    /** Nombre del equipo */
    private String teamName;

    /** Lista de jugadores de béisbol en el equipo */
    private List<BaseballPlayer> teamMembers = new ArrayList<>();

    /** Total de victorias del equipo */
    private int totalWins = 0;

    /** Total de derrotas del equipo */
    private int totalLosses = 0;

    /** Total de empates del equipo */
    private int totalTies = 0;

    /**
     * Constructor que crea un equipo de béisbol con el nombre especificado.
     *
     * @param teamName nombre del equipo
     */
    public BaseballTeam(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Agrega un jugador de béisbol al equipo si no existe ya.
     * Evita duplicados verificando si el jugador ya está en la lista.
     *
     * @param player jugador de béisbol a agregar
     */
    public void addTeamMember(BaseballPlayer player) {
        if(!teamMembers.contains(player)) {
            teamMembers.add(player);
        }
    }

    /**
     * Muestra el nombre del equipo y lista todos los miembros.
     * Imprime el nombre de cada jugador en el equipo.
     */
    public void listTeamMembers() {
        System.out.println(teamName + " Roster:");
        System.out.println(teamMembers);
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
