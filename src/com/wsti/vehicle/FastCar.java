package com.wsti.vehicle;

public class FastCar extends Vehicle {
    public FastCar() {
        super(4, 2);
    }

    @Override
    public void move() {
        System.out.println("Wrrrrrrrrrrrrrrrrrrrrrrr...");
    }
}
