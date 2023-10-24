package bookstoreproject.sales;

import bookstoreproject.inventory.*;
public class Sales {

    private InventoryMgnt inventory;

    public Sales(InventoryMgnt inventory) {
        this.inventory = inventory;
    }

    public boolean makeSale(InventoryItem item, int quantity) throws NegativeQuantityException {
        double price = item.getPricingInfo().getPrice();
        boolean isAvailable = inventory.isAvailable(item, quantity);

        if (isAvailable) {
            try{
            inventory.decrementQuantity(item, quantity);
            }catch(NegativeQuantityException e){
                System.out.println(e.getMessage());
            }
            // Update Sales Counter (assuming it's a static class)
            SalesCounter.updateTotalSales(price * quantity);
            SalesCounter.updateTotalUnits(quantity);
            return true;
        }

        return false;
    }
}
