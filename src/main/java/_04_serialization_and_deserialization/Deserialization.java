package _04_serialization_and_deserialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class Deserialization {
    public static void main(String[] args) throws FileNotFoundException {
//        primitivesDeserialization();
        objectDeserialization();
//        collectionDeserialization();
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


    private static void objectDeserialization() throws FileNotFoundException {
        Gson gson = new Gson();

        Person person = gson.fromJson(new FileReader("./src/main/resources/jsonFiles/person1_all.json"), Person.class);
        System.out.println(person);

        person = gson.fromJson(new FileReader("./src/main/resources/jsonFiles/person2_no_colors_wrong_order.json"), Person.class);
        System.out.println(person);

        person = gson.fromJson(new FileReader("./src/main/resources/jsonFiles/person3_extra_field.json"), Person.class);
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
