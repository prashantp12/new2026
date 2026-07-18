import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class CheckBrokenLinks {

    static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/broken");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        try {
            for (WebElement link : links) {
                String url = link.getAttribute("href");

                if (url == null || url.isEmpty()) {
                    continue;
                }

                URL url1 = new URL(url);
                HttpURLConnection con = (HttpURLConnection) url1.openConnection();
                con.setConnectTimeout(5000);
                con.connect();

                if (con.getResponseCode() > 400) {
                    System.out.println(url + " -> " + con.getResponseCode() + "-> Broken link");
                } else {
                    System.out.println(url + " -> " + con.getResponseCode() + "-> Valid link");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        driver.quit();
    }

}
