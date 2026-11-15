package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.ScreenShot;
public class AssignDocumentsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	// Constructor- to avoid NullPointerException
		public AssignDocumentsPage(WebDriver driver) {
			this.driver = driver;
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}
		
		
		//click checkbox to assign documents
	
	public void clickCheckbox(){
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[2]")));
		
		
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		
			
	}
	
	//Drag and Drop
	
	public void dragSignature(){
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		WebElement signature = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='fpe-chip-label' and text()='Signature' ]")));
		signature.click();
		WebElement rightside = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='fpe-canvas-area']")));

//	WebElement signature=	driver.findElement(By.xpath("//span[@class='fpe-chip-label' and text()='Signature' ]"));
	
	//WebElement rightside = driver.findElement(By.xpath("//div[@class='fpe-canvas-area']"));
	
	//to perform drag ad drop
	
	Actions actions = new Actions(driver);
	
	actions.clickAndHold(signature);
	actions.pause(Duration.ofSeconds(2));

	actions.moveToElement(rightside);
	actions.pause(Duration.ofSeconds(2));
	actions.release();
	actions.perform();
	
	Assert.assertTrue(rightside.findElements(By.xpath("//span[@class='fpe-chip-label' and text()='Signature' ]")).size() > 0, "Signature not dropped");
	System.out.println("Signature dropped successfully");
	
	
	}
	
	//click send mail
	
	public void sendMailButton() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary btn-sm' and text()='Send Mail ' ]")));
		WebElement sendmailbtn= driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm' and text()='Send Mail ' ]"));
		sendmailbtn.click();
		
		//send anyway button
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Send anyway']")));
		WebElement sendanyway= driver.findElement(By.xpath("//button[text()='Send anyway']"));
		sendanyway.click();
		
		System.out.println("send anyway Button clicked successfully ");
		
	}
	
	
	//click Continue to send mail button 
	public void continueSendMailButton() {
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue to Send Mail ']")));
		WebElement continuebtn1= driver.findElement(By.xpath("//button[text()='Continue to Send Mail ']"));
		continuebtn1.click();
		
		System.out.println("Continue send Button clicked successfully ");
		
	
	}
	
	
	public void sendingOptionPopUp() throws IOException {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue']")));
		WebElement continuebtn2= driver.findElement(By.xpath("//button[text()='Continue']"));
		continuebtn2.click();
		
		System.out.println("Continue Button clicked successfully ");
		
		//take screenshot for success message
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		String fileName = "Agreement email sent to the customer "+System.currentTimeMillis();

		ScreenShot.takeScreenshot(driver,fileName);
	}
}
