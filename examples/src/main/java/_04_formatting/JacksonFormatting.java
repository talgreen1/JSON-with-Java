package _04_formatting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

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
