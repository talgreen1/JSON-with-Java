package _05_advanced_jackson._03_deserialization;

import _04_serialization_and_deserialization.Person;
import _05_advanced_jackson._03_deserialization.model.Person1;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import java.io.FileReader;
import java.io.IOException;

public class AdvancedJacksonDeserialization {
    public static void main(String[] args) throws IOException {
        extraFieldsInJsonDeserialization();
        differentFieldName();
    }


    private static void differentFieldName() throws IOException {
        String json = "{\"id\":1,\"fullName\":\"Gidi Gov\", \"age\":65}";

        ObjectMapper mapper = new ObjectMapper();
        _05_advanced_jackson._03_deserialization.model.Person person;

        try {
            person = mapper.readValue(json, _05_advanced_jackson._03_deserialization.model.Person.class);
        } catch (UnrecognizedPropertyException e) {
            System.out.println(e.getMessage());
        }

        // Use the annotation @JsonProperty to indicate the JSON field name
        Person1 person1 = mapper.readValue(json, Person1.class);
        System.out.println(person1);
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
