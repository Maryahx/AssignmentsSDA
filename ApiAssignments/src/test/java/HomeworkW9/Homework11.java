package HomeworkW9;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class Homework11 {


    @Test
    public void homework11() {
        Response response = RestAssured.get("https://automationexercise.com/api/productsList");

        JsonPath jsonPath = response.jsonPath();
        jsonPath.prettyPrint();

        assertEquals(response.statusCode(), 200);

        List<String> womenProductList = jsonPath.getList("products.findAll{it.category.usertype.usertype=='Women'}.name");
        System.out.println("womenProductList = " + womenProductList);
        assertEquals(womenProductList.size(), 12);
    }
}


/* HOMEWORK 11 ✅
    Given
        https://automationexercise.com/api/productsList
    When
        User sends a GET request
    Then
        Assert that the number of "Women" user type is 12

    Note: Print using JsonPath: response.jsonPath().prettyPrint();

*/