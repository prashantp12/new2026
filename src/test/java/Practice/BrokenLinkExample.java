package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinkExample {

    static WebDriver driver;

    static void main(String[] args) throws IOException {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            String urlLink = link.getAttribute("href");

            if (urlLink == null || urlLink.isEmpty()) {
                break;
            }

            URL url = new URL(urlLink);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5000);
            con.connect();

            if (con.getResponseCode() > 400) {
                System.out.println(url + " --> " + "is broken");
            } else
                System.out.println(url + " --> " + "is valid link");
        }
        driver.quit();
    }
}
