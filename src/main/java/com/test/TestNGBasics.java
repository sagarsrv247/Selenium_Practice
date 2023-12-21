package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	/*
@BeforeSuite - Setup Property of chrome.
@BeforeTest - Launch Browser
@BeforeClass - login to Browser
@BeforeMethod - Enter URL
@Test - Google Title test case
@AfterMethod - logout method
@BeforeMethod - Enter URL
@Test - Search test case
@AfterMethod - logout method
@AfterClass - Close Chrome Browser
@AfterTest - Delete all cookies
	 */
	
	
	
	//Pre-conditions annotations - starting with @Before
	
	@BeforeSuite     //1
	public void setUp()
	{
		System.out.println("@BeforeSuite - Setup Property of chrome.");
	}
	
	@BeforeTest   //2 
	public void launchBrowser()
	{
		System.out.println("@BeforeTest - Launch Browser");
	}
	
	
	@BeforeClass  //3
	public void login()
	{
		System.out.println("@BeforeClass - login to Browser");
		
	}


	@BeforeMethod  //4 
	public void enterUrl()
	{
		System.out.println("@BeforeMethod - Enter URL");
	}
	
	//Test cases -starting with @Test
	@Test  //5
	public void googleTitleTest()
	{
		System.out.println("@Test - Google Title test case");
	}
	
	@Test
	public void searchTest()  // pair will be formed with BeforeMethod, test and After Method for each test cases
	{
		System.out.println("@Test - Search test case");
	}
	
	
	//Post-condtions annotations - starting with @After
	@AfterMethod  //6
	public void logOut()
	{
		System.out.println("@AfterMethod - logout method");
	}
	
	@AfterClass  //7
	public void closeBrowser()
	{
		System.out.println("@AfterClass - Close Chrome Browser");
		
	}
	
	
	@AfterTest //8
	public void deleteAllCookies()
	{
		
			System.out.println("@AfterTest - Delete all cookies");	
		
	}
	
	@AfterSuite //9
	public void generateTestReport()
	{
		System.out.println("@AfterSuite - Generate test report.");
	}

}
