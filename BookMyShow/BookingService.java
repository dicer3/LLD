package BookMyShow;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import BookMyShow.model.Booking;
import BookMyShow.model.User;
import BookMyShow.model.Show;
import BookMyShow.model.ShowSeat;
import BookMyShow.model.PaymentStatus;
import BookMyShow.PricingStrategy;


public class BookingService {
    
    private final SeatLockManager seatLockManager;
    private final PaymentStrategy paymentStrategy;

    public BookingService(
        SeatLockManager seatLockManager,
        PaymentStrategy paymentStrategy
    ){
        this.seatLockManager = seatLockManager;
        this.paymentStrategy = paymentStrategy;;
    }

    public Booking createBooking(
        User user,
        Show show,
        List<ShowSeat> seats
    ){

        List<ShowSeat> lockedSeats = new ArrayList<>();

        for(ShowSeat showSeat: seats){

            boolean locked = seatLockManager.lock(
                showSeat.getSeat().getId()
            );

            if(!locked){
                for(ShowSeat lockedSeat: seats){
                    if(showSeat!=lockedSeat)
                    seatLockManager.unlock(
                        lockedSeat.getSeat().getId()
                    );
                }

                throw new IllegalStateException(
                    "One or more seats are already locked"
                );
            }

            lockedSeats.add(showSeat);
        }

        double totalAmount = 0;

        for(ShowSeat seat: seats){

            PricingStrategy strategy = PricingStrategyFactory.getStrategy(
                seat.getSeat().getType()
            );

            totalAmount += strategy.calculatePrice(seat);
        
        }

        PaymentStatus paymentStatus = paymentStrategy.pay(totalAmount);

        if(paymentStatus != PaymentStatus.SUCCESS){

            for(ShowSeat seat: seats){
                    seatLockManager.unlock(
                        seat.getSeat().getId()
                    );
                }

                throw new IllegalStateException(
                    "Payment Failed"
                ); 
        }

        // Book seats
        for(ShowSeat showSeat: seats){
            showSeat.book();
        }

        Booking booking = new Booking(UUID.randomUUID().toString(), user, show, seats);

        booking.confirm();
        return booking;
    }
}
