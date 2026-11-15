package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignOut {
	
	WebDriver driver;
	WebDriverWait wait;
	
	// Constructor- to avoid NullPointerException
		public SignOut(WebDriver driver) {
			this.driver = driver;
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}
	
	//click profile menu
	public void profileMenu(){
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		 wait.until(ExpectedConditions.invisibilityOfElementLocated(
			        By.className("swal2-container")));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[3]")));

		
		WebElement profile = driver.findElement(By.xpath("(//button[@type='button'])[3]"));
		
		profile.click();
		
	}
	
	//click sign out button
	
public void signoutButton(){
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Sign out ']")));

		
		WebElement signoutbtn = driver.findElement(By.xpath("//button[text()=' Sign out ']"));
		
		signoutbtn.click();
		
		System.out.println("Sign Out Successfully");
		
		
	}
	
	
	
	
	
	

}
