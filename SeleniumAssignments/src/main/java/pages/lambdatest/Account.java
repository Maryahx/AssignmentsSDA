package pages.lambdatest;

import engine.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Account extends Pages {
    private final By accountCreatedMsg = By.xpath("//h1[contains(@class,'my-3')]");

    public Account(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    public String readSuccessMessage() {
        return bot.getText(accountCreatedMsg);
    }
}
