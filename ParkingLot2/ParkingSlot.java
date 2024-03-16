package ParkingLot2;

import ParkingLot2.Model.ParkingSlotType;
import ParkingLot2.Model.Vehicle;

public class ParkingSlot {
    String name;
    boolean isAvailable = true;
    Vehicle vehicle;
    ParkingSlotType parkingSlotType;

    public ParkingSlot(String name, ParkingSlotType parkingSlotType) {
        this.name = name;
        this.parkingSlotType = parkingSlotType;
    }

    protected void addVehicle(Vehicle vehicle2){
        this.vehicle = vehicle2;
        this.isAvailable=false;
    }

    protected void removeVehicle(Vehicle vehicle){
        this.vehicle=null;
        this.isAvailable=true;
    }

    public ParkingSlotType getParkingSlotType() {
        return parkingSlotType;
    }

    @Override
    public String toString() {
        return "ParkingSlot [name=" + name + ", isAvailable=" + isAvailable + ", vehicle=" + vehicle
                + ", parkingSlotType=" + parkingSlotType + "]";
    }

    
    
}
