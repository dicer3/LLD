package VendingMachine;

public class HasMoneyState implements  MachineState{

    private final VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String productId) {
        // TODO Auto-generated method stub

        System.out.println(
            "Finish or cancel the current transaction."
        );
    }

    @Override
    public void insertMoney(int amount) {
        // TODO Auto-generated method stub
        
        System.out.println(
            "Sufficient money already received. " +
            "Please dispense or cancel."
        );
    }

    @Override
    public void dispense() throws IllegalStateException {
        // TODO Auto-generated method stub
        
        Product product = vendingMachine.getSelectedProduct();

        int change  = vendingMachine.getPaymentService()
                      .calculateChange(vendingMachine.getAmountPaid(), product.getPrice());

        vendingMachine.getInventory().dispense(product.getId());

        System.out.println("Dispensing :" +product.getName());

        System.out.println("Change returned "+change);

        vendingMachine.resetTransaction();

        System.out.println("Transaction completed ");
    }

    @Override
    public void cancel() {
        // TODO Auto-generated method stub
        
        vendingMachine.returnMoney();
        vendingMachine.resetTransaction();
        System.out.println("Transaction cancelled.");
    }
    
}
