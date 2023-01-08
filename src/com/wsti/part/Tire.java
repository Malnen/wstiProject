package com.wsti.part;

public abstract class Tire {
    private final double price;

    protected Tire(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
