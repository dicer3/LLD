package ECommerce;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import ECommerce.model.OrderStatus;

public class Order {
    
    private final String id;
    private final String customerId;
    private final List<OrderItem> items;
    private final BigDecimal totalAmount;
    private OrderStatus status;

    public Order(
        String customerId,
        List<CartItem> cartItems,
        BigDecimal totalAmount
    ){
        this.id = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.items = cartItems.stream()
                   .map(OrderItem::new)
                   .toList();
        this.totalAmount = totalAmount;
        this.status = OrderStatus.CONFIRMED;           
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void updateStatus(OrderStatus status) {
        this.status = status;
    }

    
}
