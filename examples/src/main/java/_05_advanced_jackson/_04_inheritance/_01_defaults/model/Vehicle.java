package _05_advanced_jackson._04_inheritance._01_defaults.model;

public abstract class Vehicle {
    protected String maker;
    protected String model;

    public Vehicle() {
    }

    protected Vehicle(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }
}
