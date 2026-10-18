package VendingMachine;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    

    private final Map<String, Slot> slots = new HashMap<>();

    public void addProduct(Product product, int quantity){

        if (slots.containsKey(product.getId())){
            throw new IllegalArgumentException(
                "Product Id already Exists"
            );
        }

        slots.put(
            product.getId(), 
            new Slot(product, quantity)
        );    
    }

    public Product getAvailableProduct(String productId){
        Slot slot = slots.get(productId);

        if(slot == null){
            throw new IllegalArgumentException(
                "product not found"
            );
        }

        if(slot.getProduct() == null){
            throw new IllegalArgumentException(
                "Product is out of stock"
            );
        }

        return slot.getProduct();

    }

    public void dispense(String productId) throws IllegalStateException{

        Slot slot = slots.get(productId);

        if(slot == null || slot.getQuantity() <= 0){
            throw new IllegalStateException(
                "Product is unavailable"
            );
        }

        slot.dispenseOne();
    }

    public void restock(String productId, int quantity) throws IllegalAccessException{

        Slot slot = slots.get(productId);

        if(slot == null){
            throw new IllegalArgumentException(
                "Product not found"
            );
        }

        slot.restock(quantity);

    }


    public void displayProducts(){
        System.out.println("\nAvaible products:");

        for(Slot slot: slots.values()){

            Product product = slot.getProduct();

            System.out.println(
                product.getId() + " - " +
                product.getName() + " - Rs" + 
                product.getPrice() + " - Stock -" +
                slot.getQuantity()
            );
        }
    }
}
