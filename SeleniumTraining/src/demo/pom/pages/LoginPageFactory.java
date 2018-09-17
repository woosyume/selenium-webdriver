package demo.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	private WebDriver driver;
	
	// Define web elements at class level
	@FindBy(id="MainContent_txtUserName")
	private WebElement usernameField;
	
	@FindBy(id="MainContent_txtPassword")
	private WebElement passwordField;
	
	@FindBy(id="MainContent_btnLogin")
	private WebElement submitButton;
	
	// Steps
	public void setUserName(String username) {
		usernameField.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickSubmit() {
		submitButton.click();
	}
	
	// Actions
	public  void login(String username, String password) {
		this.setUserName(username);
		this.setPassword(password);
		this.clickSubmit();
	}
	
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		// Quick start to set values
		PageFactory.initElements(driver, this);
	}
}
