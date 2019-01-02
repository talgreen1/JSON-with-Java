package _05_assertions;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.junit.Assert;

import java.io.IOException;
import java.net.URL;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SuppressWarnings("Duplicates")
public class Assertions {
    public static void main(String[] args) throws IOException {
        basicAssertions();
        jsonAsStringAssertion();
    }

    private static void basicAssertions() {
        int num = 10;
        // We want to assert that num value is 10
        // using plain Java
        if (num != 10) {
            throw new AssertionError("Value of num is " + num + " and should be 10");
        }
        // Using JUnit assert
        Assert.assertEquals(num, 10);
        Assert.assertEquals("Asserting num", num, 10);

        // Using AssertJ
        assertThat(num).isEqualTo(10);
        assertThat(num).as("Asserting value of num").isEqualTo(10);

    }

    private static void jsonAsStringAssertion() throws IOException {
        String jsonString = "{\"name\": \"John\",\"age\": 30,\"cars\": [\"Ford\", \"BMW\", \"Fiat\"]}";

        assertThat(jsonString).containsIgnoringCase("fiat");

        URL url = Resources.getResource("jsonFiles/personWithCars.json");
        jsonString = Resources.toString(url, Charsets.UTF_8);

        assertThat(jsonString).containsIgnoringCase("bmw");
    }
}
