package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	Actions action;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
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
	
	@FindBy(xpath="//input[@type='email']")
	private WebElement email;
	
	public WebElement email() {
		return email;
	}
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	public WebElement password() {
		return password;
	}
	

	@FindBy(id="input-newsletter")
	private WebElement subscribe;
	
	public WebElement subscribe() {
		
		action = new Actions(driver);
		action.moveToElement(subscribe).click(subscribe).build().perform();
		
		return subscribe;
	}
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement privacypolicy;
	
	public WebElement privacypolicy() {
		
		//action = new Actions(driver);
		action.moveToElement(privacypolicy).click(privacypolicy).build().perform();
		return privacypolicy;
	}
	
	@FindBy(xpath="//button[text()='Continue']")
	private WebElement continuebutton;
	
	public WebElement continuebutton() {
		
		action.moveToElement(continuebutton).click(continuebutton).build().perform();
		return continuebutton; 
	}
	
	
	

}
