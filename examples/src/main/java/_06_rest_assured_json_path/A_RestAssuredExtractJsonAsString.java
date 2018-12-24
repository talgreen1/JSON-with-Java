package _06_rest_assured_json_path;

import static io.restassured.RestAssured.when;

/**
 * Rest Assured uses Groovy's GPath syntax: http://groovy-lang.org/processing-xml.html#_gpath
 *
 */
public class A_RestAssuredExtractJsonAsString extends RestAssuredBase{

    public static void main(String[] args) {

        String jsonBody =   when()
                                .get("http://jsonplaceholder.typicode.com/users")
                            .then()
                                .extract().body().asString();

        System.out.println("The JSON body is:\n" + jsonBody);

    }

}
