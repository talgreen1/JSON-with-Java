package _04_serialization_and_deserialization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JacksonDeserialization {
    public static void main(String[] args) throws IOException {
//        primitivesDeserialization();
//        objectDeserialization();
//        collectionDeserialization();
        deserializeToMap();
    }

    private static void deserializeToMap() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Map<String, Object> map = mapper.readValue(json,  new TypeReference<Map<String,Object>>(){});
        System.out.println(map);

        map = mapper.readValue(new FileReader("./src/main/resources/jsonFiles/personWithCarsInnerObject.json"), new TypeReference<Map<String,Object>>(){});
        System.out.println(map);
    }

    private static void collectionDeserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        FileReader fileReader = new FileReader("./src/main/resources/jsonFiles/numbers.json");

        // Wrong syntax
//        List<Integer> list = mapper.readValue(fileReader, List<Integer>.class)

        // Unchecked assignment warning
//        List<Integer> list = mapper.readValue(fileReader, List.class);

        // Use TypeToken to get real type
        List<Integer> list = mapper.readValue(fileReader, new TypeReference<List<Integer>>(){});

        System.out.println(list);
    }

    private static void objectDeserialization() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(new FileReader("./src/main/resources/jsonFiles/person1_all.json"), Person.class);
        System.out.println(person);

        person = mapper.readValue(new FileReader("./src/main/resources/jsonFiles/person2_no_colors_wrong_order.json"), Person.class);
        System.out.println(person);

        // Doesn't work - Class Person doesn't have "address" member
//        person = mapper.readValue(new FileReader("./src/main/resources/jsonFiles/person3_extra_field.json"), Person.class);
//        System.out.println(person);
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

        stringArrayResult = mapper.readValue(new FileReader("./src/main/resources/jsonFiles/names.json"), String[].class);
        System.out.println(Arrays.toString(stringArrayResult));

    }


}
