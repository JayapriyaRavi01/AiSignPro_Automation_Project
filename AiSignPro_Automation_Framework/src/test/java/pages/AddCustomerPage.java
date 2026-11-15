package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor- to avoid NullPointerException
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Enter Mobile Number
	public void mobileNumer(String mobileNo) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter mobile number']")));

		WebElement mobilenum = driver.findElement(By.xpath("//input[@placeholder='Enter mobile number']"));

		mobilenum.sendKeys(mobileNo);

	}

	// Enter Name
	public void contactName(String name) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter contact name']")));

		WebElement contactname = driver.findElement(By.xpath("//input[@placeholder='Enter contact name']"));

		contactname.sendKeys(name);

	}

	// Enter Email ID
	public void emailID(String email) {

		WebElement emailid = driver.findElement(By.xpath("//input[@placeholder='Enter email ID']"));

		emailid.sendKeys(email);

	}

	// click Assign Documents

	public void assignDocumentBotton() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='assign-btn']")));

		WebElement assignbtn = driver.findElement(By.xpath("//button[@id='assign-btn']"));

		assignbtn.click();

	}

	public void popUpMsg() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='OK']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='The customer has been created successfully']")));
		System.out.println("PopUP Message:  "
				+ driver.findElement(By.xpath("//div[text()='The customer has been created successfully']")).getText());

		driver.findElement(By.xpath("//button[text()='OK']")).click();

	}
	
	//Assign Documents -select file from drop down
	
    public void selectCustomer(String email){
	 
  	  //click drop down
  	  WebElement dropdown = driver.findElement(By.xpath("(//span[@class='ng-arrow-wrapper'])[1]"));
  	    dropdown.click();
  	    
  	    //Select the customer
  	    
  	    driver.findElement(By.xpath("(//div[contains(@class,'ng-option')])[1]")).click();

  	    

}

	

}
