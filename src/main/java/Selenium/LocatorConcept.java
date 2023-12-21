//Different types of locators in a page

package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		/*
		//1)xpath - should not be hierarchy based --2nd priority
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("9047388638");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("$agar@social8991;");
		driver.findElement(By.xpath("//*[@id=\"u_0_0_tZ\"]")).click();
		
		//2)id --1st priority
		driver.findElement(By.id("email")).sendKeys("9047388638");
		driver.findElement(By.id("pass")).sendKeys("9047388638");
		
		//3)name --3rd priority
		driver.findElement(By.name("email")).sendKeys("9047388638");
		driver.findElement(By.name("pass")).sendKeys("9047388638");
		
		//4)linktext (for links only)
		driver.findElement(By.linkText("Forgotten password?")).click();
		
		
		//5)partiallinktext - not recommended
		driver.findElement(By.partialLinkText("Forgotten")).click();
		

		//6)CSS Selector - "#+IDNAME" --2nd priority
		driver.findElement(By.cssSelector("#email")).sendKeys("9047388638");
		
		
		//7)class - not recommended(classnames can be duplicates) --4th priority
		driver.findElement(By.className("inputtext _55r1 _6luy")).sendKeys("9047388638");
		
		*/
		
	}

}
