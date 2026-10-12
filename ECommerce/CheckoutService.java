package ECommerce;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ECommerce.InventoryService;
import ECommerce.model.Customer;
import ECommerce.model.PaymentStatus;
import ECommerce.PaymentStrategy;

public class CheckoutService {
    
    private final InventoryService inventoryService;
    private final OrderService orderService;

    public CheckoutService(
        InventoryService inventoryService,
        OrderService orderService
    ){
        this.inventoryService = inventoryService;
        this.orderService = orderService;
    }


    public Order checkout(Customer customer,PaymentStrategy paymentStrategy){

        Cart cart = customer.getCart();
        List<CartItem> items = cart.getItems();

        if(items.isEmpty()){
            throw new IllegalStateException();
        }
        
        BigDecimal total = cart.getTotal();

        List<CartItem> reservedItems = new ArrayList<>();

        try {
            for(CartItem item: items){
                String productId = item.getProduct().getId();

                int quantity = item.getQuantity();

                inventoryService.reserve(productId, quantity);

                reservedItems.add(item);

            }

            PaymentStatus paymentStatus = paymentStrategy.pay(customer.getId(), total);

            if(paymentStatus != PaymentStatus.SUCCESS){
                throw new IllegalStateException("Payment Failed");
            }

            Order order = orderService.createOrder(customer.getId(), reservedItems, total);

            cart.clear();

            return order;
        } catch (Exception e){

            for(CartItem item: reservedItems){

                inventoryService.release(
                    item.getProduct().getId(), item.getQuantity()
                );
            }

            throw e;

        }

    }
}
