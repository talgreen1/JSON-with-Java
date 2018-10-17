package _06_rest_assured_json_path;

import io.restassured.RestAssured;

import static io.restassured.specification.ProxySpecification.host;

public class RestAssuredBase {
    static {
        RestAssured.proxy = host("PROXY").withPort(8888);
    }
}
