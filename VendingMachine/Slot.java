package VendingMachine;

public class Slot {
    
    private final Product product;
    private int quantity;

    public Slot(Product product, int quantity){

        if(quantity < 0){
            throw new IllegalArgumentException("Quantity must be negative");
        }

        this.quantity = quantity;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void dispenseOne() {

        if (quantity <= 0){
            throw new IllegalStateException(
                "Product is out of stock"
            );
        }

        quantity--;
    }

    public void restock(int quantity) throws IllegalAccessException{
        
        
        if (quantity <= 0){
            throw new IllegalAccessException(
                "Product is out of stock"
            );
        }

        this.quantity += quantity;
    }
}
