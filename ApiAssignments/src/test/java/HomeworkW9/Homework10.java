package HomeworkW9;

import base_urls.PetStoreUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class Homework10 extends PetStoreUrl {

    @Test
    public void homework10() {
        Response response = given(spec).get("v2/pet/findByStatus?status=available");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        List<String> availablePetsList = jsonPath.getList("findAll{it.status}");
        System.out.println("Number of available pets = " + availablePetsList.size());
        assertTrue(availablePetsList.size() > 100);

    }

}

/**
 * HOMEWORK 10 ✅
 * Using the https://petstore.swagger.io/ document,
 * write an automation test that finds the number of "pets" with the status "available"
 * and asserts that there are more than 100.
 */