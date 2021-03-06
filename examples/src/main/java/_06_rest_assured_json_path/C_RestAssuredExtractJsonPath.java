package _06_rest_assured_json_path;

import io.restassured.path.json.JsonPath;

import java.util.List;

import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Rest Assured uses Groovy's GPath syntax: http://groovy-lang.org/processing-xml.html#_gpath
 *
 */
public class C_RestAssuredExtractJsonPath extends RestAssuredBase{

    public static void main(String[] args) {
        extractJsonPath_Primitives();
        extractJsonPath_Arrays();
        extractJsonPath_InnerObject();
        extractJsonPath_ArrayAndInnerObject();
        extractJsonPath_Advanced();
    }

    private static void extractJsonPath_Advanced() {
        JsonPath jsonPath = when()
                .get("http://jsonplaceholder.typicode.com/users")
                .jsonPath();

        int sumOfIds;
        sumOfIds = jsonPath.get("id.sum()");
        System.out.println(sumOfIds);

        List<String> first3UsersNames;
        first3UsersNames = jsonPath.get("findAll{it.id<=3}.name");
        System.out.println(first3UsersNames);



    }

    private static void extractJsonPath_ArrayAndInnerObject() {
        JsonPath jsonPath = when()
                .get("http://jsonplaceholder.typicode.com/users")
                .jsonPath();

        String city;
        city = jsonPath.get("address[1].city");
        System.out.println(city);
    }

    private static void extractJsonPath_InnerObject() {
        JsonPath jsonPath = when()
                .get("http://jsonplaceholder.typicode.com/users/1")
                .jsonPath();

        String city;
        city = jsonPath.get("address.city");
        System.out.println(city);
    }

    private static void extractJsonPath_Arrays() {
        // JSON with simple object - extract primitives
        JsonPath jsonPath = when()
                .get("http://jsonplaceholder.typicode.com/posts")
                .jsonPath();

        List<String> titles;

        titles = jsonPath.get("title");
        assertThat(titles).hasSize(100);
        System.out.println("The titles are: \n" + titles);

        String title;
        title = jsonPath.get("title[0]");
        assertThat(title).isEqualTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        System.out.println(title);
    }

    private static void extractJsonPath_Primitives() {
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
    }
}
