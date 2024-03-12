package com.lld.ParkingLot;

import com.lld.ParkingLot.Model.ParkingSlotType;
import com.lld.ParkingLot.Model.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class ParkingSlot {
    String name;
    @Builder.Default
    boolean isAvailable = true;
    Vehicle vehicle;
    ParkingSlotType parkingSlotType;
    public ParkingSlot(String name, ParkingSlotType parkingSlotType) {
        this.name = name;
        this.parkingSlotType = parkingSlotType;
    }

    protected void addVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    protected void removeVehicle(Vehicle vehicle){
        this.vehicle = null;
        this.isAvailable = true;
    }

}
