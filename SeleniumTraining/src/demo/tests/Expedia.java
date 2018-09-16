package demo.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demo.utilities.DriverFactory;

public class Expedia {
	private WebDriver driver;
	private String browserType = "chrome";
	
	@Test
	public void hotelReservationTest() {
		// 1. Search
		
		// 2. Modify the search results page, give criteria
		
		// 3. Analyze the results and make our selection
		
		// 4. Book reservation
		
		// 5. Fiil out contact / billing
		
		// 6. Get confirmation
	}
	
	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.openWebDriver(browserType );
		driver.get("https://www.expedia.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
