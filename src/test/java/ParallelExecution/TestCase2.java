package ParallelExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase2 {

    WebDriver driver;

    @Test
    void loginTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));

        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[contains(@class,'orangehrm-login-button')]")).click();

        String title = driver.getTitle();
        Assert.assertEquals(title, "OrangeHRM");
        Thread.sleep(5000);
    }

    @AfterTest
    void tearDown() {
        System.out.println("closing driver");
        driver.quit();
    }
}
