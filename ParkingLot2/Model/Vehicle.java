package ParkingLot2.Model;


public class Vehicle {
    String vehicleNumer;
    VehicleCategory vehicleCategory;
    public String getVehicleNumer() {
        return vehicleNumer;
    }
    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }
    public void setVehicleNumer(String vehicleNumer) {
        this.vehicleNumer = vehicleNumer;
      //  return this;
    }
    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
        // return this;
    }

    

    
}
