package HomeworkW9;

import base_urls.PetStoreUrl;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pojos.PetStoreCategoryPojo;
import pojos.PetStorePojo;
import pojos.PetStoreTagsPojo;

import java.util.Collections;

import static io.restassured.RestAssured.given;

public class Homework12 extends PetStoreUrl {

    PetStoreCategoryPojo petCategory;
    PetStorePojo expectedData;
    PetStoreTagsPojo petTag;
    Response response;


    @BeforeMethod
    public void setPathParams() {
        spec.pathParams("first", "v2", "second", "pet");
    }


    @Test
    public void createPetRequestTest() {
        new PetStoreCategoryPojo(23, "Dog");
        petTag = new PetStoreTagsPojo(12, "tag1");

        expectedData = new PetStorePojo(839,
                petCategory,
                "Steve",
                Collections.singletonList("Image1"),
                Collections.singletonList(petTag),
                "available");

        //System.out.println("expectedData = " + expectedData);

        response = given(spec).body(expectedData).post("{first}/{second}");
        response.prettyPrint();

        response.then().statusCode(200);

    }

    @Test(dependsOnMethods = "createPetRequestTest")
    public void readPetRequestTest() {
        spec.pathParams("petId", 839);

        response = given(spec).get("{first}/{second}/{petId}");
        response.prettyPrint();

        response.then().statusCode(200);
    }

    @Test(dependsOnMethods = "readPetRequestTest")
    public void updatePetRequestTest() {
        petCategory = new PetStoreCategoryPojo(23, "Dog");
        petTag = new PetStoreTagsPojo(12, "White (Updated)");


        expectedData = new PetStorePojo(839,
                petCategory,
                "Steve",
                Collections.singletonList("Image (Updated)"),
                Collections.singletonList(petTag),
                "available");


        response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();

        response.then().statusCode(200);
    }


    @Test(dependsOnMethods = {"updatePetRequestTest"})
    public void deletePetRequestTest() {
        spec.pathParams("petId", 839);


        response = given(spec).delete("{first}/{second}/{petId}");
        response.prettyPrint();

        response.then().statusCode(200);
    }

}

/*  HOMEWORK 12 ✅
//Write an automation test that will create, read, update, delete a 'pet' using the "https://petstore.swagger.io/" document
(All actions must be done on same pet)
(Use Pojo)
 */

/*
{
    "id": 0,
    "category": {
        "id": 0,
        "name": "string"
    },
    "name": "doggie",
    "photoUrls": [
        "string"
    ],
    "tags": [
        {
            "id": 0,
            "name": "string"
        }
    ],
    "status": "available"
}
 */