package com.example;

public class Cube {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public double calculateSquare() {
        return 4 * Math.pow(side, 2);
    }

    public double calculateVolume() {
        return Math.pow(side, 3);
    }
}
