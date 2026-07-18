package ActionsExample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test2 {

    static WebDriver driver;

    static void main(String[] args) {
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement mouseOverButton = driver.findElement(By.cssSelector("button.dropbtn"));
        js.executeScript("arguments[0].moveToElement",mouseOverButton);
    }
}
