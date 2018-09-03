package _04_serialization_and_deserialization;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class SerializationAndDeserialization {
    public static void main(String[] args) throws FileNotFoundException {
//        primitivesSerialization();
        primitivesDeserialization();
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

        int[] values = { 1 };
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

}
