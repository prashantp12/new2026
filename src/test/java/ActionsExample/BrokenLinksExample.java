package ActionsExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinksExample {

    static WebDriver driver;

    static void main(String[] args) throws IOException {
        driver = new ChromeDriver();
        driver.get("https://www.brokenlinkcheck.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //get all links with tagname "a"
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            String urlFromLink = link.getAttribute("href");
            if (urlFromLink == null || urlFromLink.isBlank()) {
                return;
            }

            URL url = new URL(urlFromLink);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.connect();

            if (con.getResponseCode() > 400) {
                System.out.println(urlFromLink + " gives response code " + con.getResponseCode() + " is broken link");
            } else {
                System.out.println(urlFromLink + " gives response code " + con.getResponseCode() + " is valid link");
            }
        }
    }
}
