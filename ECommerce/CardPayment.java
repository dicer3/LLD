package ECommerce;

import java.math.BigDecimal;

import ECommerce.model.PaymentStatus;

public class CardPayment implements  PaymentStrategy {

    @Override
    public PaymentStatus pay(String customerId, BigDecimal amount) {
        // TODO Auto-generated method stub
        System.out.println("Processing Card Payment "+amount);

        return PaymentStatus.SUCCESS;
    }
    
}
