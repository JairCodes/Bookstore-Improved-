/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bookstoreproject;

import bookstoreproject.inventory.InventoryArray;
import bookstoreproject.pricing.*;
import bookstoreproject.product.*;
import bookstoreproject.sales.*;

public class App {
    public String makeAnnouncement() {
        return "Starting Project";
    }

    public static void main(String[] args) {
        System.out.println(new App().makeAnnouncement());
        // Initialize the Inventory, Pricing, and Sales classes
        InventoryArray inventory = new InventoryArray();
        Pricing pricing = new Pricing();
        Sales sales = new Sales(inventory, pricing);

          // Header
          System.out.printf("%-15s %-15s %-15s%n", "Product", "Availability", "Price");

          // Display initial inventory and pricing for demonstration
          System.out.printf("%-15s %-15s %-15.2f%n", "Books", inventory.isAvailable("Book", 1), pricing.getPrice("Book"));
          System.out.printf("%-15s %-15s %-15.2f%n", "Stationary", inventory.isAvailable("Stationary", 1), pricing.getPrice("Stationary"));
          System.out.printf("%-15s %-15s %-15.2f%n", "Pencils", inventory.isAvailable("Pencil", 1), pricing.getPrice("Pencil"));
          System.out.printf("%-15s %-15s %-15.2f%n", "Pens", inventory.isAvailable("Pen", 1), pricing.getPrice("Pen"));
  
          // Perform some sales transactions and show results
          System.out.println("\nSales Transactions:");
          boolean bookSale = sales.makeSale("Book", 2);
          System.out.printf("Sold 2 Books: %-5s%n", bookSale);
  
          boolean pencilSale = sales.makeSale("Pencil", 5);
          System.out.printf("Sold 5 Pencils: %-5s%n", pencilSale);
  
          boolean stationarySale = sales.makeSale("Stationary", 3);
          System.out.printf("Sold 3 Stationary items: %-5s%n", stationarySale);
  
          // Display class name using Reflection for demonstration
          System.out.printf("\nClass of Sales object: %s%n", sales.getClass().getSimpleName());
  
          // If there's a static SalesCounter class to track total sales
          // System.out.printf("Total Sales: %d%n", SalesCounter.totalSales);
  
          // Exit the program
          System.out.println("\nExiting the program.");
    }
}