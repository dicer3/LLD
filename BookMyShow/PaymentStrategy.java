package BookMyShow;
import BookMyShow.model.PaymentStatus;

public interface PaymentStrategy {
    PaymentStatus pay(double amount);
}
