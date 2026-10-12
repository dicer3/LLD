package BookMyShow;
import BookMyShow.model.ShowSeat;

public interface PricingStrategy {

    double calculatePrice(ShowSeat seat);
    
}