package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import com.excel.utility.Xls_Reader;

public class WebTableHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		// /html/body/div[5]/div[1]/div[1]/div[3]/div/table/tbody/tr[2]/td[1]
		// /html/body/div[5]/div[1]/div[1]/div[3]/div/table/tbody/tr[3]/td[1]
		// /html/body/div[5]/div[1]/div[1]/div[3]/div/table/tbody/tr[4]/td[1]

		// /html/body/div[5]/div[1]/div[1]/div[3]/div/table/tbody/tr[7]/td[1]

		String beforeXpath_company = "/html/body/div[5]/div[1]/div[1]/div[3]/div/table/tbody/tr[";
		String afterXpath_company = "]/td[1]";

		String beforeXpath_contact = "/html/body/div[5]/div[1]/div[1]/div[3]/div/table/tbody/tr[";
		String afterXpath_contact = "]/td[2]";

		// For checking the number of rows in webtable
		List<WebElement> rows = driver.findElements(By.xpath("///table[@id='customers'//tr"));
		System.out.println("Total number of rows in the webtable: " + rows.size());
		int rowCount = rows.size();
		
	//	Xls_Reader xs = new Xls_Reader("");
		

		for (int i = 2; i <= 7; i++) {
			String actualXpath_company = beforeXpath_company + i + afterXpath_company;
			String companyName = driver.findElement(By.xpath(actualXpath_company)).getText();

			String actualXpath_contact = beforeXpath_contact + i + afterXpath_contact;
			String contactName = driver.findElement(By.xpath(actualXpath_contact)).getText();

			System.out.println(companyName);
			System.out.println(contactName);
		}

	}

}
