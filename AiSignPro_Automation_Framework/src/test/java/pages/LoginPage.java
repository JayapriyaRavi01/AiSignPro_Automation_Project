package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor- to avoid NullPointerException
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// enter phone number
	public void phoneNumber(String phone) {

		// explicit wait
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone")));

		WebElement phonenum = driver.findElement(By.id("phone"));
		phonenum.sendKeys(phone);

	}

	// click check box
	public void checkBox() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='checkbox']")));

		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		checkbox.click();

	}

	// click submit button
	public void submit() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[1]")));

		WebElement submitbtn = driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
		submitbtn.click();

		System.out.println("Submit button clicked successfully");

	}

}
