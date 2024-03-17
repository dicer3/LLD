package CabBooking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import CabBooking.Model.Cab;
import CabBooking.Model.Location;
import CabBooking.Model.Rider;
import CabBooking.Model.Trip;

public class TripManager {
    public static final Double MAX_ALLOWD_TRIP_MATCHING_DISTANCE = 10.0;
    public static final Double PER_KM_RATE = 10.0;

    List<Trip> allTrips = new ArrayList<>();

    private CabsManager cabsManager;

    public TripManager(CabsManager cabsManager) {
      this.cabsManager = cabsManager;
    }

    public double findPrice(Location fromPoint, Location toPoint){
        return fromPoint.distance(toPoint) * PER_KM_RATE;
    }

    public void createTrip(Rider rider, Location fromPoint, Location toPoint) throws Exception{
        final List<Cab> closeByCabs =
        cabsManager.getCabs(fromPoint, MAX_ALLOWD_TRIP_MATCHING_DISTANCE);

        if(closeByCabs.size() == 0){
            throw new Exception("no close by cabs are aviable near the rider "+rider.getName());
        }
        Cab selectedCab = closeByCabs.get(0);  //cabMatchingStratergy 
        String selectedCabId = selectedCab.getId();

        System.out.println("selected cab with id "+selectedCabId);
      
        final Double price = findPrice(fromPoint, toPoint); //pricing stratergy

        System.out.println("price of the ride would be "+price);

        final Trip newTrip = new Trip(rider, selectedCab, price, fromPoint, toPoint);

        cabsManager.updateCabAvailability(selectedCabId, false);

        selectedCab.setCurrentTrip(newTrip);
        
        allTrips.add(newTrip);
    }

    public List<Trip> tripHistory(Rider rider) {
        
        List<Trip> riderTrips = allTrips.stream().
        filter(trip -> trip.getRider().getId() == rider.getId()).collect(Collectors.toList());
        return riderTrips;
      }
    
      public void endTrip(Cab cab) {
        cab.setCurrentTrip(null);
        cab.setIsAvailable(false);
        cab.getCurrentTrip().endTrip();
      }

}
