package ECommerce;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ECommerce.model.Product;

public class Cart {
    
    private final Map<String, CartItem> items = 
        new HashMap<>();

    public synchronized void addProduct(
        Product product,
        int quantity
    ){
        if(quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be postive");
        }

        CartItem item = items.get(product.getId());

        if(items == null){
             items.put(product.getId(), new CartItem(product, quantity));
        } else {
            item.setQuantity(item.getQuantity()+quantity);
        }
    }
    
    public synchronized void removeProduct(String productId){
        items.remove(productId);
    }

    public synchronized void updateQuantity(String productId, int quanitity){
              
        if(!items.containsKey(productId)){
            throw new IllegalArgumentException("Product is not in the Cart");
        }

        if(quanitity <= 0){
            items.remove(productId);
        } else {
            items.get(productId).setQuantity(quanitity);
        }
    }

    public synchronized List<CartItem> getItems(){
        return items.values().stream()
            .map(item -> new CartItem(item.getProduct(), item.getQuantity()))
            .toList();
    }

    public synchronized BigDecimal getTotal(){
        return items.values().stream()
          .map(x->x.getSubtotal())
          .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public synchronized void clear(){
        items.clear();
    }

    public synchronized boolean isEmpty(){
        return items.isEmpty();
    }

}
