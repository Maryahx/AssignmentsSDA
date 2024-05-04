package HomeworkW10.homework15;

import base_urls.DocumenterBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserPojo;
import pojos.UserResponsePojo;

import static HomeworkW10.homework15.CreateUser.email;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UpdateUser extends DocumenterBaseUrl {

    @Test
    public void updateUserTest() {
        spec.pathParams("first", "users", "second", "me");


        UserPojo expectedData = new UserPojo("Maria", "Sda", "UpdatedPassword001", email);
        System.out.println("expectedData = " + expectedData);


        Response response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();


        UserResponsePojo actualData = response.as(UserResponsePojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getFirstName(), expectedData.getFirstName());
        assertEquals(actualData.getLastName(), expectedData.getLastName());
        assertEquals(actualData.getEmail(), expectedData.getEmail());
    }
}
