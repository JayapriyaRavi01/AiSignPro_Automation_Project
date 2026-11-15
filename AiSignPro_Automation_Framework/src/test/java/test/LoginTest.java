package test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.OTP_Page;

public class LoginTest extends BaseClass{

	
	//Login Section
	
	@Test(priority =1)
	public void verifyLogin() {
		
		LoginPage login = new LoginPage(driver);
		
		login.phoneNumber("(666) 444-6664");
		login.checkBox();
		login.submit();
		
		System.out.println("LogIn successful");
		
	}
	
	
	//OTP Section
	
	@Test(priority =2)		
	public void verifyOTP() {
		
	
    OTP_Page otp = new OTP_Page(driver);
		
		otp.otp_1("1");
		otp.otp_2("2");
		otp.otp_3("3");
		otp.otp_4("4");
		otp.otp_5("5");
		otp.otp_6("6");
		
	    otp.verifyButton();
	
	 // verify dashboard navigation  
	    
	 //  System.out.println("Current URL" + driver.getCurrentUrl());

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    wait.until(ExpectedConditions.urlContains("/dashboard"));

	    Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"),"Dashboard not opened");
	        
	    System.out.println("Current URL" + driver.getCurrentUrl());
	    
	    System.out.println("Successfully navigated to the Dashboard page");
	    
	    
	}
	
	
	
	
	
	
}
