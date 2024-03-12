package com.lld.ParkingLot;

import java.util.Map;

import com.lld.ParkingLot.Model.ParkingSlotType;
import com.lld.ParkingLot.Model.Vehicle;
import com.lld.ParkingLot.Model.VehicleCategory;

public class ParkingFloor {
    String name;
    Map<ParkingSlotType, Map<String,ParkingSlot>> parkingSlots;
    public ParkingFloor(String name, Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots) {
        this.name = name;
        this.parkingSlots = parkingSlots;
    }

    public ParkingSlot getRelevantSlotForVehicleAndPark(Vehicle vehicle){
        VehicleCategory vehicleCategory = vehicle.getVehicleCategory();
        ParkingSlotType parkingSlotType = pickCorrectSlot(vehicleCategory);
        Map<String, ParkingSlot> releventParking = parkingSlots.get(parkingSlotType);
        ParkingSlot slot = null;
        for(Map.Entry<String, ParkingSlot> m: releventParking.entrySet()){
            if(m.getValue().isAvailable){
                slot = m.getValue();
                slot.addVehicle(vehicle);
                break;
            }
        }
        return slot;
    }

    private ParkingSlotType pickCorrectSlot(VehicleCategory vehicleCategory){
        if(vehicleCategory.equals(VehicleCategory.TwoWheeler)) return ParkingSlotType.TwoWheeler;
        else if(vehicleCategory.equals(VehicleCategory.HatchBack) || vehicleCategory.equals(VehicleCategory.Sedan)) return ParkingSlotType.Compact;
        else if(vehicleCategory.equals(VehicleCategory.SUV)) return ParkingSlotType.Medium;
        else if(vehicleCategory.equals(VehicleCategory.Bus)) return ParkingSlotType.Large;

        return null;
    }
}
