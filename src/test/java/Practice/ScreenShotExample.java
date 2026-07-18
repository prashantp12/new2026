package Practice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class ScreenShotExample {

    static WebDriver driver;

    static void main(String[] args) {

        driver = new ChromeDriver();
        driver.get("https://demoqa.com/broken");
        takeScreenShot("Google_HomePage");

    }

    static void takeScreenShot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File des = new File("E:\\Selenium\\June2026\\TestNGProject\\src\\test\\java\\" + fileName + ".png");
        try {
            FileUtils.copyFile(src, des);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
