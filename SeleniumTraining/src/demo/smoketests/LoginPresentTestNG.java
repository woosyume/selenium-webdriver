package demo.smoketests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import demo.utilities.DriverFactory;

public class LoginPresentTestNG {
	private WebDriver driver;
	
	@Test
	public void loginElementsPresentTest() {
		boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
		boolean passwordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
		
		Assert.assertTrue(loginEmailBox, "Email box");
		Assert.assertTrue(passwordBox, "Password box");
		
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Starting test");
		driver = DriverFactory.openWebDriver("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");

	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing test");
		driver.close();
	}
}
