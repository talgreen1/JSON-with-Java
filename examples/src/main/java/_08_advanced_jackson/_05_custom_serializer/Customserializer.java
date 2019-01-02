package _08_advanced_jackson._05_custom_serializer;

import _08_advanced_jackson._05_custom_serializer.model.Item;
import _08_advanced_jackson._05_custom_serializer.model.Item1;
import _08_advanced_jackson._05_custom_serializer.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class Customserializer {
    public static void main(String[] args) throws JsonProcessingException {
        defaultSerializer();
        customSerializerWithModule();
        customSerializerWithClassAnnotation();
    }

    private static void customSerializerWithClassAnnotation() throws JsonProcessingException {
        Item1 myItem = new Item1(1, "theItem", new User(2, "theUser"));
        String json = new ObjectMapper().writeValueAsString(myItem);

        System.out.println(json);
    }

    private static void customSerializerWithModule() throws JsonProcessingException {
        Item myItem = new Item(1, "theItem", new User(2, "theUser"));
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module = new SimpleModule();
        module.addSerializer(Item.class, new ItemSerializer());
        mapper.registerModule(module);

        String json = mapper.writeValueAsString(myItem);
        System.out.println(json);
    }

    private static void defaultSerializer() throws JsonProcessingException {
        Item myItem = new Item(1, "theItem", new User(2, "theUser"));
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(myItem);

        System.out.println(json);
    }
}
