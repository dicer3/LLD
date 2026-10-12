package BookMyShow.model;

import java.util.List;

public class Booking {
    
    private final String id;
    private final User user;
    private final Show show;
    private final List<ShowSeat> seats;

    private BookingStatus status;

    public Booking(String id, User user, Show show, List<ShowSeat> seats) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.status = BookingStatus.PENDING;
    }

    public void confirm(){
        status = BookingStatus.CONFIRMED;
    }

    public void cancel(){
        status = BookingStatus.CANCELLED;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public List<ShowSeat> getSeats() {
        return seats;
    }

}

