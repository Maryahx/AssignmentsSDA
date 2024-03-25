package testng;

/*          [Assignment 3/5] 🧪
Add three different log messages for the task below:
go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!" */

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assgn3_5Test extends TestBase {

    //[📝] Logger messages are configured in ActionsBot.
    // Thus, more than 3 log msgs will be found in output,
    // but I added 3 here to satisfy the requirements of the assignment
    @Test
    public void softAssertInvalidLogin() {
        logger.info("- Performing assignment 3/5 test case");
        bot.navigate("https://practicetestautomation.com/practice-test-login/");

        logger.info("- Logging in with invalid credentials");
        bot.type(By.id("username"), "student");
        bot.type(By.id("password"), "incorrectPassword");
        bot.click(By.id("submit"));


        logger.info("- Performing assertion for error message");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(By.id("error")).isDisplayed());
        softAssert.assertEquals(driver.findElement(By.id("error")).getText(), "Your password is invalid!");
    }
}
