package encapsulation_examples;

public class Main {

    public static void main(String[] args) {
//        Player player = new Player();
//        player.name = "Tim";
//        player.health = 100;
//        player.weapon = 50;
//
//        System.out.println("Initial health: " + player.healthRemaining());
//        player.loseHealth(30);
//        System.out.println("Health after damage: " + player.healthRemaining());
//        player.restoreHealth(20);
//        System.out.println("Health after restoration: " + player.healthRemaining());
//        player.restoreHealth(50); // This should cap the health at 100
//        System.out.println("Health after over-restoration: " + player.healthRemaining());

        EnhancedPlayer enhancedPlayer = new EnhancedPlayer("Tim", 200, "Sword");
        System.out.println("Initial health: " + enhancedPlayer.healthRemaining());
        enhancedPlayer.loseHealth(30);
        System.out.println("Health after damage: " + enhancedPlayer.healthRemaining());
        enhancedPlayer.restoreHealth(20);
        System.out.println("Health after restoration: " + enhancedPlayer.healthRemaining());
        enhancedPlayer.restoreHealth(50); // This should cap the health at 100
        System.out.println("Health after over-restoration: " + enhancedPlayer.healthRemaining());
    }
}
