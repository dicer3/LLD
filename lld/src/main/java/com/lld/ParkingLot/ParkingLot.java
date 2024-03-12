package com.lld.ParkingLot;

import java.util.List;
import java.util.Map;

import com.lld.ParkingLot.Model.Address;
import com.lld.ParkingLot.Model.ParkingSlotType;
import com.lld.ParkingLot.Model.Ticket;
import com.lld.ParkingLot.Model.Vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingLot {
    private String nameOfParkingLot;
    private Address address;
    private List<ParkingFloor> parkingfloors;
    private static ParkingLot parkingLot = null;
    public ParkingLot(String nameOfParkingLot, Address address, List<ParkingFloor> parkingfloors) {
        this.nameOfParkingLot = nameOfParkingLot;
        this.address = address;
        this.parkingfloors = parkingfloors;
    }
    
    public static ParkingLot getInstance(String nameOfParkingLot, Address address, List<ParkingFloor> parkingFloors){
        if(parkingLot == null){
            parkingLot = new ParkingLot(nameOfParkingLot, address, parkingFloors)
        }

        return parkingLot;    
    }

    public void addFloors(String name,Map<ParkingSlotType, Map<String,ParkingSlot>> parkingSlots ){
        ParkingFloor parkingFloor = new ParkingFloor(name, parkingSlots);
        parkingfloors.add(parkingFloor);
    }

    public void removeFloors(ParkingFloor parkingFloor){
          parkingfloors.remove(parkingFloor);
    }

    public Ticket assignTicket(Vehicle vehicle){
        ParkingSlot parkingSlot = getParkingSlotForVehicleAndPark(vehicle);
        if(parkingSlot == null) return null;
        Ticket parkingTicket = createTicketForSlot(parkingSlot, vehicle);
        return parkingTicket;
    }

    private Ticket createTicketForSlot(ParkingSlot parkingSlot, Vehicle vehicle){
        return Ticket.createTicket(vehicle, parkingSlot);
    }

    public double scanAndPay(Ticket ticket){
        long endTime = System.currentTimeMillis();
        ticket.getParkingSlot().removeVehicle(ticket.getVehicle());
        int duration = (int)(endTime - ticket.getStartTime())/1000;
        double price = ticket.getParkingSlot().getParkingSlotType().getPriceForParking(duration);
        return price;
    }

    private ParkingSlot getParkingSlotForVehicleAndPark(Vehicle vehicle){
         ParkingSlot parkingSlot = null;
         for(ParkingFloor floor: parkingfloors){
            parkingSlot = floor.getRelevantSlotForVehicleAndPark(vehicle);
            if(parkingSlot !=null)
               break;
         }
         return parkingSlot;
    } 
    
}
