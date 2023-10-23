package bookstoreproject.inventory;

import java.util.HashMap;
import bookstoreproject.product.*;

public class InventoryMgnt {

    // HashMap to store inventory items
    private HashMap<ProductInfo, InventoryItem> inventory;
    private HashMap<String, ProductInfo> productInfoMap;

    public InventoryMgnt() {
        this.inventory = new HashMap<>();
        this.productInfoMap = new HashMap<>();
    }

    public void addProductInfoMap(ProductInfo productInfo){
        this.productInfoMap.put(productInfo.getProductInfoName(), productInfo);
    }
    public ProductInfo getproductInfoMap(String productName) {
        return this.productInfoMap.get(productName);
    }

    public HashMap<String, ProductInfo> getProductInfoMap() {
        return this.productInfoMap;
    }

    // Add an item to the inventory
    public void addItem(ProductInfo productInfo, InventoryItem item) {
        this.inventory.put(productInfo, item);
    }

    // Retrieve an item from the inventory based on its ProductInfo
    public InventoryItem getItem(ProductInfo productInfo) {
        return this.inventory.get(productInfo);
    }

    // Check if an item exists in the inventory based on its ProductInfo
    public boolean containsItem(ProductInfo productInfo) {
        return this.inventory.containsKey(productInfo);
    }

    // Remove an item from the inventory based on its ProductInfo
    public void removeItem(ProductInfo productInfo) {
        this.inventory.remove(productInfo);
    }    

    // Check if the requested quantity of an item is available
    public boolean isAvailable(InventoryItem item, int requiredQuantity) {
        return item.getQuantityInfo().getQuantity() >= requiredQuantity;
    }


    // Decrement the quantity of an item by a given amount
    public void decrementQuantity(InventoryItem item, int decrementBy) {
        // Get the current quantity, set the new quantity and check if 
        int currentQuantity = item.getQuantityInfo().getQuantity();
        int newQuantity = currentQuantity - decrementBy;
        try{
            newQuantity = Math.max(newQuantity, 0);
            if (newQuantity < 0) {
                throw new NegativeQuantityException("Quantity cannot be negative.");
            }
        }catch(NegativeQuantityException e){
           System.out.println("Error: " + e.getMessage());
        }
        //Update the quantity
        item.getQuantityInfo().setQuantity(newQuantity);
    }
}

