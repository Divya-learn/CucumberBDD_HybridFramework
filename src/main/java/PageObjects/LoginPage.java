package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(id="input-email")
	private WebElement emailAddress;
	
	public WebElement emailAddress() {
		return emailAddress;
	}
	
	@FindBy(id="input-password")
	private WebElement password;
	
	public WebElement password() {
		return password;
	}
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	private WebElement loginbutton;
	
	public WebElement loginbutton() {
		return loginbutton;
	}
	
	
	@FindBy(xpath="//*[@class='alert alert-danger alert-dismissible']")
	private WebElement errormessage;
	
	public WebElement errormessage() {
		return errormessage;
	}

	


}

