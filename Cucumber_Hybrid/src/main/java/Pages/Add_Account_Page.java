package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Add_Account_Page {

	WebDriver driver;
	Select s;
	
	@FindBy(name="cusid")
	WebElement custid;
	
	@FindBy(name="inideposit")
	WebElement deposit;
	
	@FindBy(name="selaccount")
	WebElement actype;
	
	@FindBy(name="button2")
	WebElement submit;
	
	@FindBy(xpath="//table[@id='account']/descendant::tr[4]/child::td[2]")
	WebElement accountID;
	
	public Add_Account_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setCust(String custID) {
		 custid.sendKeys(custID);
	}
	
	public void setInDep(String amount) {
		 deposit.sendKeys(amount);
	}
	
	public void setActype(String AccType) {
	 s = new Select(actype);
	  s.selectByValue(AccType);
	}
	
	public void ClickSubmit() {
		submit.click();
	}
	
	public String getAccountID() {
		return accountID.getText();
	}
	
	public String getPageMsg() {
		return driver.getPageSource();
	}
}
