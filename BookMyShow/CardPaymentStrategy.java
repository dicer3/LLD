package BookMyShow;

import BookMyShow.model.PaymentStatus;

public class CardPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentStatus pay(double amount) {
        // TODO Auto-generated method stub

        System.out.println("Paid using credit card");

        return  PaymentStatus.SUCCESS;
    }
    
}
