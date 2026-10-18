package VendingMachine;

public class Main {
    public static void main(String[] args) {
        
        Inventory inventory = new Inventory();

        inventory.addProduct(
            new Product("P1", "Coke", 40), 5
        );

        inventory.addProduct(
            new Product("P2", "Chips", 20), 5
        );

        inventory.addProduct(
            new Product("P3", "Water", 15), 4
        );

        VendingMachine vendingMachine = new VendingMachine(inventory, new PaymentService());

        inventory.displayProducts();

        System.out.println("\n--- Purchase 1 ----");

        vendingMachine.selectedProduct("P1");
        vendingMachine.insertMoney(20);
        vendingMachine.insertMoney(30);
        vendingMachine.dispense();

        inventory.displayProducts();

        System.out.println("\n---Purchase 2 ---");

        vendingMachine.selectedProduct("P2");
        vendingMachine.insertMoney(10);
        vendingMachine.dispense();
        vendingMachine.insertMoney(30);
        vendingMachine.dispense();

        inventory.displayProducts();

        System.out.println("\nPurchase 3 ---");

        vendingMachine.selectedProduct("P3");
        vendingMachine.insertMoney(10);
        vendingMachine.cancel();


    }
}
