package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import demo.utilities.DriverFactory;

public class NewAccount {
	public static void main(String[] args) {
		String name = "Reika";
		String email = "testReika@gmail.com";
		String password = "password";
		String country = "Denmark";
		String phoneNumber = "08036902222";
		String gender = "Female";
		String weeklyEmail;
		String montjlyEmail;
		String occasionalEmail;
		String browserType = "chrome";

		// 1. Define web driver
		WebDriver driver = null;
		driver = DriverFactory.openWebDriver(browserType);
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		//driver.findElement(By.linkText("Create Account")).click(); <-- TODO not works. why?
		driver.findElement(By.xpath("//*[@id='ctl01']/div[3]/div[2]/div/div[2]/a")).click();
		
		// 2. Open Browser to Account Management Page >> Click and Create Account
		WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneElememnt = driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']"));
		WebElement passwordElement = driver.findElement(By.cssSelector("input[type='password']"));
		WebElement verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		WebElement femaleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
		WebElement maleRadio = driver.findElement(By.id("MainContent_Male"));
		
		
		// 3. Fill out the form
		// How to locate elements
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElememnt.sendKeys(phoneNumber); // rel XPath.
		
		//driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys("password");
		passwordElement.sendKeys(password);
		verifyPasswordElement.sendKeys(password);
		
		// How to interact with the other elements
		// Radio button
		//driver.findElement(By.id("MainContent_Female")).click();
		//driver.findElement(By.cssSelector("input[name='ctl00$MainContent$Gender'][value='Male']")).click();
		if (gender.equalsIgnoreCase("Female")) {
			femaleRadio.click();
		} else {
			maleRadio.click();
		}

		// for drop-down
		new Select(countryElement).selectByVisibleText(country);
		driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		
		// 4. Get confirmation & close browser
		String result = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		System.out.println("RESULT: " + result);
		
		// 5. Close the browser
		driver.close();
	}
}
