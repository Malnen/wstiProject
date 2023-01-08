package com.wsti.vehicle;

public class Bike extends Vehicle {
    public Bike() {
        super(2, 1);
    }

    @Override
    public void move() {
        System.out.println("Szuuuuuuuu....");
    }
}
