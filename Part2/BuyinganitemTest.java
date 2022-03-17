// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class BuyinganitemTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void buyinganitem() {
    driver.get("https://www.sportchek.ca/");
    driver.manage().window().setSize(new Dimension(703, 864));
    driver.findElement(By.cssSelector(".full-image__img > img")).click();
    js.executeScript("window.scrollTo(0,173)");
    driver.findElement(By.cssSelector(".product-category-tile__item:nth-child(1) .product-category-tile__img")).click();
    js.executeScript("window.scrollTo(0,181)");
    driver.findElement(By.cssSelector(".product-category-tile__item:nth-child(1) .product-category-tile__img")).click();
    js.executeScript("window.scrollTo(0,49)");
    driver.findElement(By.cssSelector(".product-grid__list-item:nth-child(1) .product-grid-image")).click();
    js.executeScript("window.scrollTo(0,622)");
    driver.findElement(By.linkText("7")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".add-cart > span"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".add-cart > span")).click();
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    {
      WebElement element = driver.findElement(By.linkText("8"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    js.executeScript("window.scrollTo(0,439.5)");
    js.executeScript("window.scrollTo(0,474)");
    driver.findElement(By.cssSelector(".option-tiles__item:nth-child(3) > .option-tiles__item-title")).click();
    {
      WebElement element = driver.findElement(By.linkText("8"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".add-cart")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".header-cart__text"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    js.executeScript("window.scrollTo(0,708.5)");
    driver.findElement(By.id("header-cart__count")).click();
    driver.findElement(By.id("honeyContainer")).click();
    js.executeScript("window.scrollTo(0,99)");
    driver.findElement(By.cssSelector(".continue-checkout")).click();
    driver.findElement(By.name("firstName")).click();
    driver.findElement(By.cssSelector(".button")).click();
    driver.findElement(By.name("email")).click();
    driver.findElement(By.cssSelector(".button")).click();
    js.executeScript("window.scrollTo(0,205)");
    js.executeScript("window.scrollTo(0,454)");
    driver.findElement(By.linkText("Back to Shopping Cart")).click();
  }
}
