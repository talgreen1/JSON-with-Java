package _04_serialization_and_deserialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Serialization {
    public static void main(String[] args) throws IOException {
        primitivesSerialization();
        arraySerialization();
        collectionSerialization();
        objectSerialization();
        writeToFile();

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

    private static void arraySerialization() {
        Gson gson = new Gson();

        String[] names = {"Gidi", "Yoni", "Dani"};
        String json = gson.toJson(names);

        System.out.println(json);
    }


    private static void collectionSerialization() {
        Gson gson = new Gson();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        String json = gson.toJson(numbers);
        System.out.println(json);
    }

    private static void writeToFile() throws IOException {
        Gson gson = new Gson();

        Person person = new Person(1, "Gidi", 50.5, new String[]{"White", "Red"}, null);

        try (FileWriter writer = new FileWriter("c:/temp/person.json");) {
            gson.toJson(person, writer);
        }
    }

}
