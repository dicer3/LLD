package ECommerce;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryService {
    
    private final Map<String, Integer> stock =
        new ConcurrentHashMap<>();

    public void addStock(String productId, int quantity){

        if(quantity <= 0){
            throw new IllegalArgumentException("Quanity must be postive");
        }

        stock.merge(productId, quantity, Integer::sum);
    }

    public synchronized void reserve(
        String productId, int quantity
    ){
        int available = stock.getOrDefault(productId, 0);

        if(quantity <= 0 || available < quantity) {
             throw new IllegalStateException("Insufficent stock for "+productId);
        }

        stock.put(productId, available -  quantity);
    }

    public synchronized void release(
        String productId, int quantity
    ) {
        stock.merge(productId, quantity, Integer::sum);
    }

    public synchronized int getAvaibableStock(
      String productId
    ) {
        return stock.getOrDefault(productId, 0);
    }
}
