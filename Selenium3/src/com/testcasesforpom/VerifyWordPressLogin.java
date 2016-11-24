/**
 * 
 */
package com.testcasesforpom;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageobjectmodel.LoginPage;

/**
 * @author rahul.kulkarni
 *
 */
public class VerifyWordPressLogin {
	

	
	@Test
	public void verifyValidLogin(){
		System.setProperty("webdriver.chrome.driver",  "src/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.demosite.center/wordpress/wp-login.php");
		
		LoginPage login = new LoginPage(driver);
		login.typeUserName("admin");
		login.typePassword("demo123");
		login.clickOnLoginButton();
		
		

		
		driver.quit();
		
	}
	
	

}
