package VendingMachine;


public class VendingMachine {
    
    private final Inventory inventory;
    private final PaymentService paymentService;

    private MachineState state;
    private Product selectedProduct;
    private int amountPaid;

    public VendingMachine(Inventory inventory, PaymentService paymentService){
        this.inventory = inventory;
        this.paymentService = paymentService;
        this.state = new IdleState(this);
    }

    public Inventory getInventory(){
        return inventory;
    }

    public void selectedProduct(String productId){
        state.selectProduct(productId);
    }

    public void insertMoney(int amount){
        state.insertMoney(amount);
    }

    public void dispense(){
        state.dispense();
    }

    public void cancel(){
        state.cancel();
    }

    void setState(MachineState state){
        this.state = state;
    }

    PaymentService getPaymentService(){
        return paymentService;
    }

    Product getSelectedProduct(){
        return selectedProduct;
    }

    void setSelectedProduct(Product product){
        this.selectedProduct = product;
    }

    int getAmountPaid(){
        return amountPaid;
    }

    void addAmount(int amount){
        amountPaid += amount;
    }

    void resetTransaction() {
        selectedProduct = null;
        amountPaid = 0;
        state = new IdleState(this);
    }

    void returnMoney(){
        System.out.println(
            "Refund: Rs."+ amountPaid
        );
    }

}
