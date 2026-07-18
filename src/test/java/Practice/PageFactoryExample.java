package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PageFactoryExample {
    WebDriver driver= new ChromeDriver();

    public PageFactoryExample(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "uid")
    WebElement userId;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "btnLogin")
    WebElement login;

    public void test() throws InterruptedException {
        userId.sendKeys("user123");
        password.sendKeys("123456789");
        Thread.sleep(5000);
        login.click();
    }

    @Test
    void newTest() throws InterruptedException {
        driver= new ChromeDriver();
        driver.get("https://demo.guru99.com/V4/");
        test();
    }

}
