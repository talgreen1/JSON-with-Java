package _03_formatting;

import com.fasterxml.jackson.core.FormatFeature;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.restassured.internal.mapping.Jackson1Mapper;
import io.restassured.internal.mapping.Jackson2Mapper;

public class JacksonFormatting {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode root = mapper.createObjectNode();

        root.put("user name", "tal");
        root.put("age", 30.5);

        ArrayNode cars = mapper.createArrayNode();
        cars.add("Mazda");
        cars.add("Hyundai");
        cars.add("Honda");
        root.set("cars", cars);

        System.out.println(mapper.writeValueAsString(root));
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));
    }
}
