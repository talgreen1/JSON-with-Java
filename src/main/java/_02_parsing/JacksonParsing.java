package _02_parsing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.xml.transform.Source;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/**
 * https://github.com/FasterXML/jackson-docs
 */
public class JacksonParsing {
    public static void main(String[] args) throws IOException {
        simpleValuesJson();
        simpleObjectParsing();
        simpleArrayParsing();
        objectWithArrayParsing();
    }

    private static void objectWithArrayParsing() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(new FileReader("./src/main/resources/jsonFiles/personWithCars.json"));

        System.out.println(node.getNodeType());

        String name = node.get("name").asText();
        String age = node.get("age").asText();

        System.out.printf("Name: %s, Age:%s%n", name, age);
        System.out.println("Cars:");

        JsonNode cars = node.get("cars");
        for (JsonNode car:cars){
            System.out.println("\t" + car.asText());
        }

    }

    private static void simpleArrayParsing() throws IOException {
        String objJson = "[\"orange\", 3, \"green\"]";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(objJson);

        System.out.println(node.getNodeType());

        if (node.isArray()) {
            System.out.println("The size of the array is: " + node.size());

            System.out.println("Iterating with Iterator:");
            Iterator<JsonNode> iterator = node.iterator();

            while (iterator.hasNext()) {
                JsonNode next = iterator.next();
                System.out.printf("Element type:[%s], value:[%s]%n", next.getNodeType(), next.asText());
            }

            System.out.println("Iterating with for loop:");
            for (int i=0; i<node.size(); i++){
                System.out.println(node.get(i).asText());
            }
        }
    }

    private static void simpleObjectParsing() throws IOException {
        String objJson = "{\"id\":\"1\", \"name\":\"gidi\"}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(objJson);

        System.out.println(node.getNodeType());

        if (node.isObject()) {
            System.out.println(node.get("id").asText());
            System.out.println(node.get("id").asInt());
            System.out.println(node.get("name").asText());
        }
    }

    private static void simpleValuesJson() throws IOException {
        String intJson = "22";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(intJson);

        System.out.println(node.getNodeType());

        if (node.isValueNode()) {
            System.out.println(node.asText());
            System.out.println(node.asInt());
        }
    }
}
