package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OTP_Page  {
	
	 WebDriver driver;

	    // Initialize WebDriver using constructor
	    public OTP_Page(WebDriver driver) {
	        this.driver = driver;
	    }
	
	public void otp_1(String otp1){
		
		//explicit wait
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='otp1']")));	
				        
		
	WebElement otpbox	= driver.findElement(By.xpath("//input[@name='otp1']"));
		
	otpbox.sendKeys(otp1);
		
				
	}
	
public void otp_2(String otp2){
		
		//explicit wait
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='otp2']")));	
				        
		
	WebElement otpbox	= driver.findElement(By.xpath("//input[@name='otp2']"));
		
	otpbox.sendKeys(otp2);
		
				
	}
	
public void otp_3(String otp3){
	
	//explicit wait
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				    
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='otp3']")));	
			        
	
WebElement otpbox	= driver.findElement(By.xpath("//input[@name='otp3']"));
	
otpbox.sendKeys(otp3);
	
			
}


public void otp_4(String otp4){
	
	//explicit wait
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				    
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='otp4']")));	
			        
	
WebElement otpbox	= driver.findElement(By.xpath("//input[@name='otp4']"));
	
otpbox.sendKeys(otp4);
	
			
}
	
	
public void otp_5(String otp5){
	
	//explicit wait
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				    
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='otp5']")));	
			        
	
WebElement otpbox	= driver.findElement(By.xpath("//input[@name='otp5']"));
	
otpbox.sendKeys(otp5);
	
			
}
	
public void otp_6(String otp6){
	
	//explicit wait
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				    
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='otp6']")));	
			        
	
WebElement otpbox	= driver.findElement(By.xpath("//input[@name='otp6']"));
	
otpbox.sendKeys(otp6);
	
			
}


public void verifyButton() {
	
	//explicit wait
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
					    
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Verify']")));
	
	WebElement verifybtn=	driver.findElement(By.xpath("//span[text()='Verify']"));
	
	verifybtn.click();
	
	System.out.println("OTP verification completed successfully");
	
	
}








}
