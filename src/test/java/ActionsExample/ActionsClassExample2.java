package ActionsExample;

import io.opentelemetry.api.internal.Utils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ActionsClassExample2 {
    static WebDriver driver;

    static void main(String[] args) {

        try {
            driver = new ChromeDriver();
            driver.navigate().to("https://testautomationpractice.blogspot.com/2018/09/automation-form.html");
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement copyTextButton = driver.findElement(By.xpath("//button[text()='Copy Text']"));

            Actions act = new Actions(driver);
            act.scrollToElement(copyTextButton).perform();
            act.doubleClick(copyTextButton).perform();

            String text1 = driver.findElement(By.cssSelector("#field1")).getAttribute("value");
            String text2 = driver.findElement(By.cssSelector("#field2")).getAttribute("value");
            Assert.assertEquals(text1, text2);

            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File des = new File("E:\\Selenium\\June2026\\TestNGProject" +
                    "\\src\\test\\java\\ActionsExample\\Test1.png");
            try {
                FileUtils.copyFile(src, des);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } finally {
            driver.quit();
        }
    }
}
