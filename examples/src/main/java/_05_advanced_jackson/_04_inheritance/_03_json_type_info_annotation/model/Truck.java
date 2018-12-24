package _05_advanced_jackson._04_inheritance._03_json_type_info_annotation.model;

public class Truck extends Vehicle {
    private double payloadCapacity;

    public Truck(){

    }

    public Truck(String maker, String model, double payloadCapacity) {
        super(maker, model);
        this.payloadCapacity = payloadCapacity;
    }

    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    public Truck setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity = payloadCapacity;
        return this;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "payloadCapacity=" + payloadCapacity +
                ", maker='" + maker + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}