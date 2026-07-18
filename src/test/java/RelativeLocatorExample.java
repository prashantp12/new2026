import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class RelativeLocatorExample {

    static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/V4/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement userId = driver.findElement(By.xpath("//input[@name='uid']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement login = driver.findElement(By.xpath("//input[@name='btnLogin']"));
        WebElement reset = driver.findElement(By.xpath("//input[@name='btnReset']"));

//        driver.findElement(RelativeLocator.with(By.tagName("input")).above(password)).sendKeys("test123");
//        driver.findElement(RelativeLocator.with(By.tagName("input")).below(userId)).sendKeys("1234567890");
//        driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(reset)).click();
//
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        //WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(userId));
//        new WebDriverWait(driver, Duration.ofSeconds(15)).until(
//                webDriver -> Objects.equals(((JavascriptExecutor) webDriver)
//                        .executeScript("return document.readyState"), "complete"));

        driver.findElement(RelativeLocator.with(By.tagName("input")).above(password)).sendKeys("test123");
        driver.findElement(RelativeLocator.with(By.tagName("input")).below(userId)).sendKeys("1234567890");
        driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(login)).click();

        WebElement userIdLabel = driver.findElement(By.xpath("//td[text()='UserID']"));
        driver.findElement(RelativeLocator.with(By.tagName("input")).near(userIdLabel)).sendKeys("111");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
