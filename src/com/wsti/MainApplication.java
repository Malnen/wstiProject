package com.wsti;

import com.wsti.builders.VehicleBuilder;
import com.wsti.enums.VehicleType;
import com.wsti.parts.BikeTire;
import com.wsti.parts.CarTire;
import com.wsti.vehicles.Bike;
import com.wsti.vehicles.FamilyCar;
import com.wsti.vehicles.FastCar;
import com.wsti.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        VehicleBuilder builder = new VehicleBuilder();

        Vehicle bike = builder
                .setVehicleType(VehicleType.BIKE)
                .setEngine(1000, 750, 3000)
                .setBrand("Yamaha")
                .setModel("MT-15")
                .build();

        Vehicle fastCar = builder
                .setVehicleType(VehicleType.FAST)
                .setEngine(3000, 2000, 20000)
                .setBrand("Lamborghini")
                .setModel("Aventador")
                .build();

        Vehicle familyCar = builder
                .setVehicleType(VehicleType.FAMILY)
                .setEngine(1500, 400, 1000)
                .setBrand("Opel")
                .setModel("Zafira")
                .build();

        vehicles.add(bike);
        vehicles.add(fastCar);
        vehicles.add(familyCar);

        vehicles.forEach(MainApplication::describeVehicle);
        System.out.println();
        vehicles.forEach(Vehicle::move);
    }

    private static void describeVehicle(Vehicle vehicle) {
        System.out.println(
                "Brand: " + vehicle.getBrand()
                        + ", Model: " + vehicle.getModel()
                        + ", Number of seats: " + vehicle.getSeatCount()
                        + ", Number of tires: " + vehicle.getTireCount()
                        + ", Total price: " + vehicle.getTotalPrice()
                        + ", " + vehicle.getEngineDescription()
        );
    }
}
