package _04_serialization_and_deserialization;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public class GsonDeserialization {
    public static void main(String[] args) throws IOException {
//        primitivesDeserialization();
        objectDeserialization();
//        collectionDeserialization();
    }


    private static void primitivesDeserialization() throws IOException {
        // GsonDeserialization - From JSON to instance
        Gson gson = new Gson();

        int intResult = gson.fromJson("1", int.class);
        System.out.println(intResult);

        Integer integerResult = gson.fromJson("1", Integer.class);
        System.out.println(integerResult);

        Long longResult = gson.fromJson("1", Long.class);
        System.out.println(longResult);

        Boolean booleanResult = gson.fromJson("false", Boolean.class);
        System.out.println(booleanResult);

        String stringResult = gson.fromJson("\"abc\"", String.class);
        System.out.println(stringResult);

        String[] stringArrayResult = gson.fromJson("[\"hello\",\"world\"]", String[].class);
        System.out.println(Arrays.toString(stringArrayResult));


        URL url = Resources.getResource("jsonFiles/names.json");
        String jsonString = Resources.toString(url, Charset.defaultCharset());
        stringArrayResult = gson.fromJson(jsonString, String[].class);
        System.out.println(Arrays.toString(stringArrayResult));

    }


    private static void objectDeserialization() throws IOException {
        Gson gson = new Gson();

        URL url = Resources.getResource("jsonFiles/person1_all.json");
        String jsonString = Resources.toString(url, Charset.defaultCharset());

        Person person = gson.fromJson(jsonString, Person.class);
        System.out.println(person);


        url = Resources.getResource("jsonFiles/person2_no_colors_wrong_order.json");
        jsonString = Resources.toString(url, Charset.defaultCharset());

        person = gson.fromJson(jsonString, Person.class);
        System.out.println(person);

        url = Resources.getResource("jsonFiles/person3_extra_field.json");
        jsonString = Resources.toString(url, Charset.defaultCharset());

        person = gson.fromJson(jsonString, Person.class);
        System.out.println(person);


    }


    private static void collectionDeserialization() throws FileNotFoundException {
        Gson gson = new Gson();

        FileReader fileReader = new FileReader("./src/main/resources/jsonFiles/numbers.json");

        // Wrong syntax
//        List<Integer> list = gson.fromJson(fileReader, List<Integer>.class)

        // Unchecked assignment warning
//        List<Integer> list = gson.fromJson(fileReader, List.class);

        // Use TypeToken to get real type
        Type collectionType = new TypeToken<List<Integer>>() {}.getType();
        List<Integer> list = gson.fromJson(fileReader, collectionType);

        System.out.println(list);
    }
}
