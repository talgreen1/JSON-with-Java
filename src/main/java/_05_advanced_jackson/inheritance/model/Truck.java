package _05_advanced_jackson.inheritance.model;

public class Truck extends Vehicle {
    private double payloadCapacity;

    public Truck(String maker, String model, double payloadCapacity) {
        super(maker, model);
        this.payloadCapacity = payloadCapacity;
    }

    public Truck(String maker, String model) {
        super(maker, model);
    }

    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    public Truck setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
        return this;
    }
}