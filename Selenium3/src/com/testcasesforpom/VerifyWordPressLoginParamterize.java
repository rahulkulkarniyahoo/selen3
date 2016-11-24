/**
 * 
 */
package com.testcasesforpom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageobjectmodel.LoginPage;

/**
 * @author rahul.kulkarni
 *
 */
public class VerifyWordPressLoginParamterize {
	WebDriver driver;

	@Before
	public void startup() {
		System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://www.demosite.center/wordpress/wp-login.php");
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void verifyValidLogin() {

		LoginPage login = new LoginPage(driver);
		login.loginToWordPress("admin", "demo123");

	}
	
	@Test
	public void verifyValidLoginAgain(){
		LoginPage login = new LoginPage(driver);
		login.loginToWordPress("admin", "demo123");
		System.out.println("Done verifyValidLoginAgain");
	}

}
