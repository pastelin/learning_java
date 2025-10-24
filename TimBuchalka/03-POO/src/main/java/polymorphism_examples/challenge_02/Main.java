package polymorphism_examples.challenge_02;

public class Main {

    public static void main(String[] args) {
//        Item coke = new Item("drink", "coke", 1.50);
//        coke.printItem();
//        coke.setSize("LARGE");
//        coke.printItem();
//
//        Item avocado = new Item("Topping", "avocado", 1.50);
//        avocado.printItem();

//        Burguer burger = new Burguer("regular", 4.00);
//        burger.addToppings("BACON", "CHEESE", "MAYO");
//        burger.printItem();

//        MealOrder regularMeal = new MealOrder();
//        regularMeal.addBurguerToppings("BACON", "CHEESE", "MAYO");
//        regularMeal.setDrinkSize("LARGE");
//        regularMeal.printItemizedList();

//        MealOrder secondMeal = new MealOrder("Chicken", "Pepsi", "Onion Rings");
//        secondMeal.addBurguerToppings("AVOCADO", "HAM", "SALAMI");
//        secondMeal.setDrinkSize("SMALL");
//        secondMeal.printItemizedList();

        MealOrder deluxeMeal = new MealOrder("Deluxe", "Sprite", "Fries");
        deluxeMeal.addBurguerToppings("BACON", "CHEESE", "MAYO", "AVOCADO", "SALAMI");
        deluxeMeal.setDrinkSize("LARGE");
        deluxeMeal.printItemizedList();

    }

}
