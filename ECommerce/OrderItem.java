package ECommerce;

import java.math.BigDecimal;
import ECommerce.model.Product;

public class OrderItem {
    

    private final String productId;
    private final String productName;
    private final BigDecimal unitPrice;
    private final int quantity;

    public OrderItem(CartItem cartItem) {
        Product product = cartItem.getProduct();

        this.productId = product.getId();
        this.productName = product.getName();
        this.unitPrice = product.getPrice();
        this.quantity = cartItem.getQuantity();
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getSubtotal(){
        return unitPrice.multiply(
          BigDecimal.valueOf(quantity)  
        );
    }
    
}
