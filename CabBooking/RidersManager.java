package CabBooking;

import java.util.ArrayList;
import java.util.List;

import CabBooking.Model.Rider;

public class RidersManager {
    List<Rider> riders = new ArrayList<>();

    public void createRider(String id, String riderName){
        Rider cab = new Rider(id, riderName);
        riders.add(cab);
    }

    public Rider getRider(String riderId) {

        Rider riderWithId = riders.stream()
        .filter(rider -> rider.getId() == riderId)
        .findFirst().orElse(null);

        return riderWithId;
    }
}
