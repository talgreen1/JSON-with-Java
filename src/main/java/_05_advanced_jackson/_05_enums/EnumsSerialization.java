package _05_advanced_jackson._05_enums;

import _05_advanced_jackson._05_enums.model.Day;
import _05_advanced_jackson._05_enums.model.Day1;
import _05_advanced_jackson._05_enums.model.PersonWithEnum;
import _05_advanced_jackson._05_enums.model.PersonWithEnum1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * https://www.baeldung.com/jackson-serialize-enums
 */
public class EnumsSerialization {
    public static void main(String[] args) throws JsonProcessingException {
//        basicEnumSerialization();
        enumAsObject();
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
