package _04_serialization_and_deserialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JacksonSerialization {
    public static void main(String[] args) throws IOException {
//            primitivesSerialization();
//        collectionSerialization();
//        objectSerialization();
            writeToFile();
    }

    private static void writeToFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person(1, "Gidi", 50.5, new String[]{"White", "Red"}, null);

        try (FileWriter writer = new FileWriter("c:/temp/person.json");) {
            mapper.writeValue(writer, person);
        }
    }

    private static void objectSerialization() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        Person person = new Person(1, "Gidi", 50.5, new String[]{"White", "Red"}, null);
        String json = mapper.writeValueAsString(person);

        System.out.println(json);

        person = new Person(1, "Alon", 60, new String[]{"Blue"}, "Description....");
        json = mapper.writeValueAsString(person);

        System.out.println(json);
    }

    private static void collectionSerialization() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        String json = mapper.writeValueAsString(numbers);
        System.out.println(json);
    }

    private static void primitivesSerialization() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String res = mapper.writeValueAsString(1);

        System.out.println(res);

        res = mapper.writeValueAsString("Hello");
        System.out.println(res);

        int[] values = {1, 2, 3};
        res = mapper.writeValueAsString(values);       // ==> [1]
        System.out.println(res);
    }
}
