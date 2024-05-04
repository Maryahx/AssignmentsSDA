package HomeworkW10.homework15;

import base_urls.AuthDocumenterBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class CreateUser extends AuthDocumenterBaseUrl {


    public static String email;
    public static String token;


    @Test
    void createUserTest() {
        email = "maria" + System.currentTimeMillis() + "@testemail.com";

        spec.pathParams("first", "users");


        UserPojo expectedData = new UserPojo("mary", "last", "testPass", email);


        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        assertEquals(response.statusCode(), 201);
        assertEquals(response.jsonPath().getString("user.firstName"), "mary");
        assertEquals(response.jsonPath().getString("user.lastName"), "last");
        assertEquals(response.jsonPath().getString("user.email"), email);

        token = response.jsonPath().getString("token");

    }

}


//Write an automation test that will create a 'user' then read, update and delete the created user
//using the "https://documenter.getpostman.com/view/4012288/TzK2bEa8" document.

