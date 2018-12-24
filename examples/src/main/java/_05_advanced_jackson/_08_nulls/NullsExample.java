package _05_advanced_jackson._08_nulls;

import _05_advanced_jackson._08_nulls.model.Person;
import _05_advanced_jackson._08_nulls.model.Person1;
import _05_advanced_jackson._08_nulls.model.Person2;
import _05_advanced_jackson._08_nulls.model.Person3;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

public class NullsExample {
    public static void main(String[] args) throws IOException {
//        serializeEmptyList();
//        serializeNullList();

//        deserializeNull();
//        deserializeEmptyList();
//        deserializeNullAsEmptyPropertyLevel();
        deserializeNullAsEmptyFinalNoSetter();
//        deserializeNullAsEmptySpecificType();


    }

    private static void deserializeNullAsEmptyFinalNoSetter() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"id\":1,\"name\":\"Gidi\",\"childrens\":null}";// {"id":1,"name":"Gidi","childrens":null}

        Person3 person = mapper.readValue(json, Person3.class);

        System.out.println(person);
    }

    private static void deserializeNullAsEmptySpecificType() throws IOException {
        //https://medium.com/@cowtowncoder/jackson-2-9-features-b2a19029e9ff
        //https://stackoverflow.com/questions/32398885/jackson-deserializer-change-null-collection-to-empty-one/51442640#51442640
        //https://github.com/FasterXML/jackson-databind/issues/1402

        ObjectMapper mapper = new ObjectMapper();

        // {"id":1,"name":"Gidi","childrensList":null, "cars":null, "someMap":null}
        String json = "{\"id\":1,\"name\":null,\"childrensList\":null, \"cars\":null, \"someMap\":null}";

        // All JSON nulls will be serialized to null
        Person2 person = mapper.readValue(json, Person2.class);
        System.out.println(person);


        // Change all nulls to empty collection
        mapper  = mapper.setDefaultSetterInfo(JsonSetter.Value.forValueNulls(Nulls.AS_EMPTY));

        person = mapper.readValue(json, Person2.class);
        System.out.println(person);

        // Change only specific types to empty
    }

    private static void deserializeNullAsEmptyPropertyLevel() throws IOException {
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
