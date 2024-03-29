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
    private final By yesSubscribeRadioButton = By.xpath("//label[@for='input-newsletter-yes']");
    private final By privatePolicyCheckbox = By.xpath("//label[@for='input-agree']");
    private final By continueBtn = By.xpath("//input[@value='Continue']");

    public Register(WebDriver driver) {
        this.driver = driver;
    }

    public Register goTo() {
        driver.navigate().to(url);
        return this;
    }

    public Register enterFirstName(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        return this;
    }

    public Register enterLastName(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    public Register enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public Register enterTelephone(String telephone) {
        driver.findElement(telephoneInput).sendKeys(telephone);
        return this;
    }

    public Register enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public Register confirmPassword(String password) {
        driver.findElement(confirmPasswordInput).sendKeys(password);
        return this;
    }
    public Register subscribe() {
        driver.findElement(yesSubscribeRadioButton).click();
        return this;
    }
    public Register dontSubscribe() {
        driver.findElement(noSubscribeRadioButton).click();
        return this;
    }

    public Register agreeToPrivacyPolicy() {
        driver.findElement(privatePolicyCheckbox).click();
        return this;
    }

    public Account submitRegistration() {
        driver.findElement(continueBtn).click();
        return new Account(driver);
    }
}
