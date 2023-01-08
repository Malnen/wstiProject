package com.wsti.builder;

import com.wsti.part.Engine;
import com.wsti.part.Tire;
import com.wsti.vehicle.Vehicle;

public class VehicleBuilder {
    private Vehicle vehicle;
    private Engine engine;
    private String brand;
    private String model;
    private Class<? extends Vehicle> vehicleType;
    private Class<? extends Tire> tireType;

    public VehicleBuilder setVehicleType(Class<? extends Vehicle> vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public VehicleBuilder setEngine(int engineCapacity, int power, int price) {
        engine = new Engine(engineCapacity, power, price);
        return this;
    }

    public VehicleBuilder setTireType(Class<? extends Tire> tireType) {
        this.tireType = tireType;
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
        try {
            vehicle = vehicleType.getDeclaredConstructor().newInstance();
            vehicle.setEngine(engine);
            vehicle.setBrand(brand);
            vehicle.setModel(model);
            for (int i = 0; i < vehicle.getTireCount(); i++) {
                Tire tire = tireType.getDeclaredConstructor().newInstance();
                vehicle.mountTire(tire);
            }
        } catch (Exception ignored) {
        }

        return vehicle;
    }
}