package ECommerce;

import java.math.BigDecimal;

import ECommerce.model.PaymentStatus;

public class UpiPayment implements PaymentStrategy {

    @Override
    public PaymentStatus pay(String customerId, BigDecimal amount) {
        // TODO Auto-generated method stub

        System.out.println("Processing UPI Payment "+amount);

        return PaymentStatus.SUCCESS;
    }
    
    
}
