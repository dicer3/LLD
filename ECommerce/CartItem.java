package ECommerce;

import java.math.BigDecimal;

import ECommerce.model.Product;

public class CartItem {
    
    private final Product product;
    private int quantity;

    public CartItem(Product product, int quanitity){
        if(quanitity <= 0){
            throw new IllegalArgumentException("Quantity must be postive");
        }

        this.product = product;
        this.quantity = quanitity;
    }

    public Product getProduct() {
        return product;
    }

    public synchronized int getQuantity() {
        return quantity;
    }

    public synchronized void setQuantity(int quanitity){
        if (quanitity <= 0){
            throw new IllegalArgumentException("Quantity must be postive");
        }

        this.quantity = quanitity;
    }

    public synchronized BigDecimal getSubtotal(){
         return product.getPrice()
               .multiply(BigDecimal.valueOf(quantity));
    }
}
