package _05_rest_assured_json_path;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;

import static io.restassured.RestAssured.when;
import static io.restassured.specification.ProxySpecification.host;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

public class B_RestAssuredJsonPathAssertion {
    public static void main(String[] args) {
        RestAssured.proxy = host("PROXY").withPort(8888);

        when()
                .get("http://jsonplaceholder.typicode.com/users")
        .then()
                .body("name", Matchers.hasItems("Ervin Howell"))
                .body(".", hasSize(10))
                .body("address[1].zipcode", is("90566-7771"));
    }

}
