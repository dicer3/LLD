package ATM.model;

public class CardInsertedState implements ATMState{

    private final ATM atm;

    public CardInsertedState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(Card card) {
        // TODO Auto-generated method stub
        System.out.println("A card already inserted");
    }

    @Override
    public void authenticate(String pin) {
        // TODO Auto-generated method stub

        String accountNumber = atm.getCurrentCard().getAccountNumber();

        if (atm.getBankService().authenticate(accountNumber, pin)) {
            atm.setState(new AuthenticatedState(atm));
            System.out.println("Authentication Successfull ");
        } else {
            System.out.println("Invalid PIN");
        }
    }

    @Override
    public void checkBalance() {
        // TODO Auto-generated method stub
        System.out.println("Please authenticate first");
    }

    @Override
    public void withdraw(int amount) {
        // TODO Auto-generated method stub
        System.out.println("Please authenticate first");
    }

    @Override
    public void deposit(int amount) {
        // TODO Auto-generated method stub
        System.out.println("Please authenticate first");
    }

    @Override
    public void ejectCard() {
        // TODO Auto-generated method stub
        System.out.println("Please authenticate first");
    }
    
    
}
