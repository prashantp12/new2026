import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParameterizeExample {

    public static WebDriver driver;

    @BeforeClass
    @Parameters({"browser1", "url1"})
    void setup(String browser1, String url1) {
        if (browser1.equals("chrome")) {
            driver = new ChromeDriver();
            driver.get(url1);
        } else if (browser1.equals("firefox")) {
            driver = new FirefoxDriver();
            driver.get(url1);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void logo() {
        WebElement logoElement = driver.findElement(By.xpath("//div[@class='orangehrm-login-logo']"));
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(logoElement));
        Assert.assertTrue(logoElement.isDisplayed(), "Logo is displayed");
    }

    @Test
    void verifyTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "OrangeHRM");
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
