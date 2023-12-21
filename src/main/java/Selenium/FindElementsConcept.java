package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public final class FindElementsConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediffmailpro.com/cgi-bin/login.cgi");
		
		//get the total count of links in the page.
		List <WebElement> linklist =  driver.findElements(By.tagName("a"));
		
		//size of linklist
		System.out.println(linklist.size());
		
		//get the text of each link in the page.
		
		for(int i =0;i<linklist.size();i++)
		{
			System.out.println(linklist.get(i).getText());
		}
	}

}
