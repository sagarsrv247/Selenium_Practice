package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

public class SpecialLocators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		//can check an element with multiple locators with the comma clause. Will check from left to right.
		driver.findElement(new ByAll(By.name("email"), By.id("email"), By.xpath("//*[@id=\"email\"]"))).sendKeys("Sagar"); 
	
		driver.findElement(new ByIdOrName("email")).sendKeys("Sagar"); // for id or name locator
		
		driver.findElement(new ByChained(By.className("_6lux"), By.name("email"))).sendKeys("Sagar"); // for parent child elements sequence.
		

	}

}
