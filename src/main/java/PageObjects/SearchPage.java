package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	
	
	WebDriver driver;
	Actions action;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	
	@FindBy(linkText="Search")
	private WebElement searchconfirm;
	
	public WebElement searchconfirm() {
		return searchconfirm;
	}
	
	
	@FindBy(xpath="//div[@class='button-group']/button")
	private WebElement Addtocarticon;
	
	public WebElement Addtocarticon() {
		
		action = new Actions(driver);
		action.moveToElement(Addtocarticon).click(Addtocarticon).build().perform();
		return Addtocarticon;
	}
	
	
	@FindBy(xpath="//*[@class='alert alert-success alert-dismissible']")
	private WebElement successcart;
	
	public WebElement successcart() {
		return successcart;
	}
	//*[text()='shopping cart']
	
	@FindBy(xpath="//*[text()='shopping cart']")
	private WebElement shoppingcartsuccesslink;
	
	public WebElement shoppingcartsuccesslink() {
		return shoppingcartsuccesslink;
	}
	

}
