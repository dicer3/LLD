package ATM.model;

public interface ATMState {
    
    void insertCard(Card card);

    void authenticate(String pin);

    void checkBalance();

    void withdraw(int amount);

    void deposit(int amount);

    void ejectCard();
}
