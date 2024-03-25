package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

//Practice activity in mentoring session

public class FileDownloadTest extends TestBase {

    @Test
    public void fileDownloadTest() throws InterruptedException {
        //Go to URL: https://opensource-demo.orangehrmlive.com/
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/");

        //Login page valid credentials.
        wait.until(f -> {
            driver.findElement(By.name("username")).sendKeys("Admin");
            return true;
        });
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Download sample CSV file. pim->configuration->importData
        wait.until(f -> {
            driver.findElement(By.xpath("//a[@href='/web/index.php/pim/viewPimModule'] ")).click();
            return true;

        });
        wait.until(f -> {
            driver.findElement(By.xpath("//li[contains(.,'Configuration ')]")).click();
            return true;
        });

        wait.until(f -> {
            driver.findElement(By.xpath("//a[text()='Data Import']")).click();
            return true;
        });
        wait.until(f -> {

            driver.findElement(By.linkText("Download")).click();
            return true;
        });

        //Verify if the file downloaded successfully.
        Thread.sleep(5000);

        String path = System.getProperty("user.home") + "/Downloads/importData.csv";
        boolean isExist = Files.exists(Paths.get(path));
        Assertions.assertTrue(isExist);
    }
}



