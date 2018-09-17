package _05_rest_assured_json_path;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.path.json.JsonPath;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.hasItems;

/**
 * http://www.jsonschema2pojo.org/
 */
public class RestAssuredJsonPath {

    public static void main(String[] args) {
        String json = when()
                .get("http://jsonplaceholder.typicode.com/users")
                .then()
                .extract().body().asString();

        System.out.println(json);


        Gson gson = new Gson();

        Type listOfPersonType = new TypeToken<List<Person>>() {}.getType();

        List<Person> persons = gson.fromJson(json, listOfPersonType);


        System.out.println(persons.size());
        System.out.println(persons.get(1).getAddress().getCity());


    }
}
