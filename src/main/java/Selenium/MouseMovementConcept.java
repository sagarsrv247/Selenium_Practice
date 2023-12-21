package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://economictimes.indiatimes.com/topic/rediffmail");
		
	
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.linkText("News"))).build().perform();
		
		Thread.sleep(10000);
		driver.findElement(By.linkText("India")).click();
		
		
	}

}
