package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/index.html");

		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		
		WebElement loginbtn =  driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
		flash(loginbtn, driver); //highlight an element

		
		drawBorder(loginbtn, driver);  // border an element for issue
		
		//put your screenshot script here
		
		//generate alert
		//generateAlert(driver, "There is an issue with the login button.");
		
		
		clickElementByJS(loginbtn, driver);
	
		refreshBrowserByJS(driver); // for refreshing a page in the browser
		
		System.out.println(getTitleByJS(driver)); // for getting the title of the page.
		
		System.out.println(getPageInnerText(driver));
		
		//scrollPageDown(driver); // for scrolling completely down.
		
		WebElement tshirt = driver.findElement(By.linkText("Sauce Labs Onesie"));
		
		scrollIntoView(tshirt, driver); // for scrolling till a particular element
	}

	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 100; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgcolor, element, driver);
		}

	}

	public static void changeColor(String color, WebElement element, WebDriver driver) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {

		}

	}
	
	public static void drawBorder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border = '3px solid yellow'", element);
		
	}
	

	
	
	public static void generateAlert(WebDriver driver, String message)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
		
	}
	
	
	public static void clickElementByJS(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public static void refreshBrowserByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
		
	}
	public static String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String title = js.executeScript("return document.title;").toString();
		
		return title;
	}
	
	public static  String getPageInnerText(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void scrollPageDown(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
