package _04_serialization_and_deserialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JacksonDeserialization {
    public static void main(String[] args) throws IOException {
//        primitivesDeserialization();
//        objectDeserialization();
//        collectionDeserialization();
//        deserializeToMap();
        deserializeImmutableObject();
    }

    private static void deserializeImmutableObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        /**
         * In Java 8 - can use the module 'ParameterNamesModule'. No need for default constructor and setters.
         * Can deserialize Immutable classes without any annotation by using the all args constructor.
         * Need to compile with "-parameters'
         */
        mapper.registerModule(new ParameterNamesModule());

        String json = "{\"name\":\"gidi\", \"id\":1}"; // {"name":"gidi", "id":1}
        URL url = Resources.getResource("jsonFiles/person1_all.json");
        ImmutablePerson person = mapper.readValue(json, ImmutablePerson.class);
        System.out.println(person);
    }

    private static void deserializeToMap() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Map<String, Object> map = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });
        System.out.println(map);

        URL url = Resources.getResource("jsonFiles/personWithCarsInnerObject.json");
        map = mapper.readValue(url, new TypeReference<Map<String, Object>>() {
        });
        System.out.println(map);
    }

    private static void collectionDeserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = Resources.getResource("jsonFiles/numbers.json");

        // Wrong syntax
        //List<Integer> list = mapper.readValue(url, List<Integer>.class)

        // Unchecked assignment warning
        //List<Integer> list = mapper.readValue(url, List.class);

        // Use TypeToken to get real type
        List<Integer> list = mapper.readValue(url, new TypeReference<List<Integer>>() { });

        System.out.println(list);
    }

    private static void objectDeserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        URL url = Resources.getResource("jsonFiles/person1_all.json");
        Person person = mapper.readValue(url, Person.class);
        System.out.println(person);

        url = Resources.getResource("jsonFiles/person2_no_colors_wrong_order.json");
        person = mapper.readValue(url, Person.class);
        System.out.println(person);

        // Doesn't work - Class Person doesn't have "address" member
        try {
            url = Resources.getResource("jsonFiles/person3_extra_field.json");
            person = mapper.readValue(url, Person.class);
        } catch (Exception e) {
            System.out.println("Doesn't work - Class Person doesn't have 'address' member");
            System.out.println(e.getMessage());
        }
    }

    private static void primitivesDeserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        int intResult = mapper.readValue("1", int.class);
        System.out.println(intResult);

        Integer integerResult = mapper.readValue("1", Integer.class);
        System.out.println(integerResult);

        Long longResult = mapper.readValue("1", Long.class);
        System.out.println(longResult);


        boolean booleanResult = mapper.readValue("true", boolean.class);
        System.out.println(booleanResult);

        String stringResult = mapper.readValue("\"abc\"", String.class);
        System.out.println(stringResult);

        String[] stringArrayResult = mapper.readValue("[\"hello\",\"world\"]", String[].class);
        System.out.println(Arrays.toString(stringArrayResult));

        URL url = Resources.getResource("jsonFiles/names.json");
        stringArrayResult = mapper.readValue(url, String[].class);

        System.out.println(Arrays.toString(stringArrayResult));

    }


}
