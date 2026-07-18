package RetryAnalyzerExample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ShadowDomExample {

    static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.switchTo().frame("pact");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement snacksElement = (WebElement) js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#tea\")");
        String input = "arguments[0].setAttribute('value','Green tea')";
        WebElement lunchElement = (WebElement) js.executeScript("return document.querySelector(\"#snacktime\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\")");
        String input2 = "arguments[0].setAttribute('value','Paneer masala')";
        js.executeScript(input, snacksElement);
        js.executeScript(input2,lunchElement);
    }

}
