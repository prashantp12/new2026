import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaExecutorExample {

    static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Actions act = new Actions(driver);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript();

    }
}
