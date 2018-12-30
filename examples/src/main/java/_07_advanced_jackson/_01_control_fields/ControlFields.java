package _07_advanced_jackson._01_control_fields;

import _07_advanced_jackson._01_control_fields.model.Person;
import _07_advanced_jackson._01_control_fields.model.Person1;
import _07_advanced_jackson._01_control_fields.model.Person2;
import _07_advanced_jackson._01_control_fields.model.Person3;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@SuppressWarnings("Duplicates")
public class ControlFields {
    public static void main(String[] args) throws IOException {
//        serialize();
        deserialize();

        /*--------------------------------------------------------------------------------------------------
        |Summary:
        |
        |Serialization
        |--------------
        |- All public members will be serialized
        |- All members with getters will be serialized
        |- No restrictions on the constructor
        |
        |Deserialization
        |---------------
        |- Class must have default constructor
        |- All public members will be deserialized
        |- All members with getters or setters will be deserialized
        *---------------------------------------------------------------------------------------------------*/


    }

    private static void deserialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json;

        // Class must have default constructor
        json = "{\"id\":1,\"name\":\"Gidi Gov\", \"age\":65}";
        Person1 person1;

        try {
            person1 = mapper.readValue(json, Person1.class);
        } catch (Exception e) {
            System.out.println("No default ctor:\n" + e.getMessage());
        }
        // Public fields will be deserialized. Fields with getter & setter will also be deserialized
        // Fields with setter only will be deserialized only
        json = "{\"id\":1,\"name\":\"Gidi Gov\", \"age\":65, \"height\":182.3}";

        Person2 person2;

        try {
            person2 = mapper.readValue(json, Person2.class);
        } catch (Exception e) {
            System.out.println("Cannot deserialized 'height':\n" + e.getMessage());
        }

        json = "{\"id\":1,\"name\":\"Gidi Gov\", \"age\":65}";

        Person3 person3;

        person3 = mapper.readValue(json, Person3.class);
        System.out.println(person3);
    }


    private static ObjectMapper serialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json;

        //Jackson will serialize fields that are either public, or have a public getter methods
        // No restrictions on the constructor
        Person person = new Person(1, "Gidi Gov", 65);
        json = mapper.writeValueAsString(person);

        System.out.println(json);
        System.out.println("'age' is public, 'height' is private without getter and all others are private with getters");
        return mapper;
    }
}
