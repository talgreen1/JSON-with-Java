package _05_advanced_jackson._08_nulls;

import _05_advanced_jackson._08_nulls.model.Person;
import _05_advanced_jackson._08_nulls.model.Person1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class Nulls {
    public static void main(String[] args) throws IOException {
//        serializeEmptyList();
//        serializeNullList();


        deserializeNull();
        deserializeEmptyList();
        deserializeNullAsEmpty();


    }

    private static void deserializeNullAsEmpty() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"id\":1,\"name\":\"Gidi\",\"childrens\":null}";// {"id":1,"name":"Gidi","childrens":null}

        Person1 person = mapper.readValue(json, Person1.class);

        System.out.println(person);
    }

    private static void deserializeEmptyList() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"id\":1,\"name\":\"Gidi\",\"childrens\":[]}";// {"id":1,"name":"Gidi","childrens":[]}

        Person person = mapper.readValue(json, Person.class);

        System.out.println(person);
    }

    private static void deserializeNull() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"id\":1,\"name\":\"Gidi\",\"childrens\":null}";// {"id":1,"name":"Gidi","childrens":null}

        Person person = mapper.readValue(json, Person.class);

        System.out.println(person);

    }

    private static void serializeNullList() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person(1, "Gidi", null);

        String json = mapper.writeValueAsString(person); // {"id":1,"name":"Gidi","childrens":null}

        System.out.println(json);
    }

    private static void serializeEmptyList() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person(1, "Gidi", new ArrayList<String>());

        String json = mapper.writeValueAsString(person); // {"id":1,"name":"Gidi","childrens":[]}

        System.out.println(json);

    }
}
