package polymorphism_examples;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Movie theMovie = Movie.getMovie("Adventure", "Star Wars");
//        theMovie.watchMovie();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter Type (A for Adventure, C for Comedy, S for Science Fiction, or Q ro quit)");
            String type = scanner.nextLine();

            if("Qq".contains(type)) {
                System.out.println("Exiting...");
                break;
            }
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();
        }

    }
}
