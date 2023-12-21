/*
Difference between isDisplayed(), isEnabled() and isSelected() Methods in Selenium WebDriver:

1. isDisplayed() is the method used to verify the presence of a web element within the web page. The method returns a “true” value if the specified web element is present on the web page and a “false” value if the web element is not present on the webpage.
2. isDisplayed() is capable to check for the presence of all kinds of web elements available.
3. isEnabled() is the method used to verify if the web element is enabled or disabled within the web page.
4. isEnabled() is primarily used with buttons.
5. isSelected() is the method used to verify if the web element is selected or not. 6. isSelected() method is predominantly used with radio buttons, dropdowns and checkboxes.
*/

package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://parabank.parasoft.com/parabank/register.htm");
		
		//isDisplayed() > applicable for all the elements. To check whether an element is displayed on the page is not.
		boolean b1 = driver.findElement(By.className("button")).isDisplayed();
		System.out.println(b1);
		
		//isEnabled() > to check whether an element is enabled or not
		boolean b2 = driver.findElement((By.className("button"))).isEnabled();
		System.out.println(b2);
		
		//isSelected() > only applicable for checkboxes, dropdown and radiobuttons.
		
		driver.navigate().to("https://parabank.parasoft.com/parabank/admin.htm");
		boolean b3 = driver.findElement(By.xpath("//*[@id=\"accessMode1\"]")).isSelected();
		System.out.println(b3);
		
		
		driver.findElement(By.xpath("//*[@id=\"accessMode1\"]")).click();
		boolean b4 = driver.findElement(By.xpath("//*[@id=\"accessMode1\"]")).isSelected();
		System.out.println(b4);
		
	}

}
