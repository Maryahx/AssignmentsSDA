package Homework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Homework03 {
    Response response;

    @Test
    public void homework03() {
        String url = "https://reqres.in/api/users/3";
        response = RestAssured.get(url);
        response.prettyPrint();

        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .statusLine("HTTP/1.1 200 OK");
    }

}


// HOMEWORK 03 ✅
    /*
        Given
            https://reqres.in/api/users/3 ☑️
        When
            User sends a GET Request to the url ☑️
        Then
            HTTP Status Code should be 200 ☑️
        And
            Content Type should be JSON ☑️
        And
            Status Line should be HTTP/1.1 200 OK ☑️
     */


