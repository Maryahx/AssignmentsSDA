package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*      Assignment 4/5
Open the site: http://opencart.abstracta.us/index.php?route=account/login
Login with that credentials
Email: clarusway@gmail.com
Password: 123456789
Using the Search function do it with Data Provider for Mac, iPad and Samsung.
*/
public class Assgn4_5Test extends TestBase {
    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"mac"},
                {"ipad"},
                {"Samsung"}
        };
    }

    @Test(dataProvider = "getData")
    public void search(String words) {
        bot.navigate("http://opencart.abstracta.us/index.php?route=account/login");
        bot.type(By.xpath("//input[@name='search']"), words + Keys.ENTER);
    }

}
