package Steps;


import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import Pages.Add_Account_Page;
import Pages.HomePage;
import Utils.DriverFactory;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Add_Account_Steps {

	private Add_Account_Page account = new Add_Account_Page(DriverFactory.getDriver());
	
	@When("^user click on the New Account tab$")
	public void user_click_on_the_New_Account_tab() throws Throwable {
       	
		HomePage hp = new HomePage(DriverFactory.getDriver());
		account = hp.addAcc();
	}

	@When("^Enters the Account details$")
	public void enters_the_Account_details(DataTable details) throws Throwable {
	  		
		List<Map<String, String>> s =details.asMaps(String.class, String.class);
		for(Map<String, String> v : s) {
			account.setCust(v.get("customer id"));
			account.setActype(v.get("Account type"));
			account.setInDep(v.get("Deposit"));
		}
		
	}
	
	@When("^Clicks on the submit button$")
	public void clicks_on_the_submit_button() throws Throwable {
	 account.ClickSubmit();
	}

	@Then("^Account get genrated successfully with message \"([^\"]*)\"$")
	public void account_get_genrated_successfully_with_message(String msg) throws Throwable {
	
		Assert.assertTrue(account.getPageMsg().contains(msg));
	}

	@Then("^Capture the Account id$")
	public void capture_the_Account_id() throws Throwable {
	 String AccID = account.getAccountID();
		System.out.println(AccID);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String rep ="AccountID"+"_"+timeStamp;
		FileWriter f = new FileWriter(System.getProperty("user.dir")+"//AccountIDs//"+rep);
		f.write(AccID);
		f.close();
	}

}
