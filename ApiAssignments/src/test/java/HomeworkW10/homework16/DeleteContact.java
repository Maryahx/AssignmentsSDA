package HomeworkW10.homework16;

import base_urls.AuthDocumenterBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static HomeworkW10.homework16.AddContact.contactId;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DeleteContact extends AuthDocumenterBaseUrl {
    @Test
    public void deleteContactTest() {
        spec.pathParams("first", "contacts", "second", contactId);

        Response response = given(spec).delete("{first}/{second}");
        response.prettyPrint();

        assertEquals(response.statusCode(), 200);
        assertTrue(response.getBody().asString().contains("Contact deleted"));
    }

    @Test
    public void readContactNegativeTest() {
        spec.pathParams("first", "contacts", "second", contactId);

        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();


        assertEquals(response.getStatusCode(), 404);
        assertTrue(response.getBody().asString().isEmpty());
    }
}


//Write an automation test that will add a 'contact' then read, update and delete the created contact
//then negative assert the deleted contact using the "https://documenter.getpostman.com/view/4012288/TzK2bEa8" document.