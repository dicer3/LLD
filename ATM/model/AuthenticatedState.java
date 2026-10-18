package ATM.model;

import java.math.BigDecimal;

public class AuthenticatedState implements ATMState{

    private final ATM atm;

    public AuthenticatedState(ATM atm){
        this.atm = atm;
    }


    @Override
    public void insertCard(Card card) {
        // TODO Auto-generated method stub
        System.out.println("A card is already authenciated");
    }

    @Override
    public void authenticate(String pin) {
        // TODO Auto-generated method stub
        System.out.println("Already authenciated");
    }

    @Override
    public void checkBalance() {
        String accountNumber = atm.getCurrentCard().getAccountNumber();
        System.out.println("Current balance: " + atm.getBankService().getBalance(accountNumber));
    }

    @Override
    public void withdraw(int amount) {
        // TODO Auto-generated method stub
        if(amount <= 0) {
            System.out.println("Amount must be postive");
            return;
        }

        if(!atm.getCashDispenser().canDispense(amount)){
            System.out.println("ATM can't dispense requested amount");
            return;
        }

        String accountNumber = atm.getCurrentCard().getAccountNumber();

        BigDecimal withdrawalAmount = BigDecimal.valueOf(amount);

        if(!atm.getBankService().withdraw(accountNumber, withdrawalAmount)){
            System.out.println("Insufficent Balance");
            return;
        }

        boolean dispensed = atm.getCashDispenser().dispense(amount);

        if(!dispensed){

            atm.getBankService().deposit(accountNumber, withdrawalAmount);

            System.out.println("Cash dispensing failed");

            return;
        }

        System.out.println("Withdrwal successfull ");

    }

    @Override
    public void deposit(int amount) {
        // TODO Auto-generated method stub

        if(amount <= 0){
            System.out.println("Amount must be postive");
            return;
        }

        String accountNumber = atm.getCurrentCard().getAccountNumber();

        atm.getBankService().deposit(accountNumber, BigDecimal.valueOf(amount));

        System.out.println("Depost Succesfull "+amount);
    }

    @Override
    public void ejectCard() {
        // TODO Auto-generated method stub
        atm.setCurrentCard(null);
        atm.setState(new IdleState(atm));
        System.out.println("Card ejected");
    }
    
    
}
