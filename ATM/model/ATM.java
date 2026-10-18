package ATM.model;

public class ATM {
    
    private ATMState state;
    private Card currentCard;

    private final BankService bankService;
    private final CashDispenser cashDispenser;

    public ATM(
        BankService bankService,
        CashDispenser cashDispenser
    ) {
        this.bankService = bankService;
        this.cashDispenser = cashDispenser;
        this.state = new IdleState(this);
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public void setCurrentCard(Card currentCard) {
        this.currentCard = currentCard;
    }

    public ATMState getState() {
        return state;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public BankService getBankService() {
        return bankService;
    }

    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    public void insertCard(Card card) {
    state.insertCard(card);
}

    public void authenticate(String pin) {
        state.authenticate(pin);
    }

    public void checkBalance() {
        state.checkBalance();
    }

    public void withdraw(int amount) {
        state.withdraw(amount);
    }

    public void deposit(int amount) {
        state.deposit(amount);
    }

    public void ejectCard() {
        state.ejectCard();
    }
}
