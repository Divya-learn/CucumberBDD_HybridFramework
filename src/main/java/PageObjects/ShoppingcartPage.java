package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingcartPage {
	
	WebDriver driver;
	Actions action;
	
	
	public ShoppingcartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	
	@FindBy(xpath="//a[text()='Shopping Cart']")
	private WebElement Shoppingcarttext;
	
	public WebElement Shoppingcarttext(){
		return  Shoppingcarttext;
	}

	@FindBy(xpath="//a[text()='Checkout']")
	private WebElement checkoutbutton;
	
	public WebElement checkoutbutton() {
		
		action = new Actions(driver);
		action.moveToElement(checkoutbutton).click(checkoutbutton).build().perform();
		 return checkoutbutton;
	}
}
