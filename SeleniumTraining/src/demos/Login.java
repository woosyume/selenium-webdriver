package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static void main(String[] args) {
		// 1. Define the web driver
		System.setProperty("webdriver.chrome.driver", "/Users/woohyeok.kim/Desktop/study/selenium-webdriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		// 2. Open web browser and navigate to page
		// http://sdettraining.com/trguitransactions/AccountManagement.aspx
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// Find elements: 
		// Locate the element, Determine the action, Pass any parameters
		
		// 3. Enter email address
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("woosyume@gmail.com");
		
		// 4. Enter password
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("[password]");
		
		// 5. Click login
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		
		// 6. Get confirmation
		
		// 7. Close the browser
	}
}
