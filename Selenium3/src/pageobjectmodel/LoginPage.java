/**
 * 
 */
package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import Helper.Highlight;

/**
 * @author rahul.kulkarni
 * 
 *         This class will store all locateor and methods of login page in Page
 *         object model pattern this class does not use page object factory
 *
 */
public class LoginPage {

	WebDriver driver;

	By username = By.id("user_login");
	//By password = By.xpath(".//*[@id='user_pass']");
	By password = By.cssSelector(".//*[@id='user_pass']");
	By loginButton = By.name("wp-submit");

	/*
	 * Need to create constructor. Constructor needs to be same as class name
	 */

	public LoginPage(WebDriver driver) {
		this.driver = driver; // needs to initialize the driver on top
	}

	
	public void loginToWordPress(String userid, String passwod){
		
		Highlight.highLightElement(driver, driver.findElement(username));
		driver.findElement(username).sendKeys(userid);
		Highlight.highLightElement(driver, driver.findElement(password));
		driver.findElement(password).sendKeys(passwod);
		Highlight.highLightElement(driver, driver.findElement(loginButton));
		driver.findElement(loginButton).click();
	}
	
	
	public void typeUserName(String uid) {
		driver.findElement(username).sendKeys(uid);
	}

	public void typePassword(String passw) {
		driver.findElement(password).sendKeys(passw);
	}

	public void clickOnLoginButton() {
		driver.findElement(loginButton).click();

	}

}
