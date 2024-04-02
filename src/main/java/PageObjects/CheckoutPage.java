package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	WebDriver driver;
	Actions action;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	
	@FindBy(xpath="//a[text()='Checkout']")
	private WebElement checkoutverify;
	
	public WebElement checkoutverify() {
		return checkoutverify;
	}

	
	@FindBy(xpath="//input[@id='input-guest']")
	private WebElement guestcheckout;
	
	public WebElement guestcheckout() {
		return guestcheckout;
	}
	
	@FindBy(id="input-firstname")
	private WebElement Firstname;
	
	public WebElement Firstname() {
		return Firstname;
	}
	
	
	@FindBy(id="input-lastname")
	private WebElement Lastname;
	
	public WebElement Lastname() {
		return Lastname;
	}
	
	@FindBy(id="input-email")
	private WebElement emailaddressinguest;
	
	public WebElement emailaddressinguest() {
		return emailaddressinguest;
	}
	
	
	@FindBy(id="input-shipping-address-1")
	private WebElement Address;
	
	public WebElement Address() {
		return Address;
	}
	
	
	@FindBy(id="input-shipping-city")
	private WebElement city;
	
	public WebElement city() {
		return city;
	}
	

	@FindBy(id="input-shipping-postcode")
	private WebElement postcode;
	
	public WebElement postcode() {
		return postcode;
	}
	
	
	@FindBy(xpath="//select[@id='input-shipping-country']")
	private WebElement country;
	
	public WebElement country() {
		return country;
	}
	
	
	@FindBy(xpath="//select[@name='shipping_zone_id']")
	private WebElement region;
	
	public WebElement region() {
		return region;
	}
	
	
	@FindBy(id="button-register")
	private WebElement continuebutton;
	
	public WebElement continuebutton() {
		
		action = new Actions(driver);
		action.moveToElement(continuebutton).click(continuebutton).build().perform();
		return continuebutton;
	}
	
	
	@FindBy(xpath="//button[@id='button-shipping-methods']")
	private WebElement chooseshippingbutton;
	
	public WebElement chooseshippingbutton() {
		action.moveToElement(chooseshippingbutton).click(chooseshippingbutton).build().perform();
		return chooseshippingbutton;
	}
	
	
	@FindBy(xpath="//input[@id='input-shipping-method-flat-flat']")
	private WebElement preferredshippingmethod;
	
	public WebElement preferredshippingmethod() {
		action.moveToElement(preferredshippingmethod).click(preferredshippingmethod).build().perform();
		return preferredshippingmethod;
	}
	
	@FindBy(xpath="//button[@id='button-shipping-method']")
	private WebElement continuepreferredshippingmethod;
	
	public WebElement  continuepreferredshippingmethod() {
		action.moveToElement(continuepreferredshippingmethod).click(continuepreferredshippingmethod).build().perform();
		return  continuepreferredshippingmethod;
	}
	
	
	@FindBy(xpath="//button[@id='button-payment-methods']")
	private WebElement choosepaymentbutton;
	
	public WebElement choosepaymentbutton() {
		action.moveToElement(choosepaymentbutton).click(choosepaymentbutton).build().perform();
		return choosepaymentbutton;
	}
	
	
	@FindBy(xpath="//input[@id='input-payment-method-cod-cod']")
	private WebElement cashonDelivery;
	
	public WebElement cashonDelivery() {
		action.moveToElement(cashonDelivery).click(cashonDelivery).build().perform();
		return cashonDelivery;
	}
	
	
	@FindBy(xpath="//button[@id='button-payment-method']")
	private WebElement continuecashonDelivery;
	
	public WebElement continuecashonDelivery() {
		action.moveToElement(continuecashonDelivery).click(continuecashonDelivery).build().perform();
		return continuecashonDelivery;
	}


	@FindBy(xpath="//button[@id='button-confirm']")
	private WebElement confirmorder;
	
	public WebElement confirmorder() {
		action.moveToElement(confirmorder).click(confirmorder).build().perform();
		return confirmorder;
	}
	
}
