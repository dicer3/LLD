package VendingMachine;

public class ProductSelectState implements MachineState {

    private final VendingMachine vendingMachine;

    public ProductSelectState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String productId) {
        
        System.out.println(
            "A product is already selected. " +
            "Cancel first to choose another."
        );


    }

    @Override
    public void insertMoney(int amount) {
        // TODO Auto-generated method stub

        if(amount <= 0){
            System.out.println(
                "Insert a postive amount."
            );

            return;
        }

        vendingMachine.addAmount(amount);

        int paid = vendingMachine.getAmountPaid();

        int price = vendingMachine.getSelectedProduct().getPrice();

        System.out.println(
            "Inserted: Rs. "+ amount +
            ", Total paid: Rs" + paid
        );

        if(paid >= price){
            vendingMachine.setState(
                new HasMoneyState(vendingMachine)
            );
        } else {
            System.out.println(
                "Remaining Price "+ (price-paid)
            );
        }


    }

    @Override
    public void dispense() {
        // TODO Auto-generated method stub
            System.out.println(
                "Insufficient payment. Insert more money."
            );        
    }

    @Override
    public void cancel() {
        // TODO Auto-generated method stub
       
        vendingMachine.returnMoney();
        vendingMachine.resetTransaction();
        System.out.println("Transaction cancelled ");
    }
    
}
