package Abstract.challenge;

import java.util.ArrayList;

record OrderItem(int qty, ProductForSale product) {}

public class Store {

    private  static ArrayList<ProductForSale> storeProducts = new ArrayList<>();

    public static void main(String[] args) {
        storeProducts.add(new ArtObject("Oil Painting", 1350, "A beautiful landscape painting"));
        storeProducts.add(new ArtObject("Sculpture", 2000, "Bronze sculpture of a horse"));
        storeProducts.add(new Forniture("Dining Room Table", 850, "Solid wood table with 6 chairs"));
        storeProducts.add(new Forniture("Queen Bed Frame", 600, "Wooden bed frame with headboard"));

        listProducts();

        System.out.println("\nCustomer Order:");
        var order1 = new ArrayList<OrderItem>();
        addItemToOrder(order1, 1, 2);
        addItemToOrder(order1, 0, 1);
        printOrder(order1);

        System.out.println("\nCustomer Order:");
        var order2 = new ArrayList<OrderItem>();
        addItemToOrder(order2, 3, 5);
        addItemToOrder(order2, 0, 1);
        addItemToOrder(order2, 2, 1);
        printOrder(order2);
    }

    public static void listProducts() {
        for (ProductForSale product : storeProducts) {
            System.out.println("-".repeat(30));
            product.showDetails();
        }
    }

    public static void addItemToOrder(ArrayList<OrderItem> order, int orderIndex, int qty) {
        order.add(new OrderItem(qty, storeProducts.get(orderIndex)));
    }

    public static void printOrder(ArrayList<OrderItem> order) {
        double salesTotal = 0;

        for (var item : order) {
            item.product().printPriceditem(item.qty());
            salesTotal += item.product().getSalesPrice(item.qty());
        }

        System.out.printf("Sales Total: $%6.2f %n", salesTotal);
    }
}
