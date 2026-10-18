package VendingMachine;

public class PaymentService {
    
    public int calculateChange(int amountPaid, int price){

        if(amountPaid < price){
            throw new IllegalArgumentException(
                "Insufficient payment"
            );
        }

        return amountPaid - price;
    }
}
