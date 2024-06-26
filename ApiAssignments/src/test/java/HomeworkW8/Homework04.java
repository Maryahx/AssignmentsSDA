package Homework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class Homework04 {


    @Test
    public void homework04() {
        String url = "https://reqres.in/api/users/2";
        Response response = RestAssured.get(url);
        response.prettyPrint();

        response
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("data.email", equalTo("janet.weaver@reqres.in"),
                        "data.first_name", equalTo("Janet"),
                        "data.last_name", equalTo("Weaver"),
                        "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
}


// HOMEWORK 04 ✅
 /*
       Given
           https://reqres.in/api/users/2 ☑️
       When
           User send GET Request to the URL ☑️
       Then
           HTTP Status Code should be 200☑️
       And
           Response format should be "application/json" ☑️
       And
           "email" is "janet.weaver@reqres.in",☑️
       And
           "first_name" is "Janet" ☑️
       And
           "last_name" is "Weaver" ☑️
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!" ☑️
    */


