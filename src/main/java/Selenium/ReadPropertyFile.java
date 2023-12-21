package Selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadPropertyFile {

	static WebDriver driver ;
	
	public static void main(String[] args) throws IOException {

		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream(
				"C:\\Users\\Admin\\eclipse-workspace\\MySeleniumSessionClasses\\src\\main\\java\\Selenium\\config.properties");

		prop.load(ip);

		System.out.println(prop.getProperty("name"));
		System.out.println(prop.getProperty("age"));
		System.out.println(prop.getProperty("URL"));
		System.out.println(prop.getProperty("browser"));

		String url = prop.getProperty("URL");
		String browserName = prop.getProperty("browser");

		//for selecting any browser just change it in the properties file
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			 driver = new ChromeDriver();  //launch chrome
		}
		// can set else if for firefox driver
		// can set else if for internet explorer
		
		driver.get(url);
		
	}

}
