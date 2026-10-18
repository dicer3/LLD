package ATM.model;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BankService {
    
    private final Map<String, Account> accounts =
        new ConcurrentHashMap<>();
    
    private final Map<String, String> accountPins =
        new ConcurrentHashMap<>();
    
    public void addAccount(Account account, String pin){
        accounts.put(account.getAccountNumber(), account);
        accountPins.put(account.getAccountNumber(), pin);
    }

    public boolean authenticate(String accountNumber, String pin){
        String storedPin = accountPins.get(accountNumber);
        return storedPin !=  null && storedPin.equals(pin);
    }

    public BigDecimal getBalance(String accountNumber){
        Account account = getAccount(accountNumber);
        return account.getBalance();
    }

    public boolean withdraw(String accountNumber, BigDecimal amount){
        return getAccount(accountNumber).debit(amount);
    }

    public void deposit(String accountNumber, BigDecimal amount){
         getAccount(accountNumber).credit(amount);
    }

    private Account getAccount(String accountNumber){

        Account account = accounts.get(accountNumber);

        if(account == null){
            throw new IllegalArgumentException(
                "Account doesn't exist"
            );
        }

        return account;
    }
}
