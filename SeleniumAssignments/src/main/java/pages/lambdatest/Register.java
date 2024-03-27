package pages.lambdatest;

import engine.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register extends Pages {

    //Elements
    private final String url = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    private final By firstNameInput = By.id("input-firstname");
    private final By lastNameInput = By.id("input-lastname");
    private final By emailInput = By.id("input-email");
    private final By telephoneInput = By.id("input-telephone");
    private final By passwordInput = By.id("input-password");
    private final By confirmPasswordInput = By.id("input-confirm");
    private final By noSubscribeRadioButton = By.xpath("//label[@for='input-newsletter-no']");
    private final By privatePolicyCheckbox = By.xpath("//label[@for='input-agree']");
    private final By continueBtn = By.xpath("//input[@value='Continue']");


    public Register(WebDriver driver, ActionsBot bot) {
        super(driver, bot);
    }

    public Register goTo() {
        bot.navigate(url);
        return this;
    }

    public Account registerSuccess(String firstname, String lastname, String email, String telephone, String password) {
        register(firstname, lastname, email, telephone, password);
        return new Account(driver, bot);
    }

    private void register(String firstname, String lastname, String email, String telephone, String password) {
        bot.type(firstNameInput, firstname);
        bot.type(lastNameInput, lastname);
        bot.type(emailInput, email);
        bot.type(telephoneInput, telephone);
        bot.type(passwordInput, password);
        bot.type(confirmPasswordInput, password);
        bot.click(noSubscribeRadioButton);
        bot.click(privatePolicyCheckbox);
        bot.click(continueBtn);
    }


}
