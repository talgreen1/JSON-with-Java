package _00_json;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

/**
 * Edit the json file "jsonFiles/exe_01_json_file.json" to hold the following information:
 *
 * A person have the following attribute:
 * firstName, lastName, age and array of addresses.
 * Address is an object with the following attributes:
 * streetName, streenNumber, city, state.
 *
 * Create a JSON file to represent the following person:
 * Peter Parker, age 18. Addresses:
 * 1: Ingram Street #20, New York City, New York
 * 2: Fifth ave., #175, New York City, New York
 */
public class EXE_01_JSON {

    @Test
    public void exe_01_create_json_test() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = Resources.getResource("jsonFiles/exe_01_json_file.json");

        String json = mapper.readTree(url).toString();

        assertThatJson(json).isObject();
        assertThatJson(json).node("firstName").isEqualTo("Peter");
        assertThatJson(json).node("lastName").isEqualTo("Parker");
        assertThatJson(json).node("age").isEqualTo(18);

        assertThatJson(json).node("addresses").isArray().hasSize(2);

        assertThatJson(json).node("addresses[0].streetName").isEqualTo("Ingram Street");
        assertThatJson(json).node("addresses[0].streetNumber").isEqualTo(20);
        assertThatJson(json).node("addresses[0].city").isEqualTo("New York City");
        assertThatJson(json).node("addresses[0].state").isEqualTo("New York");

        assertThatJson(json).node("addresses[1].streetName").isEqualTo("Fifth ave.");
        assertThatJson(json).node("addresses[1].streetNumber").isEqualTo(175);
        assertThatJson(json).node("addresses[1].city").isEqualTo("New York City");
        assertThatJson(json).node("addresses[1].state").isEqualTo("New York");


    }
}
