package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		
		driver.findElement(By.name("email")).sendKeys("sagarsrv247@gmail.com");
		driver.findElement(By.name("password")).sendKeys("13122Sagar@1998");

		driver.findElement(By.cssSelector("#ui > div > div > form > div > div.ui.fluid.large.blue.submit.button")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("#main-nav > div:nth-child(3) > a > span")).click();
		
		
	}

}
