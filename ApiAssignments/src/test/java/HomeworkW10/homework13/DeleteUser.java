package HomeworkW10.homework13;

import base_urls.PetStoreUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetStoreUserPojo;

import static io.restassured.RestAssured.given;

public class DeleteUser extends PetStoreUrl {
    @Test
    void deleteUserRequest()  {
        spec.pathParams("first","v2","second","user","third","usernameTest");



        Response response = given(spec).delete("{first}/{second}/{third}");
        response.prettyPrint();

        response.then()
                .statusCode(200);
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