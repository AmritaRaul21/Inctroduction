import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement nameBox = driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameBox)).getText());

        WebElement dateofBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateofBirth)).click();

       WebElement icecreamlabel =  driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
       driver.findElement(with(By.tagName("input")).toLeftOf(icecreamlabel)).click();

       WebElement Employee = driver.findElement(By.cssSelector("input[id='inlineRadio1']"));
       System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(Employee)).getText());

    }
}
