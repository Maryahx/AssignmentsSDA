package HomeworkW10.homework16;

import base_urls.AuthDocumenterBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class AddContact extends AuthDocumenterBaseUrl {

    public static String contactId;
    public static String strJson;


    @Test
    public void addContactTest() throws JsonProcessingException {
        spec.pathParams("first", "contacts");

        strJson = """
                {
                    "firstName": "Mariyah",
                    "lastName": "Croft",
                    "birthdate": "1999-01-01",
                    "email": "marycroft@fake.com",
                    "phone": "8005555555",
                    "street1": "1 Main St.",
                    "street2": "Apartment A",
                    "city": "Anytown",
                    "stateProvince": "EP",
                    "postalCode": "12345",
                    "country": "KSA"
                }""";

        ContactPojo expectedData = new ObjectMapper().readValue(strJson, ContactPojo.class);
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        ContactPojo actualData = response.as(ContactPojo.class);
        System.out.println("actualData = " + actualData);

        contactId = response.jsonPath().getString("_id");

        assertEquals(response.statusCode(), 201);
        assertEquals(actualData.getLastName(), expectedData.getLastName());
        assertEquals(actualData.getCountry(), expectedData.getCountry());
        assertEquals(actualData.getBirthdate(), expectedData.getBirthdate());
        assertEquals(actualData.getPhone(), expectedData.getPhone());
        assertEquals(actualData.getCity(), expectedData.getCity());
        assertEquals(actualData.getStateProvince(), expectedData.getStateProvince());
        assertEquals(actualData.getStreet1(), expectedData.getStreet1());
        assertEquals(actualData.getStreet2(), expectedData.getStreet2());
        assertEquals(actualData.getEmail(), expectedData.getEmail());
    }

}


//Write an automation test that will add a 'contact' then read, update and delete the created contact
//then negative assert the deleted contact using the "https://documenter.getpostman.com/view/4012288/TzK2bEa8" document.