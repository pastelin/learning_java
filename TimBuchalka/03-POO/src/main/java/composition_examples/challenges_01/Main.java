package composition_examples.challenges_01;

public class Main {

    public static void main(String[] args) {


//        SmartKitchen smartKitchen = new SmartKitchen();
//        smartKitchen.getDishwasher().setHasWorkToDo(true);
//        smartKitchen.getBrewMaster().setHasWorkToDo(true);
//        smartKitchen.getIceBox().setHasWorkToDo(true);
//
//        smartKitchen.getDishwasher().doDishes();
//        smartKitchen.getBrewMaster().brewCoffee();
//        smartKitchen.getIceBox().orderFood();

        SmartKitchen smartKitchen = new SmartKitchen();
        smartKitchen.setKitchenState(true, true, true);
        smartKitchen.doKitchenWork();
    }
}
