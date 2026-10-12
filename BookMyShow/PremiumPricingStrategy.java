package BookMyShow;

import BookMyShow.model.ShowSeat;

public class PremiumPricingStrategy implements  PricingStrategy {

    @Override
    public double calculatePrice(ShowSeat seat) {
        return 350;
    }
    
}
