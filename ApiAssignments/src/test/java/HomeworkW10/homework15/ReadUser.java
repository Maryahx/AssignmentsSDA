package HomeworkW10.homework15;

import base_urls.DocumenterBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.UserResponsePojo;

import static HomeworkW10.homework15.CreateUser.email;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class ReadUser extends DocumenterBaseUrl {

    @Test
    public void readUserTest() {
        spec.pathParams("first", "users", "second", "me");

        UserResponsePojo expectedData = new UserResponsePojo("mary", "last", null, null, email);
        System.out.println("expectedData = " + expectedData);


        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();


        UserResponsePojo actualData = response.as(UserResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getEmail(), actualData.getEmail());
    }

}
