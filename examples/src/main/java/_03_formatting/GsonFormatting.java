package _03_formatting;

import com.google.gson.*;

public class GsonFormatting {
    public static void main(String[] args) {
        JsonObject root = new JsonObject();
        root.addProperty("user name", "tal");
        root.addProperty("age", 30.4);

        JsonArray cars = new JsonArray(3);
        cars.add("Hyundai");
        cars.add("Honda");
        cars.add("Mazda");

        root.add("cars", cars);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        Gson gson = new Gson();

        System.out.printf("The jason is: %n%s", gson.toJson(root));


    }
}
