package lambdataset;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register {
    private final WebDriver driver;
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

    public Register(WebDriver driver) {
        this.driver = driver;
    }

    public Register goTo() {
        driver.navigate().to(url);
        return this;
    }

    public Account registerAccount(String firstname, String lastname, String email, String telephone, String password) {
        enterNewAccountInfo(firstname, lastname, email, telephone, password);
        noSubscription();
        agreePrivacyPolicy();
        driver.findElement(continueBtn).click();
        return new Account(driver);
    }

    private void enterNewAccountInfo(String firstname, String lastname, String email, String telephone, String password) {
        driver.findElement(firstNameInput).sendKeys(firstname);
        driver.findElement(lastNameInput).sendKeys(lastname);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(telephoneInput).sendKeys(telephone);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(password);
    }

    private void noSubscription() {
        driver.findElement(noSubscribeRadioButton).click();
    }

    private void agreePrivacyPolicy() {
        driver.findElement(privatePolicyCheckbox).click();
    }
}
