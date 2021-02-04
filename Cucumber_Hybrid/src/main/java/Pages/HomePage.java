package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement addcust;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logout;
	
	@FindBy(xpath="//a[contains(text(),'New Account')]")
	WebElement newAcc;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public AddCustomer_page newcust() {
		addcust.click();
		AddCustomer_page acust = new AddCustomer_page(driver);
		return acust;
	}
	
	public void logoutt() {
		logout.click();
	}
	
	public Add_Account_Page addAcc() {
		 newAcc.click();
		 Add_Account_Page account = new Add_Account_Page(driver);
		 return account;
	}
}
