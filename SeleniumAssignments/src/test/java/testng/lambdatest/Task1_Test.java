package testng.lambdatest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.lambdatest.Register;
import testng.TestBase;


/*
  go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
  register account test with fluent page object approach
*/

public class Task1_Test extends TestBase {

    String firstName = "Maria";
    String lastName = "SDA";
    String email = "maria" + System.currentTimeMillis() + "@email.com";
    String telephone = "0594567891";
    String password = "P@ssword123";

    @Test
    public void registerTest() {
        String actualText = new Register(driver, bot)
                .goTo()
                .registerSuccess(firstName, lastName, email, telephone, password)
                .readSuccessMessage();
        Assert.assertEquals(actualText, "Your Account Has Been Created!");
    }
}
