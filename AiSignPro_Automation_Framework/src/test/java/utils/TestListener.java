
package utils;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.BaseClass;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener, ISuiteListener {

    // Initialize report before test execution
    @Override
    public void onStart(ISuite suite) {
        ExtentReportManager.setupReport();
    }

    // Save report after all tests finish
    @Override
    public void onFinish(ISuite suite) {
        ExtentReportManager.flushReport();
    }

    // Create test entry when a test starts
    @Override
    public void onTestStart(ITestResult result) {

        ExtentReportManager.test =
                ExtentReportManager.extent.createTest(
                        result.getMethod().getMethodName());

        ExtentReportManager.test.log(Status.INFO, "Test Started");
    }

    // Record passed test
    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.test.log(Status.PASS, "Test Passed");
    }

    // Record failed test
    @Override
    public void onTestFailure(ITestResult result) {
    	
    	System.out.println("onTestFailure method called!");

        ExtentReportManager.test.log(Status.FAIL, "Test Failed");
        ExtentReportManager.test.log(Status.FAIL, result.getThrowable());

        // Get the WebDriver from the failed test class
        WebDriver driver = ((BaseClass) result.getInstance()).getDriver();

        // Take screenshot and attach it to Extent Report
        try {
            String fileName = result.getMethod().getMethodName()
                    + "_" + System.currentTimeMillis();

            String screenshotPath = ScreenShot.takeScreenshot(driver, fileName);

            ExtentReportManager.test.addScreenCaptureFromPath(screenshotPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Record skipped test
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReportManager.test.log(Status.SKIP, "Test Skipped");
    }
}
