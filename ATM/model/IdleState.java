package ATM.model;

public class IdleState implements ATMState {

    private final ATM atm;

    public IdleState(ATM atm){
        this.atm = atm;
    }

    @Override
    public void insertCard(Card card) {
        // TODO Auto-generated method stub

        if(card == null){
            System.out.println("Invalid Card");
            return;
        }

        atm.setCurrentCard(card);
        atm.setState(new CardInsertedState(atm));
    }

    @Override
    public void authenticate(String pin) {
        // TODO Auto-generated method stub
        System.out.println("Please insert your card first");
    }

    @Override
    public void checkBalance() {
        // TODO Auto-generated method stub
        System.out.println("Please insert your card first");
    }

    @Override
    public void withdraw(int amount) {
        // TODO Auto-generated method stub
        System.out.println("Please insert your card first");
    }

    @Override
    public void deposit(int amount) {
        // TODO Auto-generated method stub
        System.out.println("Please insert your card first");
    }

    @Override
    public void ejectCard() {
        // TODO Auto-generated method stub
        System.out.println("Please insert your card first");
    }
    
}
