package _08_advanced_jackson._06_enums;

import _08_advanced_jackson._06_enums.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * https://www.baeldung.com/jackson-serialize-enums
 */
public class EnumsSerialization {
    public static void main(String[] args) throws JsonProcessingException {
        basicEnumSerialization();
        writeEnumUsingIndex();
        enumAsObject();
        enumFields();
        enumCustomSerializer();
    }

    private static void writeEnumUsingIndex() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.WRITE_ENUMS_USING_INDEX);
        String json;
        json = mapper.writeValueAsString(Day.FRIDAY);
        System.out.println(json);
    }

    private static void enumCustomSerializer() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        json = mapper.writeValueAsString(Day3.FRIDAY);
        System.out.println(json);

        PersonWithEnum3 person = new PersonWithEnum3(1, "Gidi", 50.5, Day3.SUNDAY);
        json = mapper.writeValueAsString(person);

        System.out.println(json);
    }

    private static void enumFields() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        json = mapper.writeValueAsString(Day2.FRIDAY);
        System.out.println(json);

        PersonWithEnum2 person = new PersonWithEnum2(1, "Gidi", 50.5, Day2.SUNDAY);
        json = mapper.writeValueAsString(person);

        System.out.println(json);
    }

    private static void enumAsObject() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        json = mapper.writeValueAsString(Day1.FRIDAY);
        System.out.println(json);

        PersonWithEnum1 person = new PersonWithEnum1(1, "Gidi", 50.5, Day1.SUNDAY);
        json = mapper.writeValueAsString(person);

        System.out.println(json);

    }

    private static void basicEnumSerialization() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        json = mapper.writeValueAsString(Day.FRIDAY);
        System.out.println(json);

        PersonWithEnum person = new PersonWithEnum(1, "Gidi", 50.5, Day.SUNDAY);
        json = mapper.writeValueAsString(person);

        System.out.println(json);
    }
}
