package demo.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	private String starRating = "star5";
	
	@Test
	public void hotelReservationTest() {
		// 1. Search
		driver.findElement(By.id("tab-hotel-tab-hp")).click();
		driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
		driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
		
		driver.findElement(By.id("hotel-checkout-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOutDate);
		
		driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkInDate);
		
		driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(Keys.ENTER);
		// 일단 이렇게 우회해서 테스트 자체는 통과하게 되었다. 그런데 서치버튼을 누르는게 아니라 어디까지나 엔터이기 때문에 다른건데...음...

		//체크인 날짜를 입력하면 자동으로 체크아웃이 입력되어 이중으로 입력이 된다. 해결책은 아마 아래와 같을 것인데 왠지 모르지만 해결되지 않았다.
		//WebElement toClear = driver.findElement(By.id("hotel-checkout-hp-hotel"));
		//WebElement toClear = driver.findElement(By.xpath("//*[@id=\"hotel-checkout-hp-hotel\"]"));
		//toClear.sendKeys(Keys.chord(Keys.CONTROL, "a"), checkOutDate);
		//toClear.sendKeys(Keys.DELETE);
		//toClear.sendKeys(checkOutDate);
		//toClear.clear();
		
		//new Select(driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/button"))); ...セレクトボックスの場合は、こんな感じ！
		//WebElement travelers = driver.findElement(By.xpath("//*[@id=\"traveler-selector-hp-hotel\"]/div/ul/li/button"));

		// This will enable this element if element is invisible      
		//String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		// Execute the Java Script for the element which we find out
		//((JavascriptExecutor) driver).executeScript(js, travelers);
		//travelers.click();
		
		//driver.findElement(By.xpath("//*[@id=\"search-button-hp-package\"]")).submit();
		//driver.findElement(By.id("search-button-hp-package")).click();
		
		
		// Print 
		String actualCity = driver.findElement(By.xpath("//*[@id=\"hotelResultTitle\"]/h1")).getText();
		System.out.println("CITY: " + actualCity);
		
		// 2. Modify the search results page, give criteria
		driver.findElement(By.cssSelector("#" + starRating)).click();
		
		// 3. Analyze the results and make our selection
		
		// 4. Book reservation
		
		// 5. Fiil out contact / billing
		
		// 6. Get confirmation
	}
	
	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.openWebDriver(browserType);
		// 각 요소가 다 뜨기전에 라이브러리에서 접근하기 때문에 NoSuchElement가 나온다. 그것에 대한 방지책
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.expedia.com/");
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
}
