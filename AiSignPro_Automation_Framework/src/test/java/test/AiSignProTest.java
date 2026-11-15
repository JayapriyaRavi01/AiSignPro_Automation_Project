package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddCustomerPage;
import pages.AssignDocumentsPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.OTP_Page;
import pages.SignOut;

@Listeners(utils.TestListener.class)





public class AiSignProTest extends BaseClass {

	// Login

	@Test(priority = 1)
	public void verifyLogin() {

		LoginPage login = new LoginPage(driver);

		login.phoneNumber("(666) 444-6664");
		login.checkBox();
		login.submit();

		System.out.println("LogIn successful");

	}

	// OTP

	@Test(priority = 2)
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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.urlContains("/dashboard"));

		Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"), "Dashboard not opened");

		System.out.println("Current URL" + driver.getCurrentUrl());

		System.out.println("Successfully navigated to the Dashboard page");

	}

	
	// Dashboard page / customer and add customers
	
	@Test(priority = 3)
	public void customersButton() {

		DashboardPage dash = new DashboardPage(driver);

		dash.customersButton();
		dash.addCustomerButton();
		System.out.println("Successfully clicked Customers and Add Customer button");

		System.out.println("current page:  " + driver.findElement(By.xpath("//h4[text()=' Add Customer ']")).getText());

	}
	
	//Add customers
	@Test(priority = 4)
	public void addCustomer() {
		
		AddCustomerPage add = new AddCustomerPage(driver);
		
	    String email = "customer" + System.currentTimeMillis() + "@mailinator.com";
	    String mobile = "9" + String.valueOf(System.currentTimeMillis()).substring(3);
	    add.mobileNumer(mobile);
	    add.contactName("SiaraG");
	    add.emailID(email);

		
		//add.mobileNumer("8763452670");
		
	//	add.contactName("SiaraG");
		//add.emailID("addedemail@mailinator.com");
		add.assignDocumentBotton();
		add.popUpMsg();
	    System.out.println("Generated Email: " + email);
	    System.out.println("Generated Mobile: " + mobile);

		add.selectCustomer(email);
	}
	
	//Assign document
	@Test(priority = 5)

	public void assignDocument() throws IOException{
		
		
		AssignDocumentsPage assign = new AssignDocumentsPage(driver);
		
		assign.clickCheckbox();
		
		assign.dragSignature();
		
		assign.sendMailButton();
		assign.continueSendMailButton();
		assign.sendingOptionPopUp();
		
	   // Assert.fail("failing this test to verify screenshot capture");

	}
	
	
	
	//SignOut
	@Test(priority = 6)

	public void signOut() {
		
		SignOut signout = new SignOut(driver);
		
		
		signout.profileMenu();
		signout.signoutButton();
		
		
	}
	
}
