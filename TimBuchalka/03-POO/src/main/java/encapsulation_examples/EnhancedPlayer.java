package encapsulation_examples;

public class EnhancedPlayer {
    private String fullName;
    private int healthPercentage = 100; // Default health
    private String weapon;

    public EnhancedPlayer(String name) {
        this(name, 100, "Sword");
    }

    public EnhancedPlayer(String fullName, int health, String weapon) {
        this.fullName = fullName;
        if (health < 0) {
            this.healthPercentage = 1;
        } else if (health > 100) {
            this.healthPercentage = 100;
        } else {
            this.healthPercentage = 100;
        }

        this.weapon = weapon;
    }

    public void loseHealth(int damage) {
        this.healthPercentage -= damage;
        if (this.healthPercentage <= 0) {
            System.out.println("Player knocked out");
            // Reduce number of lives remaining for the player
        }
    }

    public int healthRemaining() {
        return this.healthPercentage;
    }

    public void restoreHealth(int extraHealth) {
        this.healthPercentage += extraHealth;

        if (healthPercentage > 100) {
            System.out.println("Player health restored to maximum");
            this.healthPercentage = 100;

        }
    }


}
