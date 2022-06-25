package com.masterclasses.collection.practice;

import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.00, 200);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String s : stockList.items().keySet()) {
            System.out.println(s);
        }

        Basket juanBasket = new Basket("Juan");
        sellItem(juanBasket, "car", 1);
        System.out.println(juanBasket);

        sellItem(juanBasket, "car", 1);
        System.out.println(juanBasket);

        if(sellItem(juanBasket, "car", 1) != 1) {
            System.out.println("There are no more cars in stock");
        }

        sellItem(juanBasket, "spanner", 5);
        System.out.println(juanBasket);

        sellItem(juanBasket, "juice", 4);
        sellItem(juanBasket, "cup", 12);
        sellItem(juanBasket, "bread", 1);
        System.out.println(juanBasket);

        System.out.println(stockList);

        stockList.items().get("car").adjustStock(2000);
        stockList.get("car").adjustStock(-1000);
        System.out.println(stockList);

        for(Map.Entry<String, Double> price : stockList.priceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);

        if(stockItem == null) {
            System.out.println("We don´t sell " + item);
            return 0;
        }

        if(stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }

        return 0;
    }


}
