package com.wsti.vehicles;

import com.wsti.parts.Engine;
import com.wsti.parts.Tire;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    private final List<Tire> tires;
    private final int tireCount;
    private final int seatCount;

    private Engine engine;
    private String brand;
    private String model;

    protected Vehicle(int tireCount, int seatCount) {
        this.tireCount = tireCount;
        this.seatCount = seatCount;
        this.tires = new ArrayList<>();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTireCount() {
        return tireCount;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public abstract void move();

    public double getTotalPrice() {
        double enginePrice = engine.getPrice();
        double tiresPrice = tires.stream().mapToDouble(Tire::getPrice).sum();

        return (enginePrice + tiresPrice) * 1.25;
    }

    public void mountTire(Tire tire) {
        tires.add(tire);
    }

    public String getEngineDescription() {
        return "Engine capacity: " + engine.getEngineCapacity() + ", Engine power: " + engine.getPower();
    }
}
