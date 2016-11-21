package mytest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SanityTest {
	WebDriver driver;
	
	  @Test
	  public void f() {
		  System.out.println("Running Sanity Test ..");
		  driver.get("http://computer-database.herokuapp.com/computers");
		  System.out.println("Title of the Page = " + driver.getTitle());
		  try{
		  Assert.assertTrue(driver.getTitle().contains("ggters"));
		  }
		  
		  
		  catch(AssertionError e){
			  System.out.println("Caught Exception Here !!");
		  EventFiringWebDriver eDriver=new EventFiringWebDriver(driver);
		  String name = new Object(){}.getClass().getEnclosingMethod().getName();
		  
		  File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		  String fName = name + "mytest.png";
		  try {
			FileUtils.copyFile(srcFile, new File("src/mytest/" + fName));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		  }
	  }
	  @Before
	  public void beforeTest() {
		  	System.out.println("Before Test Run ..");
			System.setProperty("webdriver.chrome.driver",  "src/resources/chromedriver");
			driver = new ChromeDriver();
		  	/*System.setProperty("webdriver.gecko.driver",  "src/geckodriver");
		  	driver = new FirefoxDriver();*/
	  }

	  @After
	  public void afterTest() {
		  System.out.println("After Test Run ...");
		  driver.quit();
	  }
}
