package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	
		
		//Implementing Page Factory
		
		WebDriver driver;
		Actions action;
		
		public LandingPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
			}
		
		@FindBy(xpath="//span[text()='My Account']")
		private WebElement MyAccount;
		
		public WebElement MyAccount() {
			 return MyAccount;
		}
		
		@FindBy(linkText="Register")
		private WebElement Register;
		
		public WebElement Register() {
			return Register;
		}
		
		@FindBy(linkText="Login")
		private WebElement Login;
		
		public WebElement Login() {
			return Login;
		}
		
		@FindBy(xpath="//input[@name='search']")
		private WebElement searchfield;
		
		public WebElement searchfield() {
			return searchfield;
		}
		
		@FindBy(xpath="//button[@class='btn btn-light btn-lg']")
		private WebElement searchicon;
		
		public WebElement searchicon() {
			return searchicon;
		}
		
		
		@FindBy(linkText="Shopping Cart")
		private WebElement Shoppingcart;
		
		public WebElement Shoppingcart() {
			
			action = new Actions(driver);
			action.moveToElement(Shoppingcart).click(Shoppingcart).build().perform();
			return Shoppingcart;
		}
		
		

	}


