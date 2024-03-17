package CabBooking;

import CabBooking.Model.Location;

public class Main {
    public static void main(String[] args) throws Exception {
        CabsManager cabsManager = new CabsManager();
        RidersManager ridersManager = new RidersManager();

        TripManager tripManager = new TripManager(cabsManager);

        String r1 = "r1";
        ridersManager.createRider(r1, "ud");
        String r2 = "r2";
        ridersManager.createRider(r2, "du");
        String r3 = "r3";
        ridersManager.createRider(r3, "rider3");
        String r4 = "r4";
        ridersManager.createRider(r4, "rider4");
    
        String c1 = "c1";
        cabsManager.createCab(c1, "driver1");
        String c2 = "c2";
        cabsManager.createCab(c2, "driver2");
        String c3 = "c3";
        cabsManager.createCab(c3, "driver3");
        String c4 = "c4";
        cabsManager.createCab(c4, "driver4");
        String c5 = "c5";
        cabsManager.createCab(c5, "driver5");

        cabsManager.updateCabLocation(c1, new Location(1.0, 1.0));
        cabsManager.updateCabLocation(c2, new Location(2.0, 2.0)); //na
        cabsManager.updateCabLocation(c3, new Location(100.0, 100.0));
        cabsManager.updateCabLocation(c4, new Location(110.0, 110.0)); //na
        cabsManager.updateCabLocation(c5, new Location(4.0, 4.0));

        cabsManager.updateCabAvailability(c2, false);
        cabsManager.updateCabAvailability(c4, false);

        tripManager.createTrip(ridersManager.getRider(r1), new Location(0.0, 0.0),new Location(500.0, 500.0));
    }
}
