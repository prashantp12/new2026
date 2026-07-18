import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class AssertionExamples {

    public static WebDriver driver;

    @BeforeClass
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void logo() {
        WebElement logoElement = driver.findElement(By.xpath("//div[@class='orangehrm-login-logo']"));
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(logoElement));
        Assert.assertTrue(logoElement.isDisplayed(), "Logo is displayed");
    }

    @Test
    void verifyTitle(){
        String title = driver.getTitle();
        Assert.assertEquals(title,"OrangeHRM");
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }

}
