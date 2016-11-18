package mytest;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Helper.BrowserFactory;

/**
 * 
 */

/**
 * @author rahul.kulkarni
 *
 */
public class VerifyLinks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = BrowserFactory.startBrowser("chrome", "https://www.google.co.uk");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total Links on this page are = " + links.size());
		
		
		for (int i =0;i<links.size();i++){
			WebElement ele = links.get(i);
			String url = ele.getAttribute("href");
			verifyLinkIsActive(url);
		}
		
		
	}

	private static void verifyLinkIsActive(String urlLink) {
		try{
				URL url = new URL(urlLink);
				HttpURLConnection httoURLConnect = (HttpURLConnection)url.openConnection();
				httoURLConnect.setConnectTimeout(3000);
				
				httoURLConnect.connect();
				if (httoURLConnect.getResponseCode()==200){
					System.out.println(urlLink + "-"+httoURLConnect.getResponseMessage());
				}
				if (httoURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
					System.out.println(urlLink + " - "	+httoURLConnect.getResponseMessage() + " - " 
														+HttpURLConnection.HTTP_NOT_FOUND);
					}
			}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
