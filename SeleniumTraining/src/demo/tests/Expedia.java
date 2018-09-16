package demo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demo.utilities.DriverFactory;

public class Expedia {
	private WebDriver driver;
	private String browserType = "chrome";
	private String city = "New York, New York";
	private String checkInDate = "10/26/2018";
	private String checkOutDate = "10/30/2018";
	
	
	@Test
	public void hotelReservationTest() {
		// 1. Search
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkInDate);
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkInDate);
		
		//new Select(driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/button"))); ...セレクトボックスの場合は、こんな感じ！
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/button"));

		// This will enable this element if element is invisible      
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		
		// Execute the Java Script for the element which we find out
		((JavascriptExecutor) driver).executeScript(js, element);
		
		element.click();
		
		
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
