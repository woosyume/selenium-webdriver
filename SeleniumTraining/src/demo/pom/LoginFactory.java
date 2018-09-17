package demo.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import demo.pom.pages.DashBoardPage;
import demo.pom.pages.LoginPage;
import demo.pom.pages.LoginPageFactory;
import demo.utilities.DriverFactory;

public class LoginFactory {
	WebDriver driver;
	private String username = "woosyume@gmail.com";
	private String password = "1234";
	
	@Test
	public void loginTestPom() {
		// 2. Enter login information(Login page)
		LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
		loginPageFactory.login(username, password);
	}
	
	@Before
	public void setUp() {
		// 1. Initialize driver
		driver = DriverFactory.openWebDriver("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@After
	public void tearDown() {
		// 4. Close the driver
		driver.quit();
	}
}
