package HomeworkW9;

import base_urls.PetStoreUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Homework09 extends PetStoreUrl {

    @Test
    public void homework09() {

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("id", 2040);
        expectedData.put("username", "Mary");
        expectedData.put("firstName", "Mariyah");
        expectedData.put("lastName", "Saeed");
        expectedData.put("email", "mary@email.com");
        expectedData.put("password", "P@sSw0rd1");
        expectedData.put("phone", "0591234567");
        expectedData.put("userStatus", 0);

        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).post("v2/user");
        response.prettyPrint();

        assertEquals(response.statusCode(), 200);


    }

}
/* HOMEWORK 09 ✅
Write an automation test that will create a 'user'
using the "https://petstore.swagger.io/" document
*/

