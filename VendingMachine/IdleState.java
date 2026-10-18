package VendingMachine;

public class IdleState implements MachineState {


    private final VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String productId) {
        // TODO Auto-generated method stub

        Product product = vendingMachine.getInventory()
                          .getAvailableProduct(productId);

        vendingMachine.setSelectedProduct(product);
               
        System.out.println(
            "Selected: "+product.getName() +
            ", Price: Rs. "+product.getPrice()
        );

        vendingMachine.setState(
            new ProductSelectState(vendingMachine)
        );
    }

    @Override
    public void insertMoney(int amount) {
       
        System.out.println("Please select a product first.");
    }

    @Override
    public void dispense() {
        // TODO Auto-generated method stub
        System.out.println("Please select a product first.");
    }

    @Override
    public void cancel() {
        System.out.println("No active transaction.");
    }
    
    
}
