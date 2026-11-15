
package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    public static ExtentReports extent;
    public static ExtentTest test;

    // Initialize the HTML report
    public static void setupReport() {

        // Create reports folder if it does not exist
        new File("reports").mkdirs();

        ExtentSparkReporter spark =
                new ExtentSparkReporter("reports/ExtentReport.html");

        extent = new ExtentReports();

        extent.attachReporter(spark);

        extent.setSystemInfo("Project", "AI Sign Pro");
        extent.setSystemInfo("Browser", "Edge");
    }

    // Save the final report
    public static void flushReport() {
        extent.flush();
    }
}
