package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import Hooks.DriverInstance;
import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginsteps extends DriverInstance{
	public LandingPage LanPage;
	public LoginPage LogPage;
	public AccountPage APage;
	Logger logs;
	
	
	@When("User clicks on My Account dropdown")
	public void User_clicks_on_My_Account_dropdown() {
		logs = LogManager.getLogger(loginsteps.class.getName());
		
		LanPage = new LandingPage(driver);
		LanPage.MyAccount().click();
		logs.debug("clicked on MyAccount option");
		}
	

	@Then("User clicks on Login link")
	public void User_clicks_on_Login_link() {
		LanPage.Login().click();
	    logs.debug("clicked on login option");
	}
	
	@And("User enters valid email address {string}")
	public void User_enters_valid_email_address(String emailaddress){
		
		LogPage = new LoginPage(driver);
		LogPage.emailAddress().sendKeys(emailaddress);
		logs.debug("entered emailaddress");
		
	
	}
	
	@And("User enters valid password {string}")
	public void User_enters_valid_password(String password) {
		LogPage.password().sendKeys(password);
		logs.debug("entered password");
		
	}
	
	@And("User clicks on Login button")
	public void User_clicks_on_Login_button() {
		LogPage.loginbutton().click();
		logs.debug("clicked on loginbutton");
		
	}
	
	@Then("User should Login successfully")
	public void User_should_Login_successfully() {
		
		APage = new AccountPage(driver);
		String confirmmessage = APage.confirmlogin().getText();
		Assert.assertEquals("My Account",confirmmessage);
		logs.info("login successfully");
	}
	
	@When("^User enters email address (.+)$")
	public void User_enters_email_address(String email) {
		LogPage = new LoginPage(driver);
		LogPage.emailAddress().sendKeys(email);
		logs.debug("entered emailaddress");
	}
	
	@And("^User enters password (.+)$")
	public void User_enters_password(String password) {
		LogPage.password().sendKeys(password);
		logs.debug("entered password");
	}

	@Then("User should not login successfully")
	public void User_should_not_login_successfully() {
		
		 boolean text =LogPage.errormessage().isDisplayed();
		Assert.assertEquals(true, text);
		logs.info("login unsuccessfull");
		 
		
	}
	
}

