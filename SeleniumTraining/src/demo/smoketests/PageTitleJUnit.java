package demo.smoketests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import demo.utilities.DriverFactory;

public class PageTitleJUnit {
	private WebDriver driver;
	String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";

	@Test
	public void pageTitleTest() {
		System.out.println("Running the test");
		driver.get(webUrl);

		String actualTitle = driver.getTitle();
		String expectedTitle = "SDET Training | Account Management";
		
		Assert.assertEquals(expectedTitle, actualTitle);
		//Assert.fail("We intentionally failed this  test.");
	}
	
	@Before
	public void setUp() {
		System.out.println("Initializing the driver");
		driver = new DriverFactory().openWebDriver("chrome");

	}
	
	@After
	public void tearDown() {
		System.out.println("Closing the test");
		driver.close();
	}
}
