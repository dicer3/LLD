package BookMyShow;

import BookMyShow.model.PaymentStatus;

public class UpiPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentStatus pay(double amount) {
        // TODO Auto-generated method stub

        System.out.println("Paid using UPI: "+amount);

        return PaymentStatus.SUCCESS;
    }
    
    
}
