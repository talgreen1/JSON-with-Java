package _05_advanced_jackson.inheritance;

import _05_advanced_jackson.inheritance.model.Car;
import _05_advanced_jackson.inheritance.model.Truck;
import _05_advanced_jackson.inheritance.model.Vehicle;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

    public static void main(String[] args) throws JsonProcessingException {
        Fleet fleet = new Fleet();

        Car car = new Car("Mercedes-Benz", "S500", 5, 250.0);
        Truck truck = new Truck("Isuzu", "NQR", 7500.0);
        fleet.addVehicle(car);
        fleet.addVehicle(truck);

        ObjectMapper mapper = new ObjectMapper();
        String jsonDataString = mapper.writeValueAsString(fleet);

        System.out.println(jsonDataString);

    }
}
