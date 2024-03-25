package junit.Assignments4;

import junit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Set;

/**
 * Assignment 1/4 🪟 Window Handle
 */


public class Assg1_4 extends TestBase {

    @Test
    public void windowHandleTest() {
        //Go to URL: https://the-internet.herokuapp.com/windows
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        //Verify the text: “Opening a new window”
        Assertions.assertEquals("Opening a new window", driver.findElement(By.cssSelector("h3")).getText());

        //Verify the title of the page is “The Internet”
        Assertions.assertEquals("The Internet", driver.getTitle());

        //Click on the “Click Here” button
        driver.findElement(By.xpath("//a[@href='/windows/new']")).click();

        //Verify the new window title is “New Window”
        Set<String> handles = driver.getWindowHandles(); //get all window handles opened by current session
        String windowHandle = (String) handles.toArray()[1]; //convert handles to array and get the new tab
        driver.switchTo().window(windowHandle);
        Assertions.assertEquals("New Window", driver.findElement(By.cssSelector("h3")).getText());

        //Go back to the previous window and then verify the title: “The Internet”
        driver.switchTo().window((String) handles.toArray()[0]);
        Assertions.assertEquals("The Internet", driver.getTitle());

    }
}
