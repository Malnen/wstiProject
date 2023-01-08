package com.wsti.vehicle;

public class FamilyCar extends Vehicle {
    public FamilyCar() {
        super(4, 4);
    }

    @Override
    public void move() {
        System.out.println("Brum brum...");
    }
}
