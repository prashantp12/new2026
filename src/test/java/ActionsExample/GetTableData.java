package ActionsExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class GetTableData {

    static WebDriver driver;

    static void main(String[] args) {
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/2018/09/automation-form.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Actions act = new Actions(driver);
        WebElement dynamicTableHeading = driver.findElement(By.xpath("//h2[text()='Dynamic Web Table']"));
        act.moveToElement(dynamicTableHeading).perform();

        WebElement staticTable = driver.findElement(By.xpath("//table[@name='BookTable']/parent::div"));
        List<WebElement> rows = staticTable.findElements(By.xpath(".//tbody/tr"));
        System.out.println(rows.get(0).getText());
        System.out.println(rows.size());


    }
}
