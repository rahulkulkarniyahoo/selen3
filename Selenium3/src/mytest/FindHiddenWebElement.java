package mytest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Helper.BrowserFactory;

public class FindHiddenWebElement {

	@Test
	public void myTest() throws InterruptedException{
		WebDriver driver = BrowserFactory.startBrowser("chrome", "https://test.salesforce.com");
		
		driver.findElement(By.id("username")).sendKeys("rahul.kulkarni@mailnewspapers.co.uk.sc.admin");
		driver.findElement(By.id("password")).sendKeys("Password1234");
		driver.findElement(By.id("Login")).click();
		
		Thread.sleep(6000);
		// driver.findElement(By.xpath("//table[@id='ext-comp-1006']/tbody/tr[2]/td[2]/em")).click();
		//driver.findElement(By.class("em[class='x-btn-split'][style='background-color: transparent;']")).click();
		String parentHandle = driver.getWindowHandle(); 
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		
		//driver.findElement(By.cssSelector("em[class='x-btn-split']")).click();

		//driver.findElement(By.cssSelector("em[id^=ext-gen]")).click();
		System.out.println("Sleeping1");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("em.x-btn-split")).click();
		System.out.println("Sleeping2");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("em.x-btn-split")).click();
		System.out.println("Sleeping3");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("em.x-btn-split")).click();
		
		Actions action = new Actions(driver);
		
		action.doubleClick().build().perform();
		
		
		/*WebElement list = driver.findElement(By.xpath("html/body/div[4]/div[1]/div[1]/table/tbody/tr[2]/td[2]//*[@class='x-btn-split']"));
		//list.click();
		Actions act = new Actions(driver);
			act.doubleClick(list);
			
		
		System.out.println("Sleeping");
		Thread.sleep(5000);
		WebElement cust = list.findElement(By.linkText("Customers"));
		Thread.sleep(1000);
		cust.click();*/
		
		System.out.println("Done");
		//driver.close(); 
		driver.switchTo().window(parentHandle); 
		System.out.println("Test");
		
	}
}
