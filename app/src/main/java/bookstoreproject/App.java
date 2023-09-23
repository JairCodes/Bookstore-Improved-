/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bookstoreproject;

import bookstoreproject.inventory.InventoryArray;
import bookstoreproject.pricing.*;
import bookstoreproject.sales.*;

public class App {
    public String makeAnnouncement() {
        return "Starting Project";
    }

    public static void main(String[] args) {
        System.out.println(new App().makeAnnouncement());
        // Initialize the Inventory, Pricing, and Sales classes
        InventoryArray inventory = new InventoryArray();
        BookPricing bookPricing = new BookPricing(10);
        StationaryPricing stationaryPricing = new StationaryPricing(2);
        PencilPricing pencilPricing = new PencilPricing(1);
        PenPricing penPricing = new PenPricing(1.5);
        Sales sales = new Sales(inventory);

          // Header
          System.out.printf("%-15s %-15s %-15s%n", "Product", "Availability", "Price");

          // Display initial inventory and pricing for demonstration
          System.out.printf("%-15s %-15s %-15.2f%n", "Books", inventory.isAvailable("Book", 1), bookPricing.getPrice());
          System.out.printf("%-15s %-15s %-15.2f%n", "Stationary", inventory.isAvailable("Stationary", 1), stationaryPricing.getPrice());
          System.out.printf("%-15s %-15s %-15.2f%n", "Pencils", inventory.isAvailable("Pencil", 1), pencilPricing.getPrice());
          System.out.printf("%-15s %-15s %-15.2f%n", "Pens", inventory.isAvailable("Pen", 1), penPricing.getPrice());
  
          // Perform some sales transactions and show results
          System.out.println("\nSales Transactions:");
          boolean bookSale = sales.makeSale(bookPricing,"Book", 2);
          System.out.printf("Sold 2 Books: %-5s%n", bookSale);
  
          boolean pencilSale = sales.makeSale(pencilPricing,"Pencil", 5);
          System.out.printf("Sold 5 Pencils: %-5s%n", pencilSale);
  
          boolean stationarySale = sales.makeSale(stationaryPricing,"Stationary", 3);
          System.out.printf("Sold 3 Stationary items: %-5s%n", stationarySale);
  
          // Display class name using Reflection for demonstration
          System.out.printf("\nClass of Sales object: %s%n", sales.getClass().getSimpleName());
  
          // If there's a static SalesCounter class to track total sales
          // System.out.printf("Total Sales: %d%n", SalesCounter.totalSales);
  
          // Exit the program
          System.out.println("\nExiting the program.");
    }
}
