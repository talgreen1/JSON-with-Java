package _02_parsing;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GsonParsing {


    public static void main(String[] args) throws FileNotFoundException {
        simpleValuesJson();
        simpleObjectParsing();
        simpleArrayParsing();
        objectWithArrayParsing();

    }

    private static void objectWithArrayParsing() throws FileNotFoundException {
        JsonParser parser = new JsonParser();

        JsonElement jsonTree = parser.parse(new FileReader("./src/main/resources/jsonFiles/personWithCars.json"));

        JsonObject jsonObject = jsonTree.getAsJsonObject();
        System.out.printf("Name: %s%n", jsonObject.get("name").getAsString());
        System.out.printf("Age: %d%n", jsonObject.get("age").getAsInt());
        System.out.println("Cars:");

        JsonArray cars = jsonObject.get("cars").getAsJsonArray();

        Iterator<JsonElement> iter = cars.iterator();

        while (iter.hasNext()){
            JsonElement next = iter.next();
            System.out.println(next.getAsString());
        }


    }

    private static void simpleArrayParsing() {
        JsonParser parser = new JsonParser();

        String objJson = "[\"orange\", \"blue\", \"green\"]";

        JsonElement jsonTree = parser.parse(objJson);

        if (jsonTree.isJsonArray()){
            JsonArray jsonArray = jsonTree.getAsJsonArray();

            System.out.printf("The size of the array is: %d%n",jsonArray.size());

            for (int i=0; i<jsonArray.size(); i++){
                String color = jsonArray.get(i).getAsString();
                System.out.println(color);
            }
        }
    }

    private static void simpleValuesJson(){
        JsonParser parser = new JsonParser();

        String intJson = "22";

        JsonElement jsonTree = parser.parse(intJson);

        if (jsonTree.isJsonPrimitive()){
            int intVal = jsonTree.getAsInt();
            System.out.printf("intVal: %d%n", intVal);
        }
    }

    private static void simpleObjectParsing() {
        JsonParser parser = new JsonParser();

        String objJson = "{\"id\":\"1\", \"name\":\"gidi\"}";

        JsonElement jsonTree = parser.parse(objJson);

        if (jsonTree.isJsonObject()){
            JsonObject jsonObject = jsonTree.getAsJsonObject();
            int id = jsonObject.get("id").getAsInt();
            String name = jsonObject.get("name").getAsString();

            System.out.printf("ID: %d, Name: %s%n", id, name);
        }
    }
}
