package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DashboardPage {
	
	
	
WebDriver driver;
WebDriverWait wait;

	
	//Constructor- to avoid NullPointerException
	 public DashboardPage(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	
	 
	 
	 
	// Customer button click
	
	public void customersButton(){
	
	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Customers']")));
	
			
	WebElement customerbtn=	driver.findElement(By.xpath("//span[text()='Customers']"));
		
	customerbtn.click();
	}
	
	
    // Add Customer button click

	public void addCustomerButton(){
		
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Add Customer']")));
			
		WebElement addcustomerbtn=	driver.findElement(By.xpath("//button[text()='Add Customer']"));
			
		addcustomerbtn.click();
			
		}
	
	
	
	
	
	
	
	

}
