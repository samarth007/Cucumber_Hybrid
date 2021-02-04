package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	private By emailId = By.name("uid");
	private By password = By.name("password");
	private By logIn = By.name("btnLogin");
	private By forgotPassword = By.xpath("//a[text()='Forgot Password?']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void enterUsername(String user) {
		driver.findElement(emailId).sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public boolean isForgotPassword() {
		return driver.findElement(forgotPassword).isDisplayed();
	}
	
	public void ClickLogin() {
		driver.findElement(logIn).click();
	}
	
	public HomePage doLogin(String user, String pass) {
		driver.findElement(emailId).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
	    driver.findElement(logIn).click();
	     return new HomePage(driver);
	}
}
