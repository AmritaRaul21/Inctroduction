import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


public class NewWindow {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        //driver.switchTo().newWindow(WindowType.TAB);
       driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> handles= driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
      String parentid =   it.next();
      String Childid = it.next();
      driver.switchTo().window(Childid);
      driver.get("https://rahulshettyacademy.com/");
      String course = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        driver.switchTo().window(parentid);
        WebElement name = driver.findElement(By.cssSelector("[name = 'name']"));
        name.sendKeys(course);
       File file =  name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));
        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
        //driver.quit();


    }
}
