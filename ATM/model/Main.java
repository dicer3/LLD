package ATM.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        
        BankService bankService = new BankService();

        Account account = new Account("ACC101",  new BigDecimal("10000"));

        bankService.addAccount(account, "1234");

        Map<Integer, Integer> notes = new HashMap<>();

        notes.put(500, 10);
        notes.put(200, 10);
        notes.put(100, 20);

        CashDispenser cashDispenser = new CashDispenser(notes);

        ATM atm = new ATM(bankService, cashDispenser);

        Card card = new Card("CARD101", "ACC101");

        atm.checkBalance();
        atm.insertCard(card);
        atm.checkBalance();
        atm.authenticate("1234");

        atm.checkBalance();
        atm.withdraw(1200);
        atm.checkBalance();

        atm.deposit(500);
        atm.checkBalance();

        atm.ejectCard();

    }
}
