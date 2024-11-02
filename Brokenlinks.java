import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;

public class Brokenlinks {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
       List<WebElement> links =driver.findElements(By.cssSelector("li[class='gf-li'] a "));
        SoftAssert a = new SoftAssert();

        for (WebElement link: links){
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int responsecode = conn.getResponseCode();
            System.out.println(responsecode);
            a.assertTrue(responsecode<400, "The link with text"+link.getText()+"is broken with code "+responsecode);
        }
        a.assertAll();
    }

}
