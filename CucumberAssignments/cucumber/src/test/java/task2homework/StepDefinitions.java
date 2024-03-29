package task2homework;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class StepDefinitions {
    WebDriver driver;
    Wait<WebDriver> wait;


    @Given("user goes to the {string}")
    public void user_goes_to_the(String url) {
        driver = new ChromeDriver();
        driver.navigate().to(url);
    }

    @Then("user waits for {int} seconds")
    public void user_waits_for_seconds(Integer seconds) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    @Then("verifies that the page title contains the word {string}")
    public void verifies_that_the_page_title_contains_the_word(String title) {
        Assertions.assertTrue(driver.getTitle().contains(title));
    }

    @Then("closes the page")
    public void closes_the_page() {
        driver.quit();
    }
}
