package junit.Assignments4;

import junit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Assignment 3/4 Keyboard Actions ⌨️
 */

//( This task should be managed with keyboard actions )
// go to https://www.google.com/
// search for "Scroll Methods" by using an Actions object

public class Assg3_4 extends TestBase {


    @Test
    public void keyboardActionsTest(){
        driver.navigate().to("https://www.google.com/");
        WebElement searchTextArea = driver.findElement(By.id("APjFqb"));

        new Actions(driver)
                .sendKeys(searchTextArea,"Scroll Methods")
                .sendKeys(Keys.ENTER)
                .perform();

        Assertions.assertFalse(driver.findElement(By.id("result-stats")).getText().isEmpty());
    }
}
