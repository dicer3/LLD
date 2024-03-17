package CabBooking.Model;

public class Trip {
    private Rider rider;
    private Cab cab;
    private TripStatus status;
    private Double price;
    private Location fromPoint;
    private Location toPoint;
    public Trip(Rider rider, Cab cab, Double price, Location fromPoint, Location toPoint) {
        this.rider = rider;
        this.cab = cab;
        this.price = price;
        this.fromPoint = fromPoint;
        this.toPoint = toPoint;
        this.status = TripStatus.IN_PROGRESS;
    }

    public void endTrip() {
        this.status = TripStatus.FINISHED;
    }

    public Rider getRider() {
        return rider;
    }

    
    
}
