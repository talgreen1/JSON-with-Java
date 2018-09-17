package _04_serialization_and_deserialization;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SerializationAndDeserialization {
    public static void main(String[] args) throws FileNotFoundException {
//        primitivesSerialization();
//        primitivesDeserialization();
//        objectSerialization();
//        objectDeserialization();
//        collectionSerialization();
        collectionDeserialization();
    }

    private static void primitivesSerialization() {
        // Serialization = From instance to JSON
        Gson gson = new Gson();
        String res;
        res = gson.toJson(1);            // ==> 1
        System.out.println(res);

        res = gson.toJson("abcd");       // ==> "abcd"
        System.out.println(res);

        res = gson.toJson(new Long(10)); // ==> 10
        System.out.println(res);

        int[] values = {1};
        res = gson.toJson(values);       // ==> [1]
        System.out.println(res);
    }

    private static void primitivesDeserialization() throws FileNotFoundException {
        // Deserialization - From JSON to instance
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

        stringArrayResult = gson.fromJson(new FileReader("./src/main/resources/jsonFiles/names.json"), String[].class);
        System.out.println(Arrays.toString(stringArrayResult));

    }

    private static void objectSerialization() {
//        Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Person person = new Person(1, "Gidi", 50.5, new String[]{"White", "Red"}, null);
        String json = gson.toJson(person);

        System.out.println(json);

        person = new Person(1, "Alon", 60, new String[]{"Blue"}, "Description....");
        json = gson.toJson(person);

        System.out.println(json);
    }

    private static void objectDeserialization() throws FileNotFoundException {
        Gson gson = new Gson();

        Person person = gson.fromJson(new FileReader("./src/main/resources/jsonFiles/person1_all.json"), Person.class);
        System.out.println(person);

        person = gson.fromJson(new FileReader("./src/main/resources/jsonFiles/person2_no_colors_wrong_order.json"), Person.class);
        System.out.println(person);

        person = gson.fromJson(new FileReader("./src/main/resources/jsonFiles/person3_extra_field.json"), Person.class);
        System.out.println(person);


    }

    private static void collectionSerialization() {
        Gson gson = new Gson();
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        String json = gson.toJson(numbers);
        System.out.println(json);
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
