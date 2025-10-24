package polymorphism_examples;

public class NextMain {

    public static void main(String[] args) {
        Movie theMovie = Movie.getMovie("A", "Star Wars");
        theMovie.watchMovie();

        Adventure adventureMovie = (Adventure) Movie.getMovie("A", "Indiana Jones");
        adventureMovie.watchMovie();

        Object comedy = Movie.getMovie("C", "Airplane");
        ((Comedy) comedy).watchComedy();

        var airplane = (Comedy) Movie.getMovie("C", "Airplane");
        airplane.watchComedy();

        Object unknown = Movie.getMovie("C", "Airplane");
        if(unknown.getClass().getSimpleName() == "Comedy") {
            Comedy c = (Comedy) unknown;
            c.watchComedy();
        } else if (unknown instanceof  Adventure) {
            ((Adventure) unknown).watchAdventure();
        } else if (unknown instanceof ScienceFiction syfy) {
            syfy.watchScienceFiction();
        }
    }
}
