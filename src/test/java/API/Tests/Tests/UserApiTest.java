package API.Tests.Tests;

import API.Tests.Models.UserRequest;
import API.Tests.Models.UserResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserApiTest extends BaseApiTest {

    @Test
    public void getUser() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .get("/users/3");

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void deleteUser() {
        Response response = given()
                .spec(requestSpec)
                .when()
                .delete("/users/4");

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void createPost() {
        UserRequest request = new UserRequest();
        request.setTitle("Aaa");
        request.setBody("Bbb");

        Response response = given()
                .spec(requestSpec)
                .body(request)
                .when()
                .post("/posts");

        Assert.assertEquals(response.getStatusCode(), 201);

        UserResponse userResponse = response.as(UserResponse.class);

        Assert.assertEquals(userResponse.getTitle(), "Aaa");
        Assert.assertEquals(userResponse.getBody(), "Bbb");
        Assert.assertNotNull(userResponse.getId());
    }

    @Test
    public void changeDataInPost() {
        UserRequest request = new UserRequest();
        request.setTitle("ABC");
        request.setBody("DEF");

        Response response = given()
                .spec(requestSpec)
                .body(request)
                .when()
                .put("/posts/5");

        Assert.assertEquals(response.getStatusCode(), 200);

        UserResponse userResponse = response.as(UserResponse.class);

        Assert.assertEquals(userResponse.getTitle(), "ABC");
        Assert.assertEquals(userResponse.getBody(), "DEF");
    }
}
