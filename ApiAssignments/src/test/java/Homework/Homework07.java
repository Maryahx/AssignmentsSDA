package Homework;

import base_urls.ReqresUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Homework07 extends ReqresUrl {

    @Test
    public void homework06() {
        //Given https://reqres.in/api/unknown/
        //When I send GET Request to the URL
        spec.pathParams("first", "unknown");
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Then
        //1)Status code is 200
        response
                .then()
                .statusCode(200);

        //2)Print all pantone_values
        JsonPath jsonPath = response.jsonPath();
        List<Object> pantoneValuesList = jsonPath.getList("data.pantone_value");
        System.out.println("pantoneValuesList = " + pantoneValuesList);


        //3)Print all ids greater than 3 on the console,
        //Assert that there are 3 ids greater than 3
        List<Integer> idList = jsonPath.getList("data.id");
        int idsGreaterThan3 = 0;
        System.out.println("Ids Greater than 3 = ");
        for (int id : idList) {
            if (id > 3) {
                System.out.println("id = " + id);
                idsGreaterThan3++;
            }
        }
        assertEquals(idsGreaterThan3, 3);


        //4)Print all names whose ids are less than 3 on the console,
        //Assert that the number of names whose ids are less than 3 is 2
        List<String> nameList = jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println("nameList whose ids less than 3 = " + nameList);
        assertEquals(nameList.size(), 2);


    }
}

/**
 * HOMEWORK 07
 * Given
    https://reqres.in/api/unknown/ ☑️
 * When
    I send GET Request to the URL ☑️
 * Then
    1)Status code is 200 ☑️
    2)Print all pantone_values ☑️
    3)Print all ids greater than 3 on the console,
    Assert that there are 3 ids greater than 3 ☑️
    4)Print all names whose ids are less than 3 on the console,
    Assert that the number of names whose ids are less than 3 is 2 ☑️
 **/