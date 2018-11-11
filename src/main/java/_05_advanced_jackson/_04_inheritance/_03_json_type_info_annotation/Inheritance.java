package _05_advanced_jackson._04_inheritance._03_json_type_info_annotation;

import _05_advanced_jackson._04_inheritance._03_json_type_info_annotation.model.Car;
import _05_advanced_jackson._04_inheritance._03_json_type_info_annotation.model.Fleet;
import _05_advanced_jackson._04_inheritance._03_json_type_info_annotation.model.Truck;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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

        fleet = mapper.readValue(jsonDataString, Fleet.class);
        System.out.println("Fleet:\n" + fleet);
    }

}
