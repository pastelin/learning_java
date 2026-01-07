package enum_;

public enum Topping {

    MUSTARD,
    KETCHUP,
    PICKLES,
    LETTUCE,
    TOMATOES,
    ONIONS,
    CHEESE,
    BACON;

    public double getPrice() {
        return switch (this) {
            case MUSTARD, KETCHUP, PICKLES, LETTUCE, TOMATOES, ONIONS -> 0.25;
            case CHEESE -> 0.50;
            case BACON -> 1.00;
        };
    }
}
