package testng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*      [Assignment 2/5] 🧪
Go to URL: https://opensource-demo.orangehrmlive.com/
Login with negative credentials by Data Provider.
Then assert that ‘’Invalid credentials’’ is displayed.
Run it parallel with 3 threads (
Generate Allure report
 */


public class Assgn2_5Test extends TestBase {

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"admin*", "admin123"},
                {"admin12", "123"},
                {"Admin1", "***00**"},
                {"test", "123"},
                {"user", "369"},
        };
    }

    @Test(dataProvider = "getData")
    public void negativeTestLogin(String username, String password) {
        bot.navigate("https://opensource-demo.orangehrmlive.com/");

        bot.type(By.name("username"), username);
        bot.type(By.name("password"), password);
        bot.click(By.tagName("button"));

        wait.until(f -> {
            driver.findElement(By.xpath("//div[contains(@class, 'oxd-alert-content--error')]"));
            return true;
        });

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class, 'oxd-alert-content--error')]")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class, 'oxd-alert-content--error')]")).getText(), "Invalid credentials");
    }

    //📜 Allure report exist under 📁 target/allure-report directory

}


