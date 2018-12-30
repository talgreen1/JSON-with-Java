package _07_advanced_jackson._04_inheritance._03_json_type_info_annotation.model;

import java.util.ArrayList;
import java.util.List;

public class Fleet {

    private List<Vehicle> vehicles;

    public Fleet() {
        vehicles = new ArrayList<>();
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Fleet setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
        return this;
    }


    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        vehicles.forEach(v -> res.append(v).append("\n"));

        return res.toString();
    }
}
