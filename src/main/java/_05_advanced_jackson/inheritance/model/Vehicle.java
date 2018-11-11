package _05_advanced_jackson.inheritance.model;

public abstract class Vehicle {
    private String maker;
    private String model;

    protected Vehicle(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }

    // no-arg constructor, getters and setters
}
