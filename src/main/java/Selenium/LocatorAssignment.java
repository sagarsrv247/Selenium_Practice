package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
		
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Sagar");
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("Srivastava");
		driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys("sagarsrv247@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("abc123");
		driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys("abc123");

	}

}
