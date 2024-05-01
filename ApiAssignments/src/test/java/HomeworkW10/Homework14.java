package HomeworkW10;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class Homework14 {

    @Test
    public void homework14() {
        Response response = RestAssured.get("https://dummy.restapiexample.com/api/v1/employees");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        response.then()
                .statusCode(200);

        List<Integer> employeesIdsList = jsonPath.getList("data.findAll{it}.id");
        System.out.println("employeesIdsList = " + employeesIdsList);
        assertEquals(employeesIdsList.size(), 24);

        List<String> employeesNamesList = jsonPath.getList("data.findAll{it}.employee_name");
        System.out.println("employeesNamesList = " + employeesNamesList);
        assertTrue(employeesNamesList.contains("Tiger Nixon"));
        assertTrue(employeesNamesList.contains("Garrett Winters"));


        Integer maximumEmployeeAge = jsonPath.getInt("data.max{it.employee_age}.employee_age");
        System.out.println("maximumEmployeeAge = " + maximumEmployeeAge);
        assertEquals(maximumEmployeeAge,66);

        String minimumEmployeeAgeName = jsonPath.getString("data.min{it.employee_age}.employee_name");
        System.out.println("minimumEmployeeAgeName = " + minimumEmployeeAgeName);
        assertEquals(minimumEmployeeAgeName,"Tatyana Fitzpatrick");

        Integer totalSalaryAllEmployee = jsonPath.getInt("data.sum{it.employee_salary}");
        System.out.println("totalSalaryAllEmployee = " + totalSalaryAllEmployee);
        assertEquals(totalSalaryAllEmployee,6644770);
    }
}

/*
    Given
        https://dummy.restapiexample.com/api/v1/employees ☑️
    When
        User sends Get Request to the Url ☑️
    Then
        Status code is 200 ☑️
    And
        There are 24 employees ☑️
    And
        "Tiger Nixon" and "Garrett Winters" are among the employees ☑️
    And
        The greatest age is 66 ☑️
    And
        The name of the lowest age is "Tatyana Fitzpatrick" ☑️
    And
        Total salary of all employees is 6,644,770
 */
/*
{
    "status": "success",
    "data": [
        {
            "id": 1,
            "employee_name": "Tiger Nixon",
            "employee_salary": 320800,
            "employee_age": 61,
            "profile_image": ""
        },

 */