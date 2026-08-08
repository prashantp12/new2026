import io.opentelemetry.api.internal.Utils;
import jdk.jshell.execution.Util;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class FetchTableData {

    static WebDriver driver;

    static void main(String[] args) {
        driver = new ChromeDriver();

        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        takeScreenshot("beforeDelete");

        List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
        for(WebElement row:rows){
            String name = row.findElement(By.xpath("./td[1]")).getText();
            String dept = row.findElement(By.xpath("./td[6]")).getText();

            if(name.equals("Kierra") && dept.equals("Legal")){
                row.findElement(By.xpath("//span[@title='Delete']")).click();
            }
        }
        takeScreenshot("afterDelete");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        driver.quit();
    }

    public static void takeScreenshot(String filename){
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("E:\\Selenium\\June2026\\MavemProject\\src\\test\\java\\Screenshots\\"+filename+".png");
       try {
           FileUtils.copyFile(source, dest);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
