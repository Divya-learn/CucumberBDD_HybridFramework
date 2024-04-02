package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage {
	
WebDriver driver;
	
	public SuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	
	@FindBy(xpath="//h1[contains(text(),'Your')]")
	private WebElement ordersuccess;
	
	public WebElement ordersuccess() {
		return ordersuccess;
	}

}
