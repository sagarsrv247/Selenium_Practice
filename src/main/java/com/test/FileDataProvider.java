package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.datadriven.test.ReadXLSdata;

public class FileDataProvider {
	
	static WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
	}
	
	@Test(dataProviderClass=ReadXLSdata.class, dataProvider="regdata")
	public static void regTest(String name, String lname, String email, String pass, String passc)
	{
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys(name);
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(lname);
		driver.findElement(By.xpath("//*[@id=\"email_address\"]")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
		driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]")).sendKeys(passc);
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
