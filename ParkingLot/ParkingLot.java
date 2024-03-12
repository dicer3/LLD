package ParkingLot;

import java.util.ArrayList;
import java.util.List;
public class ParkingLot {

    List<CompactSpot> compactSpotList = new ArrayList<>();
    List<LargeSpot> largeSpotsList = new ArrayList<>();
    List<BikeSpot> bikeSpotsList = new ArrayList<>();

    int freeCompactSpots;
    int freeLargeSpots;
    int freeBikeSpots;


    public ParkingLot(int freeCompactSpots, int freeLargeSpots, int freeBikeSpots){
        this.freeCompactSpots = freeCompactSpots;
        this.freeLargeSpots = freeLargeSpots;
        this.freeBikeSpots = freeBikeSpots;
    }

    public void parkVehicle(Vehicle vehicle){
        System.out.println("we are about to park vehicle");

        if(vehicle.getVehicleType().equals(VehicleType.TRUCK)){
            if(freeLargeSpots > 0)
               parkYourLargeVehicle(vehicle);
            else 
               System.out.println("");  
        } else if(vehicle.getVehicleType().equals(VehicleType.CAR)){
            if(freeCompactSpots > 0)
               parkYourLargeVehicle(vehicle);
            else if(freeCompactSpots > 0)
               parkYourCompactVehicle(vehicle);
        } else if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
            if(freeBikeSpots > 0)
                parkYourBikeVehicle(vehicle);
            else if(freeCompactSpots > 0)
               parkYourCompactVehicle(vehicle);
            else if(freeLargeSpots > 0)
                parkYourLargeVehicle(vehicle); 
        }

    }

    void parkYourLargeVehicle(Vehicle vehicle){
        LargeSpot largeSpot = new LargeSpot(ParkingSpotType.LARGE);
        largeSpot.setFree(false);
        largeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(largeSpot);

        largeSpotsList.add(largeSpot);
        System.out.println("We have successfully parked your vechile "+vehicle.getVehicleType()+ " Vehicle.");
        freeLargeSpots --;
    }

    void parkYourCompactVehicle(Vehicle vehicle){
        CompactSpot compactSpot = new CompactSpot(ParkingSpotType.COMPACT);
        compactSpot.setFree(false);
        compactSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(compactSpot);

        compactSpotList.add(compactSpot);
        System.out.println("We have successfully parked your vechile "+vehicle.getVehicleType()+ " Vehicle.");
        freeCompactSpots --;
    }

    void parkYourBikeVehicle(Vehicle vehicle){
        BikeSpot bikeSpot = new BikeSpot(ParkingSpotType.COMPACT);
        bikeSpot.setFree(false);
        bikeSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(bikeSpot);

        bikeSpotsList.add(bikeSpot);
        System.out.println("We have successfully parked your vechile "+vehicle.getVehicleType()+ " Vehicle.");
        freeBikeSpots --;
    }

    public void unParkVehicle(Vehicle vehicle){
        System.out.println("we are about to Unpark vehcile");
        ParkingSpot parkingSpot = vehicle.getParkingSpot();
        parkingSpot.setFree(true);
        parkingSpot.setVehicle(null);

        if(vehicle.getVehicleType().equals(VehicleType.TRUCK)){
            if(largeSpotsList.remove(parkingSpot)){
                System.out.println("we have succesffuly removed your vehicle");
                freeLargeSpots++;
            } else 
                System.out.println("You don't have your vehcile parked in paring lot");
        }
        if(vehicle.getVehicleType().equals(VehicleType.CAR)){
            if(compactSpotList.remove(parkingSpot)){
                System.out.println("we have succesffuly removed your vehicle");
                freeCompactSpots++;
            } else 
                System.out.println("You don't have your vehcile parked in paring lot");
        }
        if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
            if(bikeSpotsList.remove(parkingSpot)){
                System.out.println("we have succesffuly removed your vehicle");
                freeBikeSpots++;
            } else 
                System.out.println("You don't have your vehcile parked in paring lot");
        }
    }
}