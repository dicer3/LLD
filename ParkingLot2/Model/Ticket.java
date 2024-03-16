package ParkingLot2.Model;

import ParkingLot2.ParkingSlot;

public class Ticket {
    String ticketNumber;
    long startTime;
    long endTime;
    Vehicle vehicle;
    ParkingSlot parkingSlot;
    public String getTicketNumber() {
        return ticketNumber;
    }
    public long getStartTime() {
        return startTime;
    }
    public long getEndTime() {
        return endTime;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }
    public Ticket setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
        return this;
    }
    public Ticket setStartTime(long startTime) {
        this.startTime = startTime;
        return this;
    }
    public Ticket setEndTime(long endTime) {
        this.endTime = endTime;
        return this;
    }
    public Ticket setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }
    public Ticket setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
        return this;

    }

    public static Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot){
        Ticket ticket = new Ticket();
        return ticket
                .setParkingSlot(parkingSlot)
                .setStartTime(System.currentTimeMillis())
                .setVehicle(vehicle)
                .setTicketNumber(vehicle.getVehicleNumer()+System.currentTimeMillis());
    } 

    
}
