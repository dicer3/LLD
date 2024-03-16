package ParkingLot2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ParkingLot2.Model.Address;
import ParkingLot2.Model.ParkingSlotType;
import ParkingLot2.Model.Ticket;
import ParkingLot2.Model.Vehicle;
import ParkingLot2.Model.VehicleCategory;

public class ParkingMain {
    public static void main(String[] args) throws InterruptedException {
        String nameOfParkingLot ="Pintosss Parking Lot";
        Address address = new Address().setCity("Bangalore").setCountry("India").setState("KA");
        Map<ParkingSlotType, List<ParkingSlot>>  allSlots = new HashMap<>();
        ParkingSlot p1 = new ParkingSlot("C1", ParkingSlotType.Compact);
        ParkingSlot p2 = new ParkingSlot("C1", ParkingSlotType.Compact);
        List compactParkingSlots = new ArrayList<>(Arrays.asList(p1,p2));
        allSlots.put(ParkingSlotType.Compact, compactParkingSlots);

        // ParkingSlot p3 = new ParkingSlot("C1", ParkingSlotType.Large);

        List largeParkingSlots = new ArrayList<>(Arrays.asList(new ParkingSlot("C1", ParkingSlotType.Large)));
        allSlots.put(ParkingSlotType.Large, largeParkingSlots);

        ParkingFloor groundFloor = new ParkingFloor("groungFloor", allSlots);

        List<ParkingFloor> parkingFloors = new ArrayList<>();
        parkingFloors.add(groundFloor);

        ParkingLot parkingLot = ParkingLot.getInstance(nameOfParkingLot,address,parkingFloors);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleCategory(VehicleCategory.HatchBack);
        vehicle.setVehicleNumer("KA-01-MA-9999");

        Ticket ticket = parkingLot.assignTicket(vehicle);
        System.out.println(" ticket number >> "+ticket.getTicketNumber());
        //persist the ticket to db here
        Thread.sleep(10000);
        double price = parkingLot.scanAndPay(ticket);
        System.out.println("price is >>" + price);
    }
}
