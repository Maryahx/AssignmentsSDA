package Homework;

import base_urls.ReqresUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class Homework08 extends ReqresUrl {
    @Test
    public void homework08() {
        //Set url
        spec.pathParams("first", "users");

        //Set expected data
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("name", "morpheus");
        expectedData.put("job", "leader");

        //Send POST request and print response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Assertion
        response.then()
                .statusCode(201)
                .body("id", notNullValue(),
                "createdAt", notNullValue());
    }
    }


  /* HOMEWORK 08 ✅
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */