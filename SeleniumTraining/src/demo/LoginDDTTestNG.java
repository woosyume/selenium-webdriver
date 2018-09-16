package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import demo.utilities.Excel;

public class LoginDDTTestNG {
	private WebDriver driver;
	
	@Test(dataProvider = "getData")
	public void LoginTest(String name, String email, String password) {
		System.out.println("NEW RECORD: " + name + " " + email + 	" " + password);
		
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email);
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password);
		driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();

		String message = driver.findElement(By.id("conf_message")).getText();
		System.out.println("CONFIRMATION: " + message);
	}
	
	@DataProvider
	public String[][] getData() {
		String filename = "/Users/woohyeok.kim/Downloads/UserLogin.xls";
		return Excel.get(filename);
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("hibitu");
		final String OSNAME = System.getProperty("os.name").toLowerCase();
		if (OSNAME.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", "/Users/woohyeok.kim/Desktop/study/selenium-webdriver/chromedriver");
		} else{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\woosy\\Desktop\\dev\\selenium-webdriver\\chromedriver.exe");
		}
		driver = new ChromeDriver();
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
