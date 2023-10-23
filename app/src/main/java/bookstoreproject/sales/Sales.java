package bookstoreproject.sales;

import bookstoreproject.inventory.*;
public class Sales {

    private InventoryMgnt inventory;

    public Sales(InventoryMgnt inventory) {
        this.inventory = inventory;
    }

    public boolean makeSale(InventoryItem item, int quantity) {
        double price = item.getPricingInfo().getPrice();
        boolean isAvailable = inventory.isAvailable(item, quantity);

        try {
            if (isAvailable) {
                inventory.decrementQuantity(item, quantity);
            
                // Update Sales Counter (assuming it's a static class)
                SalesCounter.updateTotalSales(price * quantity);
                SalesCounter.updateTotalUnits(quantity);
                return true;
            }
        } catch(NegativeQuantityException e) {
            System.out.println("Error: " +e.getMessage());
        }

        return false;
    }
}
