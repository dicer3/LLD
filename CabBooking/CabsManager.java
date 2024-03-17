package CabBooking;

import java.util.ArrayList;
import java.util.List;


import CabBooking.Model.Cab;
import CabBooking.Model.Location;

public class CabsManager {
    List<Cab> cabs = new ArrayList<>();

    public void createCab(String id, String driverName){
        Cab cab = new Cab(id, driverName);
        cabs.add(cab);
    }

    public Cab getCab(String cabId) {


        Cab cabWithId = cabs.stream()
        .filter(cab -> cab.getId() == cabId)
        .findFirst().orElse(null);

        return cabWithId;
    }

    public void updateCabLocation(String cabId, Location newLocation) throws Exception{
        Cab specificCab = getCab(cabId);
        if(specificCab == null)
           throw new Exception("Cab with id : "+cabId+ "doesn't exist");
        specificCab.setCurrentLocation(newLocation);   
    }
    
    public void updateCabAvailability(String cabId, Boolean newAvailability) throws Exception{
        Cab specificCab = getCab(cabId);
        if(specificCab == null)
           throw new Exception("Cab with id : "+cabId+ "doesn't exist");
        specificCab.setIsAvailable(newAvailability);   
    }

    public List<Cab> getCabs(Location fromPoint, Double distance) {
        List<Cab> result = new ArrayList<>();
        for (Cab cab : cabs) {
          if (cab.getIsAvailable() && cab.getCurrentLocation().distance(fromPoint) <= distance) {
            result.add(cab);
          }
        }
        return result;
    }    
      
}
