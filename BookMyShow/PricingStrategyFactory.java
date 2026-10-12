package BookMyShow;

import BookMyShow.model.ShowSeat;
import BookMyShow.model.SeatType;

public class PricingStrategyFactory {

    public static PricingStrategy getStrategy(SeatType seatType){

        return switch (seatType){
            case REGULAR -> new RegularPricingStrategy();

            case PREMIUM -> new PremiumPricingStrategy();

            case RECLINER -> new ReclinerPricingStrategy();
        };
    }
        
}
