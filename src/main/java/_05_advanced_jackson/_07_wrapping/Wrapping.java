package _05_advanced_jackson._07_wrapping;

import _05_advanced_jackson._07_wrapping.model.Name;
import _05_advanced_jackson._07_wrapping.model.UnwrappedUser;
import _05_advanced_jackson._07_wrapping.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Wrapping {
    public static void main(String[] args) throws IOException {
//        noUnWrapping();
//        unwrapped();
        deserialize();
    }

    private static void deserialize() throws IOException {
        String json = "{\"id\":1,\"firstName\":\"Yoni\",\"lastName\":\"Rechter\"}"; // {"id":1,"firstName":"Yoni","lastName":"Rechter"}
        ObjectMapper mapper = new ObjectMapper();

        UnwrappedUser user = mapper.readValue(json, UnwrappedUser.class);

        System.out.println(user);

    }

    private static void unwrapped() throws JsonProcessingException {
        UnwrappedUser user = new UnwrappedUser(1, new Name("Yoni","Rechter"));
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(user);

        System.out.println(json);
    }

    private static void noUnWrapping() throws JsonProcessingException {
        User user = new User(1, new Name("Yoni","Rechter"));
        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(user);

        System.out.println(json);
    }
}
