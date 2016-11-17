package mytest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SanityTest {
	WebDriver driver;
	
	  @Test
	  public void f() {
		  System.out.println("Running Sanity Test ..");
		  driver.get("http://computer-database.herokuapp.com/computers");
		  System.out.println("Title of the Page = " + driver.getTitle());
		  Assert.assertTrue(driver.getTitle().contains("Computers"));
	  }
	  @Before
	  public void beforeTest() {
		  	System.out.println("Before Test Run ..");
			/*System.setProperty("webdriver.chrome.driver",  "src/testng/resources/chromedriver");
			driver = new ChromeDriver();*/
		  	System.setProperty("webdriver.gecko.driver",  "src/geckodriver");
		  	driver = new FirefoxDriver();
	  }

	  @After
	  public void afterTest() {
		  System.out.println("After Test Run ...");
		  driver.quit();
	  }
}
