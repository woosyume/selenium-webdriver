package demo.pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import demo.pom.pages.DashBoardPage;
import demo.pom.pages.LoginPage;
import demo.utilities.DriverFactory;

public class Login {
	WebDriver driver;
	
	@Test
	public void loginTestPom() {
		// 2. Enter login information(Login page)
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUserName("woosyume@gmail.com");
		loginPage.setPassword("1234");
		loginPage.clickSubmit();
		
		// 3. Get Confirmation (Dashboard page)
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		String conf = dashBoardPage.confirmationMessage();
		String title = dashBoardPage.title();
		Assert.assertTrue(conf.contains("success"));
		Assert.assertTrue(title.contains("account"));
		
		
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
