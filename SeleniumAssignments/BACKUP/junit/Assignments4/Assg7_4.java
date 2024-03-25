package junit.Assignments4;


import junit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;

/**
 * Assignment 7/4 Screenshots 📸
 */
// Go to amazon.com
// Take Full Page Screenshot.
// Take any specific WebElement ScreenShot
public class Assg7_4 extends TestBase {
    @Test
    public void screenshotTest() {
        // Go to amazon.com
        driver.get("https://www.amazon.com/stores/page/CDF3296F-98B9-4A3E-BCA2-4834A6E96166");

        // Take a full page screenshot
        File fullPageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Take a screenshot of a specific WebElement
        WebElement LogoElement = driver.findElement(By.id("nav-logo-sprites"));
        File elementScreenshot = LogoElement.getScreenshotAs(OutputType.FILE);

        //➕ Assert screenshots exists
        Assertions.assertTrue(fullPageScreenshot.exists(), "Full page screenshot not saved.");
        Assertions.assertTrue(elementScreenshot.exists(), "Specific WebElement screenshot not saved.");

    }
}
