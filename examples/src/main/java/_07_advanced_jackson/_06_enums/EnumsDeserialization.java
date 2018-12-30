package _07_advanced_jackson._06_enums;

import _07_advanced_jackson._06_enums.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * https://www.baeldung.com/jackson-serialize-enums
 */
public class EnumsDeserialization {
    public static void main(String[] args) throws IOException {
        basicEnumDerialization();
        enumCustomDerializer();
    }

    private static void enumCustomDerializer() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"DayName\":\"SUNDAY\",\"DayVal\":2}"; // {"DayName":"SUNDAY","DayVal":2}

        Day5 day = mapper.readValue(json, Day5.class);

        System.out.println(day);
    }

    private static void basicEnumDerialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // You can use enum values
        String json = "\"MONDAY\"";

        Day day = mapper.readValue(json, Day.class);
        System.out.println(day);

        // You can use zero based index
        json = "0";

        day = mapper.readValue(json, Day.class);
        System.out.println(day);


    }
}
