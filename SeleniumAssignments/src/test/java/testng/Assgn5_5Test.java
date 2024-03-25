package testng;

//Go to URL: http://crossbrowsertesting.github.io/                         | ☑️
//Click to To-Do App                                                       | ☑️
//Checking Box to do-4 and Checking Box to do-5                            | ☑️
//If both clicks worked, then the following List should have length 2.     | ☑️
//Assert that this is correct                                              | ☑️
//Assert that the to do we added is present in the list                    | ☑️
//Archiving old todos                                                      | ☑️
//If our archive link worked, then the following list should have length 4.| ☑️
//Assert that this is true as well                                         | ☑️
//Doing Cross Browser Testing.                                             | ☑️ <-- crossbrowser.xml file

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Assgn5_5Test extends TestBase {

    @Test
    public void task() {
        bot.navigate("http://crossbrowsertesting.github.io/");
        bot.click(By.xpath("//a[@href='todo-app.html']"));

        bot.click(By.name("todo-4"));
        bot.click(By.name("todo-5"));


        List<WebElement> doneList = driver.findElements(By.className("done-true"));
        Assert.assertEquals(doneList.size(), 2);

        bot.type(By.id("todotext"), "Solve SDA Assignments");
        driver.findElement(By.id("addbutton")).submit();


        List<WebElement> todoList = driver.findElements(By.className("done-false"));
//        Assert.assertEquals(todoList.getLast().getText(),"Solve SDA Assignments"); //This also works but only if we add only one new element
        boolean itemAddedExist = todoList.stream()
                .map(WebElement::getText)
                .anyMatch(text -> text.equals("Solve SDA Assignments"));
        Assert.assertTrue(itemAddedExist);

        bot.click(By.xpath("//a[@ng-click='todoList.archive()']"));
        Assert.assertEquals(todoList.size(), 4);

    }
}
