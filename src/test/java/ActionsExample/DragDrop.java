package ActionsExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

    static WebDriver driver;

    static void main(String[] args) {
        driver=new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/2018/09/automation-form.html");

        Actions act = new Actions(driver);
        WebElement slider = driver.findElement(By.xpath("//h2[text()='Slider']"));
        act.moveToElement(slider).perform();

        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
        WebElement droppable =driver.findElement(By.cssSelector("#droppable"));

        act.clickAndHold(draggable).moveToElement(droppable).release().perform();
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
