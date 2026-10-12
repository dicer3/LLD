package ECommerce;

import java.math.BigDecimal;
import ECommerce.model.PaymentStatus;

interface PaymentStrategy {
    
    PaymentStatus pay(
        String customerId,
        BigDecimal amount
    );
}
