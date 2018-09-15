package demo.smoketests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demo.utilities.DriverFactory;

public class ATagsTest {
	private WebDriver driver;

	@Test
	public void aTagsLinksTest() {
		System.out.println("Running test");
		boolean createAccountPresent = false;
		
		// We wanna test the presence of A tags >> hyperlinks
		List<WebElement> aElements =  driver.findElements(By.tagName("a"));
		
		for (WebElement aElement : aElements) {
			System.out.println(aElement.getText());
			if (aElement.getText().equals("CREATE ACCOUNT")) {
				createAccountPresent = true;
				break;
			}
		}
		
		// Assertion
		assertTrue(createAccountPresent);
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
