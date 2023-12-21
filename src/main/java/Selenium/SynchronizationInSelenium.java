package Selenium;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationInSelenium {
	


	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		

		WebDriver driver = new ChromeDriver();
		
		
		
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);  //wait for 20 seconds till the page is loaded. //dynamic wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  //implicitly wait is applied globally , available for all the web elements. //dynamic wait

		driver.get("https://www.facebook.com");
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		
		sendKeys(driver, email, Duration.ofMinutes(1), "Tom");
		sendKeys(driver, password, Duration.ofMinutes(1), "password");
		
		Thread.sleep(1000); // Static wait. Will wait for entire period given in the parameters
		

	}
	
	//Explicitly wait is used for a particular web element. No keyword or predefined method is there. Dynamic in nature.
	//Explicitly wait is available with WebDriverWait with some ExpectedConditons.
	//Generic method for Explicitly wait for re-usability , used for AJAX components.
	
	public static void sendKeys(WebDriver driver, WebElement element, Duration timeout, String value)
	{
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	
	//Note:
	
	//Don't use implicitly wait and explicitly wait together. It will add both the waits indirectly.
	//For larger applications usually explicitly wait is used.
	//implicitly wait can be overriden and changed at any place as it is global wait for each element.
	

}
