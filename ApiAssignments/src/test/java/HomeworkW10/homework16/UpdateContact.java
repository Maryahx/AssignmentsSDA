package HomeworkW10.homework16;

import base_urls.AuthDocumenterBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactPojo;

import java.util.HashMap;
import java.util.Map;

import static HomeworkW10.homework16.AddContact.contactId;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UpdateContact extends AuthDocumenterBaseUrl {

    Response response;
    ContactPojo actualData;

    @Test
    public void updateContactPutRequestTest() throws JsonProcessingException {
        spec.pathParams("first", "contacts", "second", contactId);


        String updateStrJson = """
                {
                    "firstName": "Mariyah",
                    "lastName": "Croft",
                    "birthdate": "1999-02-02",
                    "email": "marycroft@fake.com",
                    "phone": "1000000001",
                    "street1": "1 Main St.",
                    "street2": "Apartment D",
                    "city": "UpdatedCity",
                    "stateProvince": "EP",
                    "postalCode": "54321",
                    "country": "KSA"
                }
                """;

        ContactPojo expectedData = new ObjectMapper().readValue(updateStrJson, ContactPojo.class);
        System.out.println("expectedData = " + expectedData);

        response = given(spec).body(expectedData).put("{first}/{second}");
        response.prettyPrint();

        ContactPojo actualData = response.as(ContactPojo.class);
        System.out.println("actualData = " + actualData);


        assertEquals(response.statusCode(), 200);
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

    @Test
    public void updateContactPatchRequestTest() throws JsonProcessingException {
        spec.pathParams("first", "contacts", "second", contactId);


        Map<String, Object> expectedData = new HashMap<>();

        expectedData.put("firstName", "UpdatedMariyah");
        expectedData.put("lastName", "UpdatedCroft");
        System.out.println("expectedData = " + expectedData);

        response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();

        actualData = response.as(ContactPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getFirstName(), expectedData.get("firstName"));
        assertEquals(actualData.getLastName(), expectedData.get("lastName"));

    }
}


//Write an automation test that will add a 'contact' then read, update and delete the created contact
//then negative assert the deleted contact using the "https://documenter.getpostman.com/view/4012288/TzK2bEa8" document.