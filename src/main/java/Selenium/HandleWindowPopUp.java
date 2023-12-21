package Selenium;

import java.util.Iterator;
import java.util.Set;

// These are browser popups(new window opening in the browser) and not javascripts popups as used in the alerts.
// For these we use window handler API.

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.dummysoftware.com/popupdummy_testpage.html");
		driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/p[2]/font[1]/a")).click();
		
		
		Set<String> handler = driver.getWindowHandles(); // to store the unique window ids.
		Iterator<String> it = handler.iterator();
	
		String parentWindowId = it.next(); // first window id or the parent window id.
		System.out.println("Parent Window Id: "+parentWindowId);  // for shifting the iterator to the next window handle
		
		
		String childWindowId = it.next();  //next window id of the popup
		System.out.println("Child Window Id: "+childWindowId); 
		
		driver.switchTo().window(childWindowId); // for switching to the popup window
		
		System.out.println("Child window pop up title: "+driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindowId); //to switch back to parent window again as it does not switch by default
		
		System.out.println("Parent Window Title : "+driver.getTitle());
	}

}
