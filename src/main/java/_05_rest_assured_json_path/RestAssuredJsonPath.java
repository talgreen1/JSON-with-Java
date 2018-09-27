package _05_rest_assured_json_path;

import _06_rest_assured_extract_json_body.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.RestAssured.when;
import static io.restassured.specification.ProxySpecification.host;

/**
 * http://www.jsonschema2pojo.org/
 */
public class RestAssuredJsonPath {

    public static void main(String[] args) {
        RestAssured.proxy = host("one.proxy.att.com").withPort(8888);

        extractJsonPath();



    }

    private static void extractJsonPath() {
        // JSON with simple object - extract primitives
        JsonPath jsonPath = when()
                .get("http://jsonplaceholder.typicode.com/posts/1")
                .jsonPath();

        String stringVal;
        int intVal;
        double doubleVal;

        stringVal = jsonPath.get("title");
        System.out.println(stringVal);

        stringVal = jsonPath.getString("title");
        System.out.println(stringVal);

        intVal = jsonPath.get("id");
        System.out.println(intVal);

        doubleVal = jsonPath.getDouble("id");
        System.out.println(doubleVal);


//                = jsonPath.getString("userId");
//        System.out.println(res);
//
//        stringjsonPath.get("title");
    }
}
