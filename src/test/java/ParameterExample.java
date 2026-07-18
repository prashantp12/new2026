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

public class ParameterExample {

    public static WebDriver driver;
    private String url;
    private String browser;

    @BeforeClass
    @Parameters({"browser", "url"})
    //@Parameters({browser,url})
    void setup(String browser, String url) {
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                driver.get(url);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                driver.get(url);
                break;
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
