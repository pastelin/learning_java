package composition_examples.challenges_01;

public class SmartKitchen {

    private CoffeeMaker brewMaster;
    private Refrigerator iceBox;
    private Dishwasher dishwasher;

    public SmartKitchen() {
        this.brewMaster = new CoffeeMaker();
        this.iceBox = new Refrigerator();
        this.dishwasher = new Dishwasher();
    }

    public CoffeeMaker getBrewMaster() {
        return brewMaster;
    }

    public Refrigerator getIceBox() {
        return iceBox;
    }

    public Dishwasher getDishwasher() {
        return dishwasher;
    }

    public void setKitchenState(boolean coffee, boolean food, boolean dishes) {
        brewMaster.setHasWorkToDo(coffee);
        iceBox.setHasWorkToDo(food);
        dishwasher.setHasWorkToDo(dishes);
    }

    public void doKitchenWork() {
        brewMaster.brewCoffee();
        iceBox.orderFood();
        dishwasher.doDishes();
    }

}

class CoffeeMaker {
    private boolean hasWorkToDo;

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void brewCoffee() {
        if (hasWorkToDo) {
            System.out.println("Brewing coffee");
            hasWorkToDo = false;
        }
    }
}


class Refrigerator {
    private boolean hasWorkToDo;

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void orderFood() {
        if (hasWorkToDo) {
            System.out.println("Ordering food");
            hasWorkToDo = false;
        }
    }
}

class Dishwasher {
    private boolean hasWorkToDo;

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public void doDishes() {
        if (hasWorkToDo) {
            System.out.println("Washing the dishes");
            hasWorkToDo = false;
        }
    }
}