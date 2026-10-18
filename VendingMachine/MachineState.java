package VendingMachine;

public interface MachineState {
    
    void selectProduct(String productId);

    void insertMoney(int amount);

    void dispense();

    void cancel();
}
