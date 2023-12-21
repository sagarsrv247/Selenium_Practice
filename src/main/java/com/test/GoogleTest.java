package com.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
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
	
	@Test(priority=1, groups="Title")
	public void googleTitleTest()
	{
		String title = driver.getTitle();
		
	}
	
	@Test(priority=2, groups="Logo")
	public void googleLogoTest()
	{
		boolean b = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/img")).isDisplayed();
	}
	
	@Test(priority=3, groups="Link Test")
	public void mailLinkTest()
	{
	boolean b = driver.findElement(By.linkText("Gmail")).isDisplayed();
	}
	
	@Test(priority=4, groups="Test")
	public void test4()
	{
		System.out.println("Test4");
	}
	@Test(priority=5, groups="Test")
	public void test5()
	{
		System.out.println("Test5");
	}
	@Test(priority=6, groups="Test")
	public void test6()
	{
		System.out.println("Test6");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
