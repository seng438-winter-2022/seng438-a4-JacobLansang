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
public class LoginwithwrongcredentialsTest {
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
  public void loginwithwrongcredentials() {
    driver.get("https://www.sportchek.ca/");
    driver.manage().window().setSize(new Dimension(703, 864));
    {
      WebElement element = driver.findElement(By.cssSelector(".header-cart__text"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.cssSelector(".page-header__account-button")).click();
    driver.findElement(By.cssSelector(".header-account-icon__dropdown-item-sign-in")).click();
    driver.findElement(By.cssSelector("#gigya-login-form .gigya-input-text")).click();
    driver.findElement(By.cssSelector(".gigya-valid")).sendKeys("kunal.dhawan19@gmail.com");
    driver.findElement(By.cssSelector(".gigya-input-password:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".gigya-input-password:nth-child(2)")).sendKeys("anotherthing68");
    driver.findElement(By.cssSelector("#gigya-login-form .gigya-composite-control-submit > .gigya-input-submit")).click();
  }
}
