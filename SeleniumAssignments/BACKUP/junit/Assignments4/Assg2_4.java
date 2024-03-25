package junit.Assignments4;

import junit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Assignement 2/4 Drag and Drop 🖱️
 */

public class Assg2_4 extends TestBase {

    @Test
    public void dragAndDropTest() {
        //Go to URL: http://demo.guru99.com/test/drag_drop.html
        driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");

        By bankButton = By.id("credit2");
        By salesButton = By.id("credit1");
        By fiveThousandButton = (By.id("fourth"));

        By accountDebitSide = By.id("bank");
        By amountDebitSide = By.id("amt7");

        By accountCreditSide = By.id("loan");
        By amountCreditSide = By.id("amt8");

        //Drag and drop the BANK button to the Account section in DEBIT SIDE
        dragAndDropMethod(bankButton, accountDebitSide);
        //Drag and drop the SALES button to the Account section in CREDIT SIDE
        dragAndDropMethod(salesButton, accountCreditSide);
        //Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        dragAndDropMethod(fiveThousandButton, amountDebitSide);
        //Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        dragAndDropMethod(fiveThousandButton, amountCreditSide);
        //Verify the visibility of Perfect text.
        Assertions.assertEquals("Perfect!", driver.findElement(By.className("table4_result")).getText());
    }


    public void dragAndDropMethod(By draggable, By droppable) {
        WebElement draggableElement = driver.findElement(draggable);
        WebElement droppableElement = driver.findElement(droppable);
        new Actions(driver)
                .dragAndDrop(draggableElement, droppableElement)
                .perform();

    }

}
