package ECommerce;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OrderService {
    
    private final Map<String, Order> orders = new ConcurrentHashMap<>();

    public Order createOrder(
        String customerId,
        List<CartItem> items,
        BigDecimal totalAmount
    ) {
        Order order = new Order(customerId, items, totalAmount);

        orders.put(order.getId(), order);
        return order;
    }

    public Order getOrder(String orderId) throws IllegalAccessException{

        Order order = orders.get(orderId);

        if(order == null){
            throw new IllegalAccessException("Order not found");
        }

        return order;
    }
}
