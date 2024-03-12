package com.lld.ParkingLot.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class Vehicle {
    String vehicleNumer;
    VehicleCategory vehicleCategory;
}
