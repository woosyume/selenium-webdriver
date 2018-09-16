package demo;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import demo.utilities.CSV;
import demo.utilities.DriverFactory;

@RunWith(value = Parameterized.class)
public class NewAccountDDTJunit {
	private String name, email, phone, gender, password, country;
	private boolean weeklyEmail, monthlyEmail, occasionalEmail = false;
	WebDriver driver;
	WebElement nameElement, emailElement, phoneElememnt, passwordElement, verifyPasswordElement, countryElement, 
		femaleRadio, maleRadio, weeklyCheckBox, monthlyCheckBox,submitButton;
		
	// Constructor that parses parameters to the test method
	public NewAccountDDTJunit(String name, String email, String phone, String gender, String password, String country,
			String weeklyEmail, String monthlyEmail, String occasionalEmail) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.country = country;
		if (weeklyEmail.equals("TRUE")) this.weeklyEmail = true;
		if (monthlyEmail.equals("TRUE")) this.monthlyEmail = true;
		if (occasionalEmail.equals("TRUE")) this.occasionalEmail = true;
	}

	// This is our test method
	@Test
	public void newAccountTest() {
		System.out.println("New Record: " + name + " " + email + " " + phone + " " + gender + " " + password + " " + country + " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);

		defineWebElement();
		
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElememnt.sendKeys(phone); // rel XPath.
		passwordElement.sendKeys(password);
		verifyPasswordElement.sendKeys(password);
		
		// Radio button
		if (gender.equalsIgnoreCase("Female")) {
			femaleRadio.click();
		} else {
			maleRadio.click();
		}

		// for drop-down
		if (weeklyEmail) {
			if (!weeklyCheckBox.isSelected()) {
				weeklyCheckBox.click();
			}
		} else {
			if (weeklyCheckBox.isSelected()) {
				weeklyCheckBox.click();
			}
		}
		submitButton.click();
		
		// 4. Get confirmation & close browser
		String result = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String expected = "Customer information added successfully";
		
		if (result.contains(expected)) {
			System.out.println("RESULT: " + result);
		} else {
			System.out.println("TEST FAILED");
		}
	}
	
	
	// This annotated method is designed to pass parameters into the class via constructor
	@Parameters
	public static List<String[]> getData() {
		return CSV.get("/Users/woohyeok.kim/Downloads/UserAccounts.csv");
	}
	
	@Before
	public void setUp() {
		// 1. Define web driver
		driver = DriverFactory.openWebDriver("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("//*[@id='ctl01']/div[3]/div[2]/div/div[2]/a")).click();
	}
	
	@After
	public void tearDown() {
		// 5. Close the browser
		driver.quit();
	}
	
	public void defineWebElement() {
		// 2. Open Browser to Account Management Page >> Click and Create Account
		nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		phoneElememnt = driver.findElement(By.xpath("//*[@id='MainContent_txtHomePhone']"));
		passwordElement = driver.findElement(By.cssSelector("input[type='password']"));
		verifyPasswordElement = driver.findElement(By.name("ctl00$MainContent$txtVerifyPassword"));
		countryElement = driver.findElement(By.id("MainContent_menuCountry"));
		femaleRadio = driver.findElement(By.name("ctl00$MainContent$Gender"));
		maleRadio = driver.findElement(By.id("MainContent_Male"));
		weeklyCheckBox = driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail"));
		monthlyCheckBox = driver.findElement(By.id("MainContent_btnSubmit"));
		submitButton = driver.findElement(By.id("MainContent_btnSubmit"));
	}
}
