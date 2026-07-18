import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AmazonPractice {

    //To type mobile in serach box and click on 10000 option
    static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement searchField = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchField.sendKeys("Mobile");

        List<WebElement> dropdownList = driver.findElements(By.xpath("//div[contains(@class,'s-suggestion-ellipsis-direction')]"));
        for (WebElement element : dropdownList) {
            String text = element.getAttribute("aria-label");
            if (text.equals("mobile under 10000 5g phone")) {
                element.click();
                break;
            }else {
                System.out.println("Text 'mobile under 10000 5g phone' not found");
            }
        }
    }
}
