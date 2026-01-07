package arraylist.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GroceryList {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> groceryList = new ArrayList<>();
        int choice;

        while (true) {
            String menu = """
                    Available Actions:
                    0 - Exit
                    1 - Add item or items to list, separated by commas
                    2 - Remove item or items from list, separated by commas
                    
                    Enter a number for which action you want to do:
                    """;
            System.out.print(menu);
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                case 1 -> {
                    System.out.println("Enter item or items to add, separated by commas:");
                    String itemsToAdd = sc.next();
                    addItems(itemsToAdd, groceryList);
                    Collections.sort(groceryList);
                    System.out.println("Grocery List: " + groceryList);
                }
                case 2 -> {
                    System.out.println("Enter item or items to remove, separated by commas:");
                    String itemsToRemove = sc.next();
                    removeItems(itemsToRemove, groceryList);
                    Collections.sort(groceryList);
                    System.out.println("Grocery List: " + groceryList);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addItems(String items, List<String> groceryList) {
        String[] itemsArray = items.split(",");
        for (String item : itemsArray) {
            if (groceryList.contains(item)) {
                System.out.println(item.trim() + " is already in the grocery list. Skipping addition.");
            } else {
                groceryList.add(item.trim());
            }
        }
        System.out.println("Items added to the grocery list.");
    }

    private static void removeItems(String items, List<String> groceryList) {
        String[] itemsArray = items.split(",");
        for (String item : itemsArray) {
            if (groceryList.contains(item.trim())) {
                groceryList.remove(item.trim());
                System.out.println(item.trim() + " removed from the grocery list.");
            } else {
                System.out.println(item.trim() + " is not in the grocery list. Cannot remove.");
            }
        }
    }
}
