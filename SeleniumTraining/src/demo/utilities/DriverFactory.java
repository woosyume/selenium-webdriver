package demo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	// This method returns a WebDriver obkect
	public static WebDriver openWebDriver(String browserType) {
		final String OSNAME = System.getProperty("os.name").toLowerCase();

		if (browserType.equals("chrome")) {
			// 1. Define the web driver
			if (OSNAME.contains("mac")) {
				System.setProperty("webdriver.chrome.driver", "/Users/woohyeok.kim/Desktop/study/selenium-webdriver/chromedriver");
			} else{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\woosy\\Desktop\\dev\\selenium-webdriver\\chromedriver.exe");
			}
			return new ChromeDriver();
			
		} else if (browserType.equalsIgnoreCase("IE")) {
			return null;
			
		}else {
			// 1. Create web driver
			if (OSNAME.contains("mac")) {
				System.setProperty("webdriver.gecko.driver", "/Users/woohyeok.kim/Desktop/study/selenium-webdriver/geckodriver");
			} else{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\woosy\\Desktop\\dev\\selenium-webdriver\\geckodriver.exe");
			}
			return new FirefoxDriver();	
		}
	}
}
