package task1lambdatest;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lambdataset.Account;
import lambdataset.Register;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class StepDefinitions {
    WebDriver driver;
    Account account;
    Register register;

    @Given("The browser is open")
    public void the_browser_is_open() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("I navigate to LambdatestPlayground site")
    public void i_Navigate_To_Lambdataset_Playground_Site() {
        register = new Register(driver).goTo();
    }

    @And("I enter my registration info {string}, {string}, {string}, {string}, {string}")
    public void i_enter_my_registration_info(String firstname, String lastname, String email, String telephone, String password) {
        email = "maria" + System.currentTimeMillis() + "@email.com";
        account = new Register(driver).registerAccount(firstname, lastname, email, telephone, password);
    }

    @Then("I should be registered successfully")
    public void i_should_be_registered_successfully() {
        Assertions.assertEquals("Your Account Has Been Created!", account.readSuccessMessage());
    }

    @After()
    public void closeBrowser() {
        driver.close();
    }
}
