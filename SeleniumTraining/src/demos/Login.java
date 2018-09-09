package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	public static void main(String[] args) {
		// 0. OS check
		final String OSNAME = System.getProperty("os.name").toLowerCase();
		
		// 1. Define the web driver
		if (OSNAME.equals("mac")) {
			System.setProperty("webdriver.chrome.driver", "/Users/woohyeok.kim/Desktop/study/selenium-webdriver/chromedriver");
		} else{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\woosy\\Desktop\\dev\\selenium-webdriver\\chromedriver.exe");
		}
		WebDriver driver = new ChromeDriver();
		
		// 2. Open web browser and navigate to page
		// http://sdettraining.com/trguitransactions/AccountManagement.aspx
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// Find elements: 
		// Locate the element, Determine the action, Pass any parameters
		
		// 3. Enter email address
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys("woosyume@gmail.com");
		
		// 4. Enter password
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys("1234");
		
		// 5. Click login
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
		
		// 6. Get confirmation
		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("CONFIRMATION: " + message);
		
		String pageTitle = driver.getTitle();
		if (pageTitle.equals("SDET Training | Account Management")) {
			System.out.println("PAGE TITLE TEST PASSED");
		}
		
		// 7. Close the browser
		driver.close();
	}
}
