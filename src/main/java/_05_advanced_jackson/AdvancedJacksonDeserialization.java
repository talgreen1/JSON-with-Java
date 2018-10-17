package _05_advanced_jackson;

import _04_serialization_and_deserialization.Person;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AdvancedJacksonDeserialization {
    public static void main(String[] args) throws IOException {
        extraFieldsInJsonDeserialization();
    }

    private static void extraFieldsInJsonDeserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Person person;

        // Doesn't work - Class Person doesn't have "address" member
        try {
            person = mapper.readValue(new FileReader("./src/main/resources/jsonFiles/person3_extra_field.json"), Person.class);
        } catch (IOException e) {
            System.out.println("Cannot deserialize: There are extra fields in the JSON file.");
            System.out.println(e.getMessage());
        }

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        person = mapper.readValue(new FileReader("./src/main/resources/jsonFiles/person3_extra_field.json"), Person.class);
        System.out.println("\n\n" + person);
    }
}
