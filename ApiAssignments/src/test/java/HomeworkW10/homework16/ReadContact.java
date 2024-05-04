package HomeworkW10.homework16;

import base_urls.AuthDocumenterBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.ContactPojo;

import static HomeworkW10.homework16.AddContact.contactId;
import static HomeworkW10.homework16.AddContact.strJson;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


public class ReadContact extends AuthDocumenterBaseUrl {

    @Test
    public void readContact() throws JsonProcessingException {

        spec.pathParams("first", "contacts", "second", contactId);

        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        ContactPojo expectedData = new ObjectMapper().readValue(strJson, ContactPojo.class);
        System.out.println("expectedData = " + expectedData);

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
}


//Write an automation test that will add a 'contact' then read, update and delete the created contact
//then negative assert the deleted contact using the "https://documenter.getpostman.com/view/4012288/TzK2bEa8" document.