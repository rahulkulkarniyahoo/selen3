/**
 * 
 */
package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Helper.BrowserFactory;
import mytest.LoginPage;

/**
 * @author rahul.kulkarni
 *
 */
public class VerifyValidLogin {
	@Test
	public void checkValidUser(){
		
		
		WebDriver driver = BrowserFactory.startBrowser("chrome", "http://demosite.center/wordpress/wp-login.php");
		
		LoginPage login_page = PageFactory.initElements(driver, LoginPage.class);
		
		login_page.login_wordpress("admin", "demo123");
		
	}
	
	

}
