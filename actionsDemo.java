import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class actionsDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.geeksforgeeks.org/conversion-of-array-to-arraylist-in-java/");
        driver.manage().window().maximize();
        Actions a = new Actions(driver);
        WebElement move = driver.findElement(By.xpath("(//li[@class='header-main__list-item Header_1'])[1]"));
        a.moveToElement(driver.findElement(By.xpath("//i[@class='gfg-icon gfg-icon_search gfg-icon_white gcse-search__icon']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
        a.moveToElement(move).contextClick().build().perform();
        driver.close();

    }
}
