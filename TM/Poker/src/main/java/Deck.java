import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
        String[] colores = {"Rojo", "Negro"};
        String[] valores = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String palo : palos) {
            String color = (palo.equals("Corazones") || palo.equals("Diamantes")) ? colores[0] : colores[1];
            for (String valor : valores) {
                cards.add(new Card(palo, color, valor));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() {
        if (!cards.isEmpty()) {
            Card card = cards.remove(0);
            System.out.println("Carta obtenida: " + card.getPalo() + " de " + card.getValor() + " (" + card.getColor() + ")");
            System.out.println("Quedan " + cards.size() + " cartas en el Deck.");
        } else {
            System.out.println("No hay cartas en el Deck.");
        }
    }

    public void pick() {
        if (!cards.isEmpty()) {
            int index = (int) (Math.random() * cards.size());
            System.out.println("Carta obtenida: " + cards.get(index).getPalo() + " de " + cards.get(index).getValor() + " (" + cards.get(index).getColor() + ")");
            cards.remove(index);
            System.out.println("Quedan " + cards.size() + " cartas en el Deck.");
        } else {
            System.out.println("No hay cartas en el Deck.");
        }
    }

    public void hand() {
        if (!cards.isEmpty() && cards.size() >= 5) {
            for (int i = 0; i < 5; i++) {
                Card card = cards.remove(0);
                System.out.println("Carta obtenida: " + card.getPalo() + " de " + card.getValor() + " (" + card.getColor() + ")");
            }
            System.out.println("Quedan " + cards.size() + " cartas en el Deck.");
        } else {
            System.out.println("No hay suficientes cartas en el Deck para repartir una mano de 5 cartas.");
        }
    }


}
