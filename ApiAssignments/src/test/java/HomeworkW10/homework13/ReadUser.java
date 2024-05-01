package HomeworkW10.homework13;

import base_urls.PetStoreUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class ReadUser extends PetStoreUrl {
    @Test
    void readUserRequest() {
        spec.pathParams("first", "v2", "second", "user", "third", "usernameTest");


        Response response = given(spec).get("{first}/{second}/{third}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        assertEquals(response.statusCode(), 200);
        assertEquals(jsonPath.getInt("id"), 333);
        assertEquals(jsonPath.getString("username"), "usernameTest");
        assertEquals(jsonPath.getString("firstName"), "firstnameTest");
        assertEquals(jsonPath.getString("lastName"), "lastnameTest");
        assertEquals(jsonPath.getString("email"), "testemail@email.com");
        assertEquals(jsonPath.getString("password"), "Pa$sword");
        assertEquals(jsonPath.getString("phone"), "9876543210");
        assertEquals(jsonPath.getInt("userStatus"), 0);
    }
}

//Write an automation test that will create a 'user' then read, update and delete the created user
// using the "https://petstore.swagger.io/" document.
// (Create a classes for each request.)

/*
{
  "id": 0,
  "username": "string",
  "firstName": "string",
  "lastName": "string",
  "email": "string",
  "password": "string",
  "phone": "string",
  "userStatus": 0
}
 */