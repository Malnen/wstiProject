package com.wsti.parts;

public class Engine {
    private final int engineCapacity;
    private final int power;
    private final double price;

    public Engine(int engineCapacity, int power, int price) {
        this.engineCapacity = engineCapacity;
        this.power = power;
        this.price = price;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public int getPower() {
        return power;
    }

    public double getPrice() {
        return price;
    }
}
