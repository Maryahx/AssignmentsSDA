package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken() {


        Map<String, String> bodyMap = new HashMap<>();

        bodyMap.put("email", "maria@testemail.com");
        bodyMap.put("password", "testPass");


        Response response = given()
                .body(bodyMap)
                .contentType(ContentType.JSON)
                .post("https://thinking-tester-contact-list.herokuapp.com/users/login");

        return response.jsonPath().getString("token");
    }


}
