 
package Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopupHandle {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediffmailpro.com/cgi-bin/login.cgi");
		
		Thread.sleep(5000);
		
		driver.findElement(By.cssSelector("#dd1 > form > input:nth-child(9)")).click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText()); 
		
		
		String text = alert.getText();
		
		if(text.equals("Please enter email address")) {
			System.out.println("Correct alert message");
		}
		else
		{
			System.out.println("Incorrect alert message");
		}
		
		alert.accept(); //click on ok button
		//alert.dismiss(); //click on cancel button

	}

}
