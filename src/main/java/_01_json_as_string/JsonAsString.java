package _01_json_as_string;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JsonAsString {

    public static void main(String[] args) throws IOException {
        String jsonString = "{\"name\": \"John\",\"age\": 30,\"cars\": [\"Ford\", \"BMW\", \"Fiat\"]}";

        assertThat(jsonString).containsIgnoringCase("fiat");

        jsonString = new String (Files.readAllBytes(Paths.get("./src/main/resources/jsonFiles/personWithCars.json")));

        assertThat(jsonString).containsIgnoringCase("bmw");
    }

}
