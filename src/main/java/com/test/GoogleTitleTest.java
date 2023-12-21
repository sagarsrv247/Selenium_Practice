package com.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class GoogleTitleTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://www.google.com");
	}
	
	@Test
	public void googleTitleTest()
	{
		String title = driver.getTitle();
		Assert.assertEquals(title, "Google123", "Title is not matching"); //assertion for validation
		
	}
	
	@Test(priority=2, groups="Logo")
	public void googleLogoTest()
	{
		boolean b = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img")).isDisplayed();
		Assert.assertTrue(b); //assertion for validation
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
