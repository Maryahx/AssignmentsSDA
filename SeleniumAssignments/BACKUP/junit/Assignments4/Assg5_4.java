package junit.Assignments4;

import junit.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

/**
 * Assignment 5/4 Cookies 🍪
 */
/*   Go to URL: http://facebook.com
       getCookies,
       addCookie,
       deleteCookieNamed,
       deleteAllCookies
    */
public class Assg5_4 extends TestBase {
    @Test
    public void cookiesTest() {
        //Go to URL: http://facebook.com
        driver.get("http://facebook.com");

        //getCookies
        driver.manage().getCookies();

        //addCookie,
        driver.manage().addCookie(new Cookie("New Cookie", "Mary's cookie!"));


        //deleteCookieNamed
        driver.manage().deleteCookieNamed("New Cookie");

        //deleteAllCookies
        driver.manage().deleteAllCookies();

        //➕ Assert cookies are deleted
        Assertions.assertEquals(0, driver.manage().getCookies().size());
    }
}
