package generics.first_generic_class;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase genérica que representa un equipo deportivo con un parámetro de tipo.
 *
 * Esta es la SEGUNDA evolución, introduciendo genéricos básicos.
 * Puede contener jugadores de cualquier tipo que implemente la interfaz Player.
 *
 * Características:
 * - Parámetro genérico único que acepta cualquier tipo de jugador (Player)
 * - Mantiene una lista de miembros del equipo
 * - Realiza seguimiento de victorias, derrotas y empates
 * - Calcula un ranking basado en el desempeño
 * - Puede ser reutilizada para béisbol, fútbol, voleibol, etc.
 *
 * Ventaja respecto a BaseballTeam: Reutilizable para múltiples deportes sin duplicar código.
 *
 * Limitación: No puede diferenciar por tipo específico de afiliación.
 */
public class SportsTeam {

    /** Nombre del equipo */
    private String teamName;

    /** Lista de miembros del equipo que implementan la interfaz Player */
    private List<Player> teamMembers = new ArrayList<>();

    /** Total de victorias del equipo */
    private int totalWins = 0;

    /** Total de derrotas del equipo */
    private int totalLosses = 0;

    /** Total de empates del equipo */
    private int totalTies = 0;

    /**
     * Constructor que crea un equipo deportivo con el nombre especificado.
     *
     * @param teamName nombre del equipo
     */
    public SportsTeam(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Agrega un jugador al equipo si no existe ya.
     * Acepta cualquier jugador que implemente la interfaz Player.
     * Evita duplicados verificando si el jugador ya está en la lista.
     *
     * @param player jugador a agregar al equipo
     */
    public void addTeamMember(Player player) {
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
