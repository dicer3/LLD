package ECommerce.model;

import ECommerce.Cart;
public class Customer {
    
    private final String id;
    private final String name;
    private final Cart cart = new Cart();


    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public Cart getCart(){
        return cart;
    }
    
}
