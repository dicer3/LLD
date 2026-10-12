package ECommerce;

import java.math.BigDecimal;

import ECommerce.model.Product;
import ECommerce.model.Customer;

public class Main {
    public static void main(String[] args) {
        
        ProductCatalog catalog = new ProductCatalog();

        Product iphone = new Product(
            "P101","iPhone",new BigDecimal("80000")
        );

        Product airpods = new Product("P102", "Airpods", new BigDecimal("20000"));

        catalog.addProduct(iphone);
        catalog.addProduct(airpods);

        InventoryService inventoryService = new InventoryService();

        inventoryService.addStock("P101", 5);
        inventoryService.addStock("P102", 10);

        Customer customer = new Customer("C101","Rahul");

        customer.getCart().addProduct(iphone, 1);
        customer.getCart().addProduct(airpods, 2);

        OrderService orderService = new OrderService();

        CheckoutService checkoutService = new CheckoutService(inventoryService, orderService);

        PaymentStrategy paymentStrategy = new UpiPayment();

        Order order = checkoutService.checkout(customer, paymentStrategy);

        // Print Order Details
        System.out.println("Order Id = "+order.getId());
        System.out.println("Customer :"+order.getCustomerId());
        System.out.println("Order Status = "+order.getStatus());
        System.out.println("Order Total "+order.getTotalAmount());

        System.out.println("Order Items :");

        for(OrderItem item: order.getItems()){
            System.out.println(
                item.getProductName()
                + " x "+ item.getQuantity()
                + " = "
            );
        }

        System.out.println("Remaining Iphone stock "+inventoryService.getAvaibableStock("P101"));

        System.out.println("Cart Empty "+customer.getCart().isEmpty());

    }
}
