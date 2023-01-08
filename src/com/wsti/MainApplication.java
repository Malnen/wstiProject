package com.wsti;

import com.wsti.builder.VehicleBuilder;
import com.wsti.part.BikeTire;
import com.wsti.part.CarTire;
import com.wsti.vehicle.Bike;
import com.wsti.vehicle.FamilyCar;
import com.wsti.vehicle.FastCar;
import com.wsti.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        VehicleBuilder builder = new VehicleBuilder();

        Vehicle bike = builder
                .setVehicleType(Bike.class)
                .setTireType(BikeTire.class)
                .setEngine(1000, 750, 3000)
                .setBrand("Yamaha")
                .setModel("MT-15")
                .build();

        Vehicle fastCar = builder
                .setVehicleType(FastCar.class)
                .setTireType(CarTire.class)
                .setEngine(3000, 2000, 20000)
                .setBrand("Lamborghini")
                .setModel("Aventador")
                .build();

        Vehicle familyCar = builder
                .setVehicleType(FamilyCar.class)
                .setTireType(CarTire.class)
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
