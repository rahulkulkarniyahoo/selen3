package mytest;
import java.io.IOException;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
public class VerifyBrokenImages {
	int invalidImages;
	WebDriver driver;
	
	@Before
	public void startUp(){
		driver = BrowserFactory.startBrowser("chrome", "https://www.google.co.uk");
	}
	@After
	public void tearDown(){
		driver.close();
		driver.quit();
	}
	
	@Test
	public void validateImages(){
		
		invalidImages = 0;
		List<WebElement> listOfImages = driver.findElements(By.tagName("img"));
		System.out.println("Total Number of Images = " + listOfImages.size());
		
		for(WebElement imgElement: listOfImages){
			System.out.println(imgElement.getText());
			
			if (imgElement!=null){
				verifyImageStatus(imgElement);
			}
				
		}
		System.out.println("Total Number of Invalid Images = " + invalidImages);
	}



	private void verifyImageStatus(WebElement imgElement) {
		try{
			HttpClient httpClient=HttpClientBuilder.create().build();
			String srcElement = imgElement.getAttribute("src");
			HttpGet httpRequest = new HttpGet(srcElement);
			
			HttpResponse httpResponse = httpClient.execute(httpRequest);
			StatusLine httpResponseLine = httpResponse.getStatusLine();
			int responseCode = httpResponseLine.getStatusCode();
			
			if (responseCode !=200){
				invalidImages++;
			}
			
		}
		catch (IOException e){
			e.printStackTrace();
		}
		
	}

		

}
