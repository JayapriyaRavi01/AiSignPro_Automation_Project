package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected WebDriver driver;
	
	//browser launch
	
	@BeforeClass
	public void launchBrowser() {
		
		WebDriverManager.edgedriver().setup();
		
		driver = new EdgeDriver();
		
		driver.get("https://cpastaging.aisignpro.com/");
		
		driver.manage().window().maximize();
		
	}
	
	
	public WebDriver getDriver() {
	    return driver;
	}
	
@AfterClass
	
	public void tearDown() {
		
	if (driver != null) {
        driver.quit();
    }

		
		
	}
	
	
	
	
	
	
	
	
	
	

}
