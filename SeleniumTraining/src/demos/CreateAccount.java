package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {
	public static void main(String[] args) {
		// 0. OS check
		final String OSNAME = System.getProperty("os.name").toLowerCase();

		// 1. Create web driver
		if (OSNAME.equals("mac")) {
			System.setProperty("webdriver.gecko.driver", "/Users/woohyeok.kim/Desktop/study/selenium-webdriver/geckodriver");
		} else{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\woosy\\Desktop\\dev\\selenium-webdriver\\geckodriver.exe");
		}
		WebDriver driver = new FirefoxDriver();	
		
		// 2. Open Browser to Account Management Page >> Click and Create Account
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		//driver.findElement(By.linkText("Create Account")).click(); <-- TODO not works. why?
		driver.findElement(By.xpath("//*[@id='ctl01']/div[3]/div[2]/div/div[2]/a")).click();
		
		// 3. Fill out the form
		
		// How to locate elements
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Reika");
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("testReika@gmail.com");
		driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']")).sendKeys("08036902222"); // rel XPath.
		
		//driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys("password");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("password");
		driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword")).sendKeys("password");
		
		// How to interact with the other elements
		driver.findElement(By.id("MainContent_Female")).click();
		//driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Male']")).click();

		// for drop-down
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByVisibleText("Denmark");
		driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		
		// 4. Get confirmation
		String result = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println("RESULT: " + result);
		
		// 5. Close the browser
		driver.close();
	}
}
