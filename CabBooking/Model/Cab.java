package CabBooking.Model;

public class Cab {

    String id;
    String driverName;

    Trip currentTrip;
    Location currentLocation;
    Boolean isAvailable;
    public Cab(String id, String driverName) {
        this.id = id;
        this.driverName = driverName;
        this.isAvailable = true;
    }
    
    public String getId() {
        return id;
    }


    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }
    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    
    

    
}
