import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshotExample {
    static WebDriver driver;

    static void main(String[] args) throws IOException {
        driver = new ChromeDriver();
        driver.get("https://hrms.indianrail.gov.in/IRAPAR/login?lang=en");
        driver.manage().window().maximize();
        takeScreenshot("HR_HomePage");
        driver.quit();
    }

    static void takeScreenshot(String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File des = new File("E:\\Selenium\\June2026\\TestNGProject\\src\\test\\" + fileName + ".png");
        FileUtils.copyFile(src, des);
    }
}
