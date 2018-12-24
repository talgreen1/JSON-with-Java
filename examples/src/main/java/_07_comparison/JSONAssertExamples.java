package _07_comparison;

import _06_rest_assured_json_path.RestAssuredBase;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONAssert;

import static io.restassured.RestAssured.when;

public class JSONAssertExamples extends RestAssuredBase {
    public static void main(String[] args) throws JSONException {
        assertSimpleJsonObject();
        assertJsonObjectWithArray();
    }

    private static void assertJsonObjectWithArray() throws JSONException {
        String JsonObjectWithArray = "{\"name\": \"John\",\"age\": 30,\"cars\": [\"Ford\",\"BMW\",\"Fiat\"]}";
        String JsonObjectWithArrayDifferentArrayOrder = "{\"name\": \"John\",\"age\": 30,\"cars\": [\"BMW\",\"Ford\",\"Fiat\"]}";

        /*--------------------------------------------------
        |  Strict mode = false
        |
        |  Allow array elements in any order
        *--------------------------------------------------*/
        System.out.println("Strict=false: Array elements in any order: Pass");
        JSONAssert.assertEquals(JsonObjectWithArray, JsonObjectWithArrayDifferentArrayOrder, false);

        /*--------------------------------------------------
        |  Strict mode = true
        |
        |  Array elements must be in order
        *--------------------------------------------------*/
        try {
            JSONAssert.assertEquals(JsonObjectWithArray, JsonObjectWithArrayDifferentArrayOrder, true);
        } catch (AssertionError e) {
            System.out.println("Strict=true: Array elements in any order: Fail:");
            System.out.println(e.getMessage());
        }
    }

    private static void assertSimpleJsonObject() throws JSONException {
        String actualJson = when()
                .get("http://jsonplaceholder.typicode.com/todos/1")
                .then()
                .extract().body().asString();
        String expectedJsonDifferetOrder = "{\"title\": \"delectus aut autem\",\"id\": 1,\"userId\": 1,\"completed\": false}";
        String expectedJsonLessFields = "{\"title\": \"delectus aut autem\",\"userId\": 1,\"completed\": false}";
        String expectedJsonMoreFields = "{\"title\": \"delectus aut autem\",\"userId\": 1,\"completed\": false, \"ExtraField\":\"Bla Bla\"}";

        System.out.println("The response JSON is: \n" + actualJson);

        /*--------------------------------------------------
        |  Strict mode = false
        |
        |  Allow expected JSON to contains less fields
        *--------------------------------------------------*/
        System.out.println("Strict=false: Asserting 2 equals JSON: Pass");
        JSONAssert.assertEquals(actualJson, actualJson, false);

        System.out.println("Strict=false: Expected JSON with different fields order: Pass");
        JSONAssert.assertEquals(expectedJsonDifferetOrder, actualJson, false);

        System.out.println("Strict=false: Expected JSON with less fields order: Pass");
        JSONAssert.assertEquals(expectedJsonLessFields, actualJson, false);

        try {
            JSONAssert.assertEquals(expectedJsonMoreFields, actualJson, false);
        } catch (AssertionError e) {
            System.out.println("Strict=false: Expected JSON with more fields order: Fail:");
            System.out.println(e.getMessage());
        }


        /*--------------------------------------------------
        |  Strict mode = true
        |
        |  Both actual & expected mush have the same fields
        *--------------------------------------------------*/
        System.out.println("Strict=true: Asserting 2 equals JSON: Pass");
        JSONAssert.assertEquals(actualJson, actualJson, true);

        System.out.println("Strict=true: Expected JSON with different fields order: Pass");
        JSONAssert.assertEquals(expectedJsonDifferetOrder, actualJson, true);


        try {
            JSONAssert.assertEquals(expectedJsonLessFields, actualJson, true);
        } catch (AssertionError e) {
            System.out.println("Strict=true: Expected JSON with less fields order: Fail:");
            System.out.println(e.getMessage());
        }

        try {
            JSONAssert.assertEquals(expectedJsonMoreFields, actualJson, true);
        } catch (AssertionError e) {
            System.out.println("Strict=true: Expected JSON with more fields order: Fail:");
            System.out.println(e.getMessage());
        }

    }
}
