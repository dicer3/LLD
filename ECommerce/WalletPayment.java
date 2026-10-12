package ECommerce;

import java.math.BigDecimal;

import ECommerce.model.PaymentStatus;

public class WalletPayment implements PaymentStrategy {

    @Override
    public PaymentStatus pay(String customerId, BigDecimal amount) {
        // TODO Auto-generated method stub

        System.out.println("processing wallet payment "+amount);

        return PaymentStatus.SUCCESS;
    }
    
}
