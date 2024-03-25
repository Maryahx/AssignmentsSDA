package testng;

/*          [Assignment 1/5] 🧪
    Create tests that depend on each other✅
    Create beforeClass and set up settings.✅
    By creating interdependent tests; ✅
    First go to Facebook.✅
    Then go to Google depending on Facebook,✅
    Then go to Amazon depending on Google✅
    Close the driver.✅
     */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assgn1_5Test {
    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    protected static Logger logger;

    @Test
    public void facebookTest() {
        driver.get("https://facebook.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
    }

    @Test(dependsOnMethods = {"facebookTest"})
    public void googleTest() {
        driver.get("https://www.google.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
    }

    @Test(dependsOnMethods = {"googleTest"})
    public void amazonTest() {
        driver.get("https://www.amazon.com/");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com/");
    }

    @BeforeClass
    public void beforeClass() {
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(Assgn1_5Test.class.getName());
        logger.info("Opening Browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger.info("Configuring 5 second explicit wait");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

}
