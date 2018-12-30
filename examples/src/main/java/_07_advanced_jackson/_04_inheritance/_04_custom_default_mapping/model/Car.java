package _07_advanced_jackson._04_inheritance._04_custom_default_mapping.model;

public class Car extends Vehicle {
    private int seatingCapacity;
    private double topSpeed;

    public Car() {
    }

    public Car(String maker, String model, int seatingCapacity, double topSpeed) {
        super(maker, model);
        this.seatingCapacity = seatingCapacity;
        this.topSpeed = topSpeed;
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

    @Override
    public String toString() {
        return "Car{" +
                "seatingCapacity=" + seatingCapacity +
                ", topSpeed=" + topSpeed +
                ", maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}