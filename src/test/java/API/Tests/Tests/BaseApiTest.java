package API.Tests.Tests;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected static RequestSpecification requestSpec;

    @BeforeSuite
    public void beforeSuite() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        requestSpec = given().contentType("application/json");
    }
}
