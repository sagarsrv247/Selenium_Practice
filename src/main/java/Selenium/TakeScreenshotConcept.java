package Selenium;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class TakeScreenshotConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		//take screenshot and store it as a file format
		//File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//now copy the screenshot to the desired location using copyfile method.
		//FileHandler.copyFile(src,new File("C:\\Users\\Admin\\eclipse-workspace\\MySeleniumSessionClasses\\google.png"));

		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		//File DestFile=new File(fileWithPath);
		//Copy file at destination
		//FileUtils.copyFile(SrcFile, DestFile);
		
	}

}
