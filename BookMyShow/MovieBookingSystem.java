package BookMyShow;

import java.util.List;

import BookMyShow.BookingService;
import BookMyShow.model.User;
import BookMyShow.model.Show;
import BookMyShow.model.Booking;
import BookMyShow.model.ShowSeat;


public class MovieBookingSystem {
    
    private final BookingService bookingService;

    public MovieBookingSystem(
        BookingService bookingService
    ) {
        this.bookingService = bookingService;
    }

    public Booking bookTickets(
        User user,
        Show show,
        List<ShowSeat> seats){

            return bookingService.createBooking(
                user, 
                show, 
                seats
            );
        }
    
}
