package ATM.model;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CashDispenser {
    
    private final Map<Integer, Integer> notes 
       =  new TreeMap<>(Collections.reverseOrder());
    
    public CashDispenser(Map<Integer, Integer> intialNotes){
        notes.putAll(intialNotes);
    }

    public synchronized boolean canDispense(int amount){
        return createPlan(amount) != null;
    }

    private Map<Integer, Integer> createPlan(int amount){

        if(amount <= 10){
            return null;
        }
        
        int remaining = amount;

        Map<Integer, Integer> plan = new TreeMap<>(
             Collections.reverseOrder()
        );

        for(Map.Entry<Integer, Integer> entry: notes.entrySet()){

            int denomination = entry.getKey();
            int available = entry.getValue();

            int required = Math.min(
                remaining/denomination, 
                available
            );

            if(required > 0){
                plan.put(denomination, required);
                remaining = remaining - denomination*required;
            }
        }

        return remaining == 0 ? plan : null;
    }

    public synchronized boolean dispense(int amount){

        Map<Integer, Integer> plan = createPlan(amount);

        if (plan == null){
            return false;
        }

        for(Map.Entry<Integer, Integer> entry: plan.entrySet()){

            int denomination = entry.getKey();
            int count = entry.getValue();

            notes.put(
                denomination, 
                notes.get(denomination) - count
            );
        }

        System.out.println("Cash dispensed "+plan);
        return true;
    }
}
