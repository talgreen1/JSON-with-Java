package _07_advanced_jackson._04_inheritance._04_custom_default_mapping.model;

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
