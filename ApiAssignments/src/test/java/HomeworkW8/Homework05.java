package Homework;

import base_urls.ReqresUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Homework05 extends ReqresUrl {

    @Test
    public void homework05() {
        spec.pathParams("first", "users", "second", "23");
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        response
                .then()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server","cloudflare")
                .body(equalTo("{}"));


    }
}

 /* HOMEWORK 05 ✅
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */