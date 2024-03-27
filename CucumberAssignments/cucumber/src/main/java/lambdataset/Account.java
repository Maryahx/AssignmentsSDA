package lambdataset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account {
    private final WebDriver driver;
    private final By accountCreatedMsg = By.xpath("//h1[contains(@class,'my-3')]");

    public Account(WebDriver driver) {
        this.driver = driver;
    }

    public String readSuccessMessage() {
        return driver.findElement(accountCreatedMsg).getText();
    }
}
