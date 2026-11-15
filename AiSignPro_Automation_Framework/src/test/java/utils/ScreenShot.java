package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	
	
	
	


	
	public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File destination = new File("screenshots/" + fileName + ".png");

        Files.createDirectories(destination.toPath().getParent());

        Files.copy(source.toPath(), destination.toPath());

        System.out.println("Screenshot saved successfully: " + fileName);
        return destination.getAbsolutePath();
    }

}



