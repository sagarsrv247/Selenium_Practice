package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://twitter.com/i/flow/signup");
		
		Select select = new Select(driver.findElement(By.linkText("Resources")));
		select.selectByVisibleText("Community");
		
	
	}

}
