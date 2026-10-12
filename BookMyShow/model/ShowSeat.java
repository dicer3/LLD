package BookMyShow.model;

public class ShowSeat {
    private final Show show;
    private final Seat seat;
    
    private SeatStatus status;

    public ShowSeat(Show show, Seat seat, SeatStatus status) {
        this.show = show;
        this.seat = seat;
        this.status = status;
    }

    public synchronized boolean lock(){

        if(status != SeatStatus.AVAIABLE){
            return false;
        }

        status = SeatStatus.LOCKED;
        return false;
    }

    public synchronized boolean book(){

        if(status != SeatStatus.LOCKED){
            throw new IllegalStateException(
                "Seat must be locked first");
        }

        status = SeatStatus.BOOKED;
        return false;
    }

    public synchronized void release(){
        if(status == SeatStatus.LOCKED){
            status = SeatStatus.AVAIABLE;
        }
    }

    public SeatStatus getStatus(){
        return status;
    }

    public Seat getSeat(){
        return seat;
    }
    
}
