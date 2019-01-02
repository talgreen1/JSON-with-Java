package _08_advanced_jackson._04_inheritance._01_defaults;


import _08_advanced_jackson._04_inheritance._01_defaults.model.Car;
import _08_advanced_jackson._04_inheritance._01_defaults.model.Fleet;
import _08_advanced_jackson._04_inheritance._01_defaults.model.Truck;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class Inheritance {
    public static void main(String[] args) throws IOException {
        Fleet fleet = new Fleet();

        Car car = new Car("Mercedes-Benz", "S500", 5, 250.0);
        Truck truck = new Truck("Isuzu", "NQR", 7500.0);
        fleet.addVehicle(car);
        fleet.addVehicle(truck);

        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String jsonDataString = mapper.writeValueAsString(fleet);

        System.out.println("The JSON after serializing:\n");
        System.out.println(jsonDataString);

        try {
            fleet = mapper.readValue(jsonDataString, Fleet.class);
        } catch (IOException e) {
            System.out.println("By default - Jackson will read values to the list as Vehicle. But it is abstract class and cannot be created:\n" + e.getMessage());
        }
    }

}
