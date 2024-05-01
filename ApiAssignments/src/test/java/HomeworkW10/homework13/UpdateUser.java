package HomeworkW10.homework13;

import base_urls.PetStoreUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetStoreUserPojo;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UpdateUser extends PetStoreUrl {
    @Test
    void updateUserRequest() {
        spec.pathParams("first", "v2", "second", "user", "third", "usernameTest");

        PetStoreUserPojo expectedData = new PetStoreUserPojo(
                333,
                "usernameTest",
                "firstnameTest",
                "UpdatedLastnameTest",
                "testemail@email.com",
                "UpdatedP@ssword",
                "9876543210",
                0);

        Response response = given(spec).body(expectedData).put("{first}/{second}/{third}");
        response.prettyPrint();


        response.then().statusCode(200);

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