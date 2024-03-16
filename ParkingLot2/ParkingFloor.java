package ParkingLot2;

import java.util.List;
import java.util.Map;

import ParkingLot2.Model.ParkingSlotType;
import ParkingLot2.Model.Vehicle;
import ParkingLot2.Model.VehicleCategory;

public class ParkingFloor {
    String parkingFloor;
    Map<ParkingSlotType, List<ParkingSlot>> parkingSlots;
    public ParkingFloor(String parkingFloor, Map<ParkingSlotType, List<ParkingSlot>> parkingSlots) {
        this.parkingFloor = parkingFloor;
        this.parkingSlots = parkingSlots;
    }

    public ParkingSlot getRelevantSlotForVehicleAndPark(Vehicle vehicle) {

       VehicleCategory vehicleCategory = vehicle.getVehicleCategory();
       ParkingSlotType parkingSlotType = pickCorrectSlot(vehicleCategory); 
       List<ParkingSlot> currParkingSlots = parkingSlots.get(parkingSlotType);
       ParkingSlot selectedParkingSlot = null;
       for(ParkingSlot parkingslot :currParkingSlots){
            if(parkingslot.isAvailable){
                parkingslot.addVehicle(vehicle);
                System.out.println("found ");
                selectedParkingSlot = parkingslot;
                break;
            }
       }
       System.out.println("slot "+selectedParkingSlot);
       return selectedParkingSlot;

    }     

    private ParkingSlotType pickCorrectSlot(VehicleCategory vehicleCategory) {
        if(vehicleCategory.equals(VehicleCategory.TwoWheeler)) return ParkingSlotType.TwoWheeler;
        else if(vehicleCategory.equals(VehicleCategory.HatchBack) || vehicleCategory.equals(VehicleCategory.Sedan)) return ParkingSlotType.Compact;
        else if(vehicleCategory.equals(VehicleCategory.SUV)) return ParkingSlotType.Medium;
        else if(vehicleCategory.equals(VehicleCategory.Bus)) return ParkingSlotType.Large;

        return null;
    }
}
