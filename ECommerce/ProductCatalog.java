package ECommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ECommerce.model.Product;

public class ProductCatalog {
    
    private final Map<String, Product> products =
        new ConcurrentHashMap<>();
    
    public void addProduct(Product product){
        products.put(product.getId(), product);
    }

    public Product getProduct(String productId){
        Product product = products.get(productId);

        if(product == null){
            throw new IllegalArgumentException("Product not found "+productId);
        }

        return product;
    }

    public List<Product> getAllProducts(String keyword){
        return new ArrayList<>(products.values());
    }

    public List<Product> search(String keyword){

        String searchTerm = keyword.toLowerCase();

        return products.values().stream()
               .filter(p -> p.getName().toLowerCase().equals(searchTerm))
               .toList();
    }
        

}
