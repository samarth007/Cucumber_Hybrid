package Steps;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import Pages.AddCustomer_page;
import Pages.HomePage;
import Pages.LoginPage;
import Utils.DriverFactory;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Add_Customer_Steps {

	private HomePage hp = new HomePage(DriverFactory.getDriver());
	private AddCustomer_page acust = new AddCustomer_page(DriverFactory.getDriver());
	
	@Given("^User has logged in to application$")
	public void user_has_logged_in_to_application(DataTable credential) throws Throwable {
	
		DriverFactory.getDriver().get("http://demo.guru99.com/V4/");
		LoginPage lp = new LoginPage(DriverFactory.getDriver());
		List<Map<String,String>> d=  credential.asMaps(String.class, String.class);
		String username =d.get(0).get("username");
		String password =d.get(0).get("password");
		hp=lp.doLogin(username, password);
	}

	@When("^user clicks on the New Customer tab\\.$")
	public void user_clicks_on_the_New_Customer_tab() throws Throwable {
	  
		acust =hp.newcust();
	}

	@When("^Enters the Customer Details$")
	public void enters_the_Customer_Details(DataTable details) throws Throwable {
	
		List<Map<String,String>> b =details.asMaps(String.class, String.class);
		
		for(Map<String, String> s : b) {
			acust.name(s.get("customer name"));
			acust.Addrs(s.get("address"));
			acust.gen();
			acust.cit(s.get("city"));
			acust.Sttate(s.get("state"));
			acust.pin(s.get("pin"));
			acust.mobnum(s.get("mobile number"));
			acust.maill(s.get("e-mail"));
			acust.pwd(s.get("password"));
			acust.Dob("24","02","1997");
		}
		/*acust.name(b.get(0).get("customer name"));
		acust.gen();
		acust.Addrs(b.get(0).get("address"));
		acust.cit(cti);*/
	}

	@When("^Clicks on the submit$")
	public void clicks_on_the_submit() throws Throwable {
	
		acust.sbmit();
	}

	@Then("^Cutsomer should register successfully with message \"([^\"]*)\"$")
	public void cutsomer_should_register_successfully_with_message(String msg) throws Throwable {
	 
		Assert.assertTrue(acust.getPageSrc().contains(msg));
	}
	
	
}
