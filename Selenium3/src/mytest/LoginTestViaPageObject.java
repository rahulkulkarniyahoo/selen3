/**
 * 
 */
package mytest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import Helper.BrowserFactory;

/**
 * @author rahul.kulkarni
 *
 */
public class LoginTestViaPageObject {
	WebDriver driver;
	
	 @Before
	  public void beforeTest() {
		  	System.out.println("Before Test Run ..");
		  	driver = BrowserFactory.startBrowser("chrome", "http://www.demosite.center/wordpress/wp-login.php");
	  }

	  @After
	  public void afterTest() {
		  System.out.println("After Test Run ...");
		  driver.quit();
	  }
	  
	  
	  @Test
	  public void TestLoginWithPageObjects(){
		  LoginPage login_page=PageFactory.initElements(driver, LoginPage.class);
		  login_page.login_wordpress("admin", "demo123");
	  }
}
