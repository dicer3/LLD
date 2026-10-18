package ATM.model;

import java.math.BigDecimal;

public class Account {
    private final String accountNumber;
    private BigDecimal balance;

    public Account(String accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public synchronized boolean debit(BigDecimal amount){

        if(amount.signum() <= 0 || balance.compareTo(amount)<0){
            return false;
        }

        balance = balance.subtract(amount);
        return true;
    }

    public synchronized void credit(BigDecimal amount){

        if(amount.signum() <= 0){
            throw new IllegalArgumentException(
                "Amount must be postive"
            );
        }

        balance = balance.add(amount);
    }

}
