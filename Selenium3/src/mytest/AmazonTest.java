package mytest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AmazonTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver");  
    driver = new ChromeDriver();
    baseUrl = "https://www.amazon.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testNavigationInSalesForce() throws Exception {
    driver.get(baseUrl + "/");
    System.out.println("Sleeping for 4 - 1");
    Thread.sleep(4000);
    System.out.println(driver.getTitle());
    Assert.assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
    System.out.println("Sleeping for 4 - 2");
    Thread.sleep(4000);
    WebElement ele = driver.findElement(By.xpath(".//*[text()='Departments']"));
    Actions act = new Actions(driver);
    act.moveToElement(ele).perform();
    //driver.findElement(By.linkText("All Videos")).click();
    System.out.println("Clicked on Department");
    WebElement ele2 =  driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[2]/span[1]/span"));
    act.moveToElement(ele2).perform();
    ele2.click();
    Thread.sleep(2000);
    System.out.println("Sleeping for 4 - 3");
    WebElement ele3 =  driver.findElement(By.xpath(".//*[@id='nav-flyout-shopAll']/div[3]/div[1]/div[1]/div/a[1]/span[1]"));
    act.moveToElement(ele3).perform();
    ele3.click();
    System.out.println("Sleeping for 4 - 4");

    System.out.println();
    
    
  System.out.println(driver.getTitle());
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
