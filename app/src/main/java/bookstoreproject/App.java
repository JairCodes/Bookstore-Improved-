/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bookstoreproject;

import java.util.ArrayList;
import java.util.HashMap;

import bookstoreproject.inventory.*;
import bookstoreproject.sales.*;
import bookstoreproject.io.*;
import bookstoreproject.product.ProductInfo;

public class App {
    public String makeAnnouncement() {
        return "Starting Project";
    }

    public static void main(String[] args) {
        System.out.println(new App().makeAnnouncement());
        // Initialize the Inventory and Sales classes
        InventoryMgnt inventory_mgnt = new InventoryMgnt();
        InventoryItem bookItem = InventoryItem.createInventoryItem(inventory_mgnt,"Book", 20, 14.0);
        InventoryItem penItem = InventoryItem.createInventoryItem(inventory_mgnt,"Pen", 20, 2.0);
        InventoryItem pencilItem = InventoryItem.createInventoryItem(inventory_mgnt,"Pencil", 20, 1.0);
        InventoryItem stationaryItem = InventoryItem.createInventoryItem(inventory_mgnt,"Stationary", 20, 4.0);


        ArrayList<ItemEntry> entries = ItemEntry.readEntriesFromFile("inventory_items.txt");
        for(ItemEntry entry : entries) {
            InventoryItem itemfromtxt = InventoryItem.createInventoryItem(inventory_mgnt, entry.getProduct(), entry.getQuantity(), entry.getPrice());
            inventory_mgnt.addItem(itemfromtxt.getProductInfo(), itemfromtxt);
        }
        Sales sales = new Sales(inventory_mgnt);
 
          // Header
          System.out.printf("%-15s %-15s %-15s%n", "Product", "Availability", "Price");
          HashMap<String, ProductInfo> productInfoMap = inventory_mgnt.getProductInfoMap();
       
        for(String product : productInfoMap.keySet()) {
            ProductInfo productInfo = productInfoMap.get(product);
            InventoryItem inventoryItem = inventory_mgnt.getItem(productInfo);
            System.out.printf("%-15s %-15s %-15.2f%n", product, inventory_mgnt.isAvailable(inventoryItem, inventoryItem.getQuantityInfo().getQuantity()), inventoryItem.getPricingInfo().getPrice());
        }

          // Perform some sales transactions and show results
        System.out.println("Sales Transactions: ");

        String bookItemName = "Book";
        ProductInfo bookProductInfo = inventory_mgnt.getProductInfoMap().get(bookItemName);
        InventoryItem bookInventoryItem = inventory_mgnt.getItem(bookProductInfo); 
        if (bookInventoryItem != null) {
        int bookItemQuantity = 2;
        boolean bookItemSale = sales.makeSale(bookItem, bookItemQuantity);  
        System.out.printf("Sold %d %s: %-5s%n", bookItemQuantity, bookItemName, bookItemSale);
        } else {
            System.out.printf("Item not found in inventory: %s%n", bookItemName);
        }

        String pencilItemName = "Pencil";
        ProductInfo pencilProductInfo = inventory_mgnt.getProductInfoMap().get(pencilItemName);
        InventoryItem pencilInventoryItem = inventory_mgnt.getItem(pencilProductInfo);
        if (pencilInventoryItem != null) {
        int pencilItemQuantity = 5;
        boolean pencilItemSale = sales.makeSale(pencilItem, pencilItemQuantity);
        System.out.printf("Sold %d %s: %-5s%n", pencilItemQuantity, pencilItemName, pencilItemSale);
        } else {
            System.out.printf("Item not found in inventory: %s%n", pencilItemName);
        }

        String stationaryItemName = "Stationary";
        ProductInfo stationaryProductInfo = inventory_mgnt.getProductInfoMap().get(stationaryItemName);
        InventoryItem stationaryInventoryItem = inventory_mgnt.getItem(stationaryProductInfo);
        if (stationaryInventoryItem != null) {
            int stationaryItemQuantity = 3;
            boolean stationaryItemSale = sales.makeSale(stationaryItem, stationaryItemQuantity);
            System.out.printf("Sold %d %s: %-5s%n", stationaryItemQuantity, stationaryItemName, stationaryItemSale);
        } else {
            System.out.printf("Item not found in inventory: %s%n", stationaryItemName);
        }

        String starWarsItemName = "Star Wars";
        ProductInfo StarWarsproductInfo = inventory_mgnt.getProductInfoMap().get(starWarsItemName);
        InventoryItem starWarsItem = inventory_mgnt.getItem(StarWarsproductInfo);
        if(starWarsItem != null) {
            int starWarsItemQuantity = 1;
            boolean starWarsItemSale = sales.makeSale(starWarsItem, starWarsItemQuantity);
            System.out.printf("Sold %d %s: %-5s%n", starWarsItemQuantity, starWarsItemName, starWarsItemSale);
        } else {
            System.out.printf("Item not found in inventory: %s%n", starWarsItemName);
        }

        String ItemNotExistName = "Item does not exist";
        ProductInfo NotExistproductInfo = inventory_mgnt.getProductInfoMap().get(ItemNotExistName);
        InventoryItem ItemNotExist = inventory_mgnt.getItem(NotExistproductInfo);
        if(ItemNotExist != null) {
            int ItemNotExistQuantity = 3;
            boolean ItemNotExistSale = sales.makeSale(ItemNotExist, ItemNotExistQuantity);
            System.out.printf("Sold %d %s: %-5s%n", ItemNotExistQuantity, ItemNotExistName, ItemNotExistSale);
        } else {
            System.out.printf("Item not found in inventory: %s%n", ItemNotExistName);
        }


        // Display class name using Reflection for demonstration
          System.out.printf("\nClass of Sales object: %s%n", sales.getClass().getSimpleName());
  
          // If there's a static SalesCounter class to track total sales
          System.out.printf("Total Sales: %.2f%n", SalesCounter.totalSales);
  
          // Exit the program
          System.out.println("\nExiting the program.");
    }
}
