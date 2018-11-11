package _05_advanced_jackson.inheritance.model;

public class Car extends Vehicle {
    private int seatingCapacity;
    private double topSpeed;

    public Car(String maker, String model, int seatingCapacity, double topSpeed) {
        super(maker, model);
        this.seatingCapacity = seatingCapacity;
        this.topSpeed = topSpeed;
    }

    public Car(String maker, String model) {
        super(maker, model);
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public Car setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
        return this;
    }

    public double getTopSpeed() {
        return topSpeed;
    }

    public Car setTopSpeed(double topSpeed) {
        this.topSpeed = topSpeed;
        return this;
    }
}