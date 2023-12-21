package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuth {
	public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	//http://username:password@test.com
	
	driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	String pageMessage = driver.findElement(By.cssSelector("#content > div > p")).getText();
	System.out.println(pageMessage);

}

}