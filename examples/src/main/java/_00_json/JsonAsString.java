package _00_json;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JsonAsString {

    public static void main(String[] args) throws IOException {
        String jsonString = "{\"name\": \"John\",\"age\": 30,\"cars\": [\"Ford\", \"BMW\", \"Fiat\"]}";

        assertThat(jsonString).containsIgnoringCase("fiat");

        URL url = Resources.getResource("jsonFiles/personWithCars.json");
        jsonString = Resources.toString(url, Charsets.UTF_8);

        assertThat(jsonString).containsIgnoringCase("bmw");
    }

}
