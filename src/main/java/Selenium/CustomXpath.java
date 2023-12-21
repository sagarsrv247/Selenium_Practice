package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ebay.com");
		
		//Custom xpaths are more powerful than the Absolute xpaths. Absolute xpaths are not recommended.
		//Absoulte xpaths are relatively slower than Custom xpaths.
		//Absolute xpaths are not reloable and can be changed at any time in future.
		
		//relative xpaths:
		
		//driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Java");
		//driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys("Java2");
		
		//driver.findElement(By.xpath("//input[contains(@class,'gh-tb ui-autocomplete-input')]")).sendKeys("Java3"); //using contains function
		
		//driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("Java4"); //using starts with.
		
		//driver.findElement(By.xpath("//input[ends-with(@id,'_test')]")).sendKeys("Java4"); //using ends with
		
		
		//for links - all links are in <a> tag in html:
		
		driver.findElement(By.xpath("//a[contains(text(), 'Sell')]")).click();
		
	}
	
	

}
