package polymorphism_examples.challenge_02;

public class Burguer extends Item {

    private Item extra1;
    private Item extra2;
    private Item extra3;
    private Item extra4;

    public Burguer(String name, double price) {
        super("Burguer", name, price);
    }

    @Override
    public String getName() {
        return super.getName() + "BURGER";
    }

    @Override
    public double getAdjustedPrice() {
        return getBasePrice() +
                (extra1 != null ? extra1.getAdjustedPrice() : 0) +
                (extra2 != null ? extra2.getAdjustedPrice() : 0) +
                (extra3 != null ? extra3.getAdjustedPrice() : 0);
    }

    public double getExtraPrice(String toppingName) {
        return switch (toppingName.toUpperCase()) {
            case "AVOCADO", "CHEESE" -> 1.0;
            case "BACON", "HAM", "SALAMI" -> 1.5;
            default -> 0.0;
        };
    }

    public void addToppings(String extra1, String extra2, String extra3) {
        this.extra1 = new Item("TOPPING", extra1, getExtraPrice(extra1));
        this.extra2 = new Item("TOPPING", extra2, getExtraPrice(extra2));
        this.extra3 = new Item("TOPPING", extra3, getExtraPrice(extra3));
    }

    public void printItemizedList() {
        printItem("BASE BURGER", getBasePrice());
        if (extra1 != null) {
            extra1.printItem();
        }
        if (extra2 != null) {
            extra2.printItem();
        }
        if (extra3 != null) {
            extra3.printItem();
        }
    }

    @Override
    public void printItem() {
        printItemizedList();
        System.out.println("-".repeat(30));
        super.printItem();
    }
}
