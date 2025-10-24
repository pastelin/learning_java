package encapsulation_examples;

public class Player {

    public String name;
    public int health;
    public int weapon;

    public void loseHealth(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            System.out.println("Player knocked out");
            // Reduce number of lives remaining for the player
        }
    }

    public int healthRemaining() {
        return this.health;
    }

    public void restoreHealth(int extraHealth) {
        this.health += extraHealth;

        if(health > 100) {
            System.out.println("Player health restored to maximum");
            this.health = 100;

        }
    }
}
