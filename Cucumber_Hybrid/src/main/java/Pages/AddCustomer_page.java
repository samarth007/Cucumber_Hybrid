package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer_page {

	 WebDriver driver;
	
	@FindBy(name="name")
	WebElement custname;
	
	@FindBy(name="rad1")
	WebElement gender;
	
	@FindBy(name="dob")
	WebElement dateofbirth;
	
	@FindBy(name="addr")
	WebElement address;
	
	@FindBy(name="city")
	WebElement citi;
	
	@FindBy(name="state")
	WebElement statee;
	
	@FindBy(name="pinno")
	WebElement pinum;
	
	@FindBy(how=How.NAME,  using="telephoneno")
	WebElement mob;
	
	@FindBy(how=How.NAME,  using="emailid")
	WebElement mailid;

	@FindBy(how=How.NAME,  using="password")
	WebElement password;

	@FindBy(how=How.NAME,  using="sub")
	WebElement submit;

	public AddCustomer_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void name(String cname) {
		custname.sendKeys(cname);
	}
	
	public void gen() {
		gender.click();
	}
	
	public void Dob(String dd, String mm, String yy) {
		dateofbirth.sendKeys(dd);
		dateofbirth.sendKeys(mm);
		dateofbirth.sendKeys(yy);
	}
	
	public void Addrs(String add) {
		address.sendKeys(add);
	}
	
	public void cit(String cti) {
		citi.sendKeys(cti);
	}
	
	public void Sttate(String stte) {
		statee.sendKeys(stte);
	}
	
	public void pin(String p) {
		pinum.sendKeys(p);
	}
	
	public void mobnum(String m) {
		mob.sendKeys(m);
	}
	
	public void maill(String maill) {
		mailid.sendKeys(maill);
	}
	
	public void pwd(String pd) {
		password.sendKeys(pd);
	}
	
	public void sbmit() {
		submit.click();
	}
	
	public String getPageSrc() {
		return driver.getPageSource();
	}
}
