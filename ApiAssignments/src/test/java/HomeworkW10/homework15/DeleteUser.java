package HomeworkW10.homework15;

import base_urls.DocumenterBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DeleteUser extends DocumenterBaseUrl {
    @Test
    public void deleteUserTest() {
        spec.pathParams("first", "users", "second", "me");


        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        assertEquals(response.statusCode(), 200);
        assertTrue(response.asString().isEmpty());
    }
}
