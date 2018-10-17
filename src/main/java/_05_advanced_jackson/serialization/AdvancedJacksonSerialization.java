package _05_advanced_jackson.serialization;


import _05_advanced_jackson.serialization.models.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class AdvancedJacksonSerialization {
    public static void main(String[] args) throws IOException {
//        noAnnotations();
//        jsonGetterAnnotation();
        jsonPropertyOrder();
    }

    private static void jsonPropertyOrder() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json;

        // By default: Jackson does not guaranteed any specific order
        Person3 p3 = new Person3(1, "Yoni", 50.5);
        json = mapper.writeValueAsString(p3);

        System.out.println("p3: " + json);

        // We can use the @JacksonPropertyOrder to set specific order for some fields and order type for others

        // Set specific order to all fields
        Person4 p4 = new Person4(1, "Yoni", 50.5);
        json = mapper.writeValueAsString(p4);

        System.out.println("p4: " + json);

        // We can specify if the remaining fields are sorted alphabetically or not. If not - order is undefined.
        Person5 p5 = new Person5(1, "Yoni", 50.5);
        json = mapper.writeValueAsString(p5);

        System.out.println("p5: " + json);

        // Sorting all fields alphabetically
        Person6 p6 = new Person6(1, "Yoni", 50.5);
        json = mapper.writeValueAsString(p6);

        System.out.println("p6: " + json);

    }

    private static void jsonGetterAnnotation() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json;


        // Using the @JsonGetter annotation to mark a method as getter. We can add a value to change the field name
        Person2 p2 = new Person2(1, "Yoni", 50.5);
        json = mapper.writeValueAsString(p2);

        System.out.println("p2: " + json);
    }

    private static void noAnnotations() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        Person p = new Person(1, "Yoni", 50.5);

        // By default - every "get.." method will create a field in the JSON.
        // The field name is the method name without the 'get' prefix. First letter is lower case
        json = mapper.writeValueAsString(p);

        System.out.println("p: " + json);

        // Method without 'get' prefix are ignored
        Person1 p1 = new Person1(1, "Yoni", 50.5);

        json = mapper.writeValueAsString(p1);
        System.out.println("p1: " + json);
    }

}
