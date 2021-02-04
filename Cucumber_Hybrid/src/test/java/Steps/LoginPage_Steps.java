package Steps;


import org.testng.Assert;

import Pages.LoginPage;
import Utils.DriverFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage_Steps {

	String actualTitle;
	private LoginPage lp= new LoginPage(DriverFactory.getDriver()); 
	
	@Given("^user is on the loginpage$")
	public void user_is_on_the_loginpage() throws Throwable {
	   
	 DriverFactory.getDriver().get("http://demo.guru99.com/V4/");
	}

	@When("^user gets the page title$")
	public void user_gets_the_page_title() throws Throwable {
	
	 actualTitle = lp.getPageTitle();
		
	}

	@Then("^page title should be \"([^\"]*)\"$")
	public void page_title_should_be(String expectedTitle) throws Throwable {
	
		Assert.assertTrue(actualTitle.contains(expectedTitle));
	}

	@Then("^forgot link password should be displayed$")
	public void forgot_link_password_should_be_displayed() throws Throwable {
	
		Assert.assertTrue(lp.isForgotPassword());
	}
	
	@When("^user enters the username \"([^\"]*)\"$")
	public void user_enters_the_username(String username) throws Throwable {
	    lp.enterUsername(username);
	}

	@When("^user enters the password \"([^\"]*)\"$")
	public void user_enters_the_password(String password) throws Throwable {
	    lp.enterPassword(password);
	}

	@When("^user clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable {
	
		lp.ClickLogin();
	}
}
