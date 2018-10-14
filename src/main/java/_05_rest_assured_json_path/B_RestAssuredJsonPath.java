package _05_rest_assured_json_path;

import io.restassured.path.json.JsonPath;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static io.restassured.RestAssured.when;

/**
 * Rest Assured uses Groovy's GPath syntax: http://groovy-lang.org/processing-xml.html#_gpath
 *
 */
public class B_RestAssuredJsonPath extends RestAssuredBase{

    public static void main(String[] args) throws FileNotFoundException {

        JsonPath jsonPath = new JsonPath(new FileReader("./src/main/resources/jsonFiles/personWithCarsInnerObject.json"));

        System.out.println(jsonPath.get("name"));
        System.out.println(jsonPath.get("cars"));
        System.out.println(jsonPath.get("cars[2]"));
        System.out.println(jsonPath.get("address"));
        System.out.println(jsonPath.get("address.street"));



    }

}
