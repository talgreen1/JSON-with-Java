package _08_advanced_jackson._04_inheritance._02_enable_default_typing;

import _08_advanced_jackson._04_inheritance._02_enable_default_typing.model.Car;
import _08_advanced_jackson._04_inheritance._02_enable_default_typing.model.Fleet;
import _08_advanced_jackson._04_inheritance._02_enable_default_typing.model.Truck;
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
        mapper.enableDefaultTyping();
        String jsonDataString = mapper.writeValueAsString(fleet);

        System.out.println("The JSON after serializing:\n");
        System.out.println(jsonDataString);

        fleet = mapper.readValue(jsonDataString, Fleet.class);
        System.out.println("Fleet:\n" + fleet);

    }


}
