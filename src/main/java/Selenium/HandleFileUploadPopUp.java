package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopUp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://html.com/input-type-file/");
		
		driver.findElement(By.xpath("//*[@id=\"fileupload\"]")).sendKeys("D:\\abc.txt"); // file as attachment

	}

}
