package Selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws MalformedURLException, IOException {

		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rediffmailpro.com/cgi-bin/login.cgi");
		
		//1)Get the list of all the links and images
		
		List<WebElement> linkslist = driver.findElements(By.tagName("a"));
		linkslist.addAll(driver.findElements(By.tagName("img")));
		
		
		System.out.println("Available links and images: "+linkslist.size());
		
		List<WebElement> activeLinks = new ArrayList<WebElement>();
		
		//2)iterate the linkslist with for loop ->exclude all the links and images which doesnt have any href attributes.
		
		for(int i=0;i<linkslist.size();i++)
		{
			System.out.println(linkslist.get(i).getAttribute("href"));
			if(linkslist.get(i).getAttribute("href")!=null && (!linkslist.get(i).getAttribute("href").contains("javascript")) )  //exclude the null href and javascripts.
			{
				activeLinks.add(linkslist.get(i));
			}
		}
		 //3 get the size of active links list
		System.out.println("Size of active links and images: "+activeLinks.size());
		
		
		//4 Check the href url with the httpconnection api.
		//200 > ok
		//404 > not found
		//500  internal error
		//400 -- bad request
		
		for(int j=0;j<activeLinks.size();j++)
		{
			HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();  //ok
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+" --> "+response);
			}
	}

}
