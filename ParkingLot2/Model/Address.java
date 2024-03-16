package ParkingLot2.Model;

public class Address {
    String street;
    String block;
    String city;
    String state;
    String country;
    public String getStreet() {
        return street;
    }
    public String getBlock() {
        return block;
    }
    public String getCity() {
        return city;
    }
    public String getState() {
        return state;
    }
    public String getCountry() {
        return country;
    }

    
    public Address setStreet(String street) {
        this.street = street;
        return this;
    }
    public Address setBlock(String block) {
        this.block = block;
        return this;
    }
    public Address setCity(String city) {
        this.city = city;
        return this;
    }
    public Address setState(String state) {
        this.state = state;
        return this;
    }
    public Address setCountry(String country) {
        this.country = country;
        return this;
    }


    
    
    
}
