package Hooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks extends DriverInstance{
	
	
	public Properties value;
	Logger logs;
	
	@Before
	public void setup(Scenario scenario) throws IOException {
		
		logs = LogManager.getLogger(Hooks.class.getName());
		value = new Properties();
		
		FileInputStream file = new FileInputStream("C:\\Users\\ADMIN\\eclipse-workspace\\CucumberBDDProject\\src\\test\\java\\Hooks\\data.properties");
		value.load(file);
		
		String browserName = value.getProperty("browserName");
				
		if(browserName.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
		
		if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		logs.debug("Browser got maximized");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(value.getProperty("url"));
		logs.debug("Application is opened");
		
	}
	
	@After
	public void closure(Scenario scenario) {
		
		boolean failed = scenario.isFailed();
		if(failed) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png",scenario.getName());
			
			
			}
		
		driver.quit();
		logs.debug("Browser  got closed");
	}

}
