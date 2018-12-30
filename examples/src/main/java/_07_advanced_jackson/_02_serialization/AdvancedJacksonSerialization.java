package _07_advanced_jackson._02_serialization;


import _07_advanced_jackson._02_serialization.models.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class AdvancedJacksonSerialization {
    public static void main(String[] args) throws IOException {
        jsonPropertyAnnotation();
        ignoringFields();

        prettyPrint();
        jsonPropertyOrderAnnotation();
        jsonRawValueAnnotation();
        jsonRootName();
    }

    private static void ignoringFields() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json;

        // Use the @JsonIgnore annotation to ignore specific field
        // Use the @JsonIgnoreProperties annotation to ignore specific fields at the class level
        Person10 person = new Person10(1, "Yoni", 50.5);
        json = mapper.writeValueAsString(person);

        System.out.println("person: " + json);
    }

    private static void jsonPropertyAnnotation() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json;

        // Using the @JsonProperty annotation to to change field name
        Person9 person = new Person9(1, "Yoni", 50.5);
        json = mapper.writeValueAsString(person);

        System.out.println("person: " + json);
    }

    private static void prettyPrint() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        Person p = new Person(1, "Yoni", 50.5);

        // By default - the json is 1 line
        json = mapper.writeValueAsString(p);
        System.out.println("p: " + json);

        // You can add indentations by using pretty print

        // Option 1: Change the current mapper:
        json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(p);
        System.out.println("Pretty: \n" + json);

        // Option 2: Create mapper with pretty feature enabled - syntax 1
        mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        json = mapper.writeValueAsString(p);
        System.out.println("Pretty: \n" + json);

        // Option 2: Create mapper with pretty feature enabled - syntax 2
        mapper = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, true);
        json = mapper.writeValueAsString(p);
        System.out.println("Pretty: \n" + json);


    }

    private static void jsonRootName() throws JsonProcessingException {
        // You can enable the WRAP_ROOT_VALUE feature to add the class name as root
        ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        String json;

        Person p = new Person(1, "tal\"", 50.5);
        json = mapper.writeValueAsString(p);

        System.out.println("p: " + json);

        // Change the root name by using the annotation @jsonRootName
        Person8 p8 = new Person8(1, "tal\"", 50.5);
        json = mapper.writeValueAsString(p8);

        System.out.println("p8: " + json);

        // You can change the mapper later on:
        mapper.writer(SerializationFeature.WRAP_ROOT_VALUE).writeValueAsString(p8);

    }

    private static void jsonRawValueAnnotation() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json;

        Person p = new Person(1, "tal\"", 50.5);
        json = mapper.writeValueAsString(p);

        System.out.println("p: " + json);

        // Use the @jsonRawValueAnnotation to skip escaping and and do not add " "
        Person7 p7 = new Person7(1, "tal\"", 50.5);
        json = mapper.writeValueAsString(p7);

        System.out.println("p7: " + json);
    }

    private static void jsonPropertyOrderAnnotation() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json;

        // By default: Jackson does not guaranteed any specific order
        Person3 p3 = new Person3(1, "Yoni", 50.5);
        json = mapper.writeValueAsString(p3);

        System.out.println("p3: " + json);

        // We can use the @JacksonPropertyOrder to set specific order for some fields and order type for others //TODO: Understand

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
}
