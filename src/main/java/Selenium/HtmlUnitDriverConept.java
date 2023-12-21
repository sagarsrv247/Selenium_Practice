//For headless browser testing. Advantages: No browser is involved, Faster execution happens here.
//Disadvantage: Not suitable for action class - mouse movements, double click drag an drop.
//Also known as headless or ghost driver.

package Selenium;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitDriverConept {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		/*
		//WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new HtmlUnitDriver();
		
		// HTML Unit Driver is not available in Selenium 3.x version
		// we have to download Html unit driver jar file
		
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
	
		Thread.sleep(2000);
		
		System.out.println("After login, the title is :"+driver.getTitle());
		*/
	}

}
