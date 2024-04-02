package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Hooks.DriverInstance;
import PageObjects.CheckoutPage;
import PageObjects.LandingPage;
import PageObjects.SearchPage;
import PageObjects.ShoppingcartPage;
import PageObjects.SuccessPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.internal.org.jline.utils.Log;

public class viewcheckoutordersteps extends DriverInstance {
	
	public LandingPage LanPage;
	public ShoppingcartPage Shopcart;
	public CheckoutPage CheckPage;
	public SuccessPage Spage;
	public SearchPage SPage;
	Logger logs;
	
	@When("User search product name as {string}")
	public void User_search_product_name(String productname)
	{
		logs = LogManager.getLogger(viewcheckoutordersteps.class.getName());
		LanPage = new LandingPage(driver);
		LanPage.searchfield().sendKeys(productname);
		
	}
	
	@And("User clicks on search link")
	public void User_clicks_on_search_link() {
		LanPage.searchicon().click();
	}
	
	@And("User clicks on Add to cart link")
    public void User_clicks_on_Add_to_cart_link() {
		SPage= new SearchPage(driver);
    	SPage.Addtocarticon().click();
    }
	
	
	@When("User clicks on shopping cart link")
	public void User_clicks_on_shopping_cart_link() {
		
		SPage.shoppingcartsuccesslink().click();
		
	}
	
	@Then("User navigates to shopping cart page")
	public void User_navigates_to_shopping_cart_page() {
		
		Shopcart = new ShoppingcartPage(driver);
		String Shoptext =Shopcart.Shoppingcarttext().getText();
		Assert.assertEquals("Shopping Cart", Shoptext);
		logs.info("user navigated to shopping cart page");
	}

	@And("User clicks on checkout button")
	public void User_clicks_on_checkout_button() {
		
		Shopcart.checkoutbutton();
		logs.debug("clicked on checkoutbutton");
		
	}
	
	@Then("User navigates to checkout page")
	public void User_navigates_to_checkout_page() {
		
		CheckPage= new CheckoutPage(driver);
		String checktext = CheckPage.checkoutverify().getText();
		Assert.assertEquals("Checkout",checktext);
		logs.info("Navigated to checkout page");
	}
	
	@And("User provides the valid shipping information")
	public void User_provides_the_valid_shipping_information() {
		
		CheckPage.guestcheckout().click();
		CheckPage.Firstname().sendKeys("John");
		CheckPage.Lastname().sendKeys("T");
		CheckPage.emailaddressinguest().sendKeys("JohnT@John.com");
		CheckPage.Address().sendKeys("TamilNadu");
		CheckPage.city().sendKeys("Bangalore");
		CheckPage.postcode().sendKeys("34577");
		
		
		Select country = new Select(CheckPage.country());
		
		country.selectByVisibleText("India");
		

		Select region = new Select(CheckPage.region());
		region.selectByIndex(2);
		
		CheckPage.continuebutton();
		logs.debug("entered valid shipping information");
	}
	
	@And("User selects on Shipping Method")
	public void User_selects_on_Shipping_Method() {
		
		CheckPage.chooseshippingbutton();
		CheckPage.preferredshippingmethod();
		CheckPage.continuepreferredshippingmethod();
		logs.debug("choosed shipping method");
	}
	
	@And("User selects on Payment Method")
	public void User_selects_on_Payment_Method() {
		
		CheckPage.choosepaymentbutton();
		CheckPage.cashonDelivery();
		CheckPage.continuecashonDelivery();
		logs.debug("choosed payment method");
	}
	
	@Then("User clicks on confirm order")
	public void User_clicks_on_confirm_order() {
		CheckPage.confirmorder();
		logs.debug("clicked confirm order");
	
	}
	
	@And("User should successfully placed the order")
	public void User_should_successfully_placed_the_order() {
		
		Spage = new SuccessPage(driver);
		String ordersuccesstext = Spage.ordersuccess().getText();
		Assert.assertEquals("Your order has been placed!",ordersuccesstext);
		logs.info("order placed successfully");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
