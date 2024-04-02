package stepdefinitions;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import Hooks.DriverInstance;
import PageObjects.AccountsuccessPage;
import PageObjects.LandingPage;
import PageObjects.RegisterPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class registersteps extends DriverInstance{
	

	LandingPage LanPage;
	RegisterPage RPage;
	AccountsuccessPage ASPage;
	Logger logs;
	
	
	@When("User clicks on My Account dropdown menu")
	public void User_clicks_on_My_Account_dropdown_menu() {
		logs = LogManager.getLogger(registersteps.class.getName());
		LanPage = new LandingPage(driver);
		LanPage.MyAccount().click();

		
	    
	}

	@Then("User clicks on Register link")
	public void User_clicks_on_Register_link() {
		LanPage.Register().click();
	    
	}

	@Then("User enters First name as {string}")
	public void User_enters_First_name_as(String Firstname) {
		RPage = new RegisterPage(driver);
		RPage.Firstname().sendKeys(Firstname);
		logs.debug("entered firstname");
	    
	}

	@Then("User enters Last name as {string}")
	public void User_enters_Last_name_as(String Lastname) {
		RPage.Lastname().sendKeys(Lastname);
		logs.debug("entered lastname");
	}

	@Then("User enters valid email as")
	public void User_enters_valid_email_as() {
		RPage.email().sendKeys(emailgenerate());
		logs.debug("entered emailaddress");
	}

	@Then("User enters valid password as {string}")
	public void User_enters_valid_password_as(String password) {
		
		RPage.password().sendKeys(password);
		logs.debug("entered password");
		
	}
	@Then("User clicks on subscribe button")
	public void User_clicks_on_subscribe_button() {
		
		RPage.subscribe();
		logs.debug("clicked on subscribe");
	}

	@Then("User clicks on privacy policy")
	public void User_clicks_on_privacy_policy() {
		
		RPage.privacypolicy();
		logs.debug("clicks on privacy policy");
	   
	}

	@When("User on continue button")
	public void User_on_continue_button() {
		RPage.continuebutton();
		
	    
	}

	@Then("User should successfully register")
	public void user_should_successfully_register() {
		
		ASPage = new AccountsuccessPage(driver);
		String successmessage = ASPage.successfullmessage().getText();
		Assert.assertEquals(successmessage,"Your Account Has Been Created!");
	    logs.info("Account created successfully");
	}


	public String emailgenerate() { //generating temporary email for ever time
		Date date = new Date();
		return "hilter"+date.toString().replace(" ","_").replace(":", "_")+"@gmail.com";
		//haiFri_Apr_07_14_05_45_UTC_2024@gmail.com
		
	}
	
}

