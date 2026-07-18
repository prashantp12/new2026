package ParallelExecution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class TestCase1 {

    WebDriver driver;

    @Test
    void logo() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement logoElement = driver.findElement(By.xpath("//div[@class='orangehrm-login-logo']"));
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(logoElement));
        System.out.println(logoElement.isDisplayed());
        Assert.assertTrue(logoElement.isDisplayed(), "Logo is displayed");
        Thread.sleep(5000);
    }

    @Test
    void verifyTitle() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"OrangeHRM");
        Thread.sleep(5000);
    }

    @AfterTest
    void tearDown() {
        System.out.println("closing driver");
        driver.quit();
    }

}
