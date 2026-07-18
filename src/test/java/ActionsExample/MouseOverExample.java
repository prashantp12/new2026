package ActionsExample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;

public class MouseOverExample {

    static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement freshLink = driver.findElement(By.xpath("//div[@id='nav-link-groceries']/a"));
        Actions act = new Actions(driver);
        act.moveToElement(freshLink).perform();
        WebElement freshlink1 = driver.findElement(By.xpath("//img[@alt='Amazon Fresh']"));
        act.moveToElement(freshlink1).click().perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String requiredPincode = "411041";
        WebElement pincodeField = driver.findElement(By.xpath("//input[contains(@placeholder,'pincode')]"));
        pincodeField.sendKeys(requiredPincode);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement applyButton = driver.findElement(By.xpath("//span[text()='Apply']//ancestor::div[@role='button']"));
        js.executeScript("arguments[0].click();",applyButton);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String selectedPin = driver.findElement(By.xpath("//div[@id='glow-ingress-block']/span[2]")).getText().trim();
        int piLength = selectedPin.length();
        String selectedPincode = selectedPin.substring(6, piLength);
        System.out.printf(selectedPin);
        System.out.printf("Selected picode :" + selectedPincode);

        driver.quit();
    }
}
