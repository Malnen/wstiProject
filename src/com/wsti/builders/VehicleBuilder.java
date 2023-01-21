package com.wsti.builders;

import com.wsti.enums.VehicleType;
import com.wsti.parts.BikeTire;
import com.wsti.parts.CarTire;
import com.wsti.parts.Engine;
import com.wsti.parts.Tire;
import com.wsti.vehicles.Bike;
import com.wsti.vehicles.FamilyCar;
import com.wsti.vehicles.FastCar;
import com.wsti.vehicles.Vehicle;

public class VehicleBuilder {
    private Vehicle vehicle;
    private Engine engine;
    private String brand;
    private String model;
    private VehicleType vehicleType;

    public VehicleBuilder setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public VehicleBuilder setEngine(int engineCapacity, int power, int price) {
        engine = new Engine(engineCapacity, power, price);
        return this;
    }

    public VehicleBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public VehicleBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public Vehicle build() {
        vehicle = getConcreteVehicle();
        vehicle.setEngine(engine);
        vehicle.setBrand(brand);
        vehicle.setModel(model);
        for (int i = 0; i < vehicle.getTireCount(); i++) {
            Tire tire = getConcreteTire();
            vehicle.mountTire(tire);
        }

        return vehicle;
    }

    private Vehicle getConcreteVehicle() {
        switch (vehicleType) {
            case FAST:
                return new FastCar();
            case FAMILY:
                return new FamilyCar();
            case BIKE:
                return new Bike();
        }

        throw new IllegalArgumentException("Illegal vehicle type");
    }

    private Tire getConcreteTire() {
        switch (vehicleType) {
            case FAST:
            case FAMILY:
                return new CarTire();
            case BIKE:
                return new BikeTire();
        }

        throw new IllegalArgumentException("Illegal vehicle type");
    }

}