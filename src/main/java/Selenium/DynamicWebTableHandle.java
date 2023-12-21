
//checking a radiobutton in a webtable.

package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice-webtable/");

		//Method - 1 (Standard Method)
		/*
		 * /html/body/div[2]/div/div/main/article/div/div/table/tbody/tr[2]/td[2]/strong
		 * /html/body/div[2]/div/div/main/article/div/div/table/tbody/tr[3]/td[2]/strong
		 * /html/body/div[2]/div/div/main/article/div/div/table/tbody/tr[4]/td[2]/strong
		 * /html/body/div[2]/div/div/main/article/div/div/table/tbody/tr[5]/td[2]/strong
		 */

		String before_xpath = "/html/body/div[2]/div/div/main/article/div/div/table/tbody/tr[";
		String after_xpath = "]/td[2]/strong";
		for (int i = 2; i <= 5; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if (name.contains("Algeria")) {
				/// html/body/div[2]/div/div/main/article/div/div/table/tbody/tr[4]/td[1]/input
				driver.findElement(
						By.xpath("html/body/div[2]/div/div/main/article/div/div/table/tbody/tr[" + i + "]/td[1]/input"))
						.click();
			}
		}
		
		
		//Method 2 - using custom xpath of the particular radio buttoon

	}

}
