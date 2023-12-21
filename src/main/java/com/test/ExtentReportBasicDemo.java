package com.test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.*;
public class ExtentReportBasicDemo {

	
	static WebDriver driver;
	public static void main(String[] args) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");

		//create Extent Reports and attach Reporters
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
		ExtentTest test1 = extent.createTest("Google Search Test one", "This is a test to validate google search");
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		test1.log(Status.INFO, "Starting Test Case");
		driver.get("http://www.google.com");
		test1.pass("Navigated to Google.com");
		
		driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("Test Automation");
		test1.pass("Entered text in SearchBox");
		
		driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.ikrT4e.om7nvf > form > div:nth-child(1) > div.A8SBwf > div.FPdoLc.lJ9FBc > center > input.gNO89b")).click();
		
		test1.pass("Pressed the enter key");
		
		
		driver.close();
		driver.quit();
		
		test1.pass("Closed the browser");
		test1.info("Test Completed");
		
		
		extent.flush();
	}

}
