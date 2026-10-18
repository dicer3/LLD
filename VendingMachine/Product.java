package VendingMachine;

public class Product {
    
    private final String id;
    private final String name;
    private final int price;

    public Product(String id, String name, int price){

        if(price <= 0){

            throw new IllegalArgumentException(
                "Price must be postive"
            );
        }

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    
}
