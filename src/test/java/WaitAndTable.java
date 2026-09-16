import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.BooleanSupplier;

public class WaitAndTable {

    static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("file:///C:/Users/Prashant_Patil/Downloads/kpi_selenium_practice_timing_fixed.html");
        WebElement spinner = driver.findElement(By.xpath(
                "//div[@id='spinnerMask' and @style='display: flex;']"));
        wait.until(ExpectedConditions.invisibilityOf(spinner));

        By rowLocator = By.xpath("//tbody/tr");
        wait.until(driver1 -> driver1.findElements(rowLocator).size() > 1);

        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));

        for (WebElement row : rows) {
            String name = row.findElement(By.xpath("./td[1]")).getText();
            String status = row.findElement(By.xpath("./td[2]")).getText();
            int rating = Integer.parseInt(row.findElement(By.xpath("./td[3]"))
                    .getText().replace("%", ""));

            if (!status.equals("PASS") || rating < 85) {
                System.out.println("Name: " + name + ", Status: " + status + ", Rating: " + rating);
            }
        }
        driver.quit();
    }

}
