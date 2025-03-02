package test.testex;

// Add latest Extent Report Dependency in POM.XML file from here: https://mvnrepository.com/artifact/com.aventstack/extentreports

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CustomizeReportBase {

    protected ExtentReports extentReports;
    protected ExtentTest extentTest;

    @BeforeSuite
    public void setupReport() {
        // Initialize ExtentHtmlReporter
    	ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\projectScreenshots\\extentReport.html");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Login Test Report");
        htmlReporter.config().setTheme(Theme.DARK);

        // Initialize ExtentReports
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);

        // Add system info to the report
        extentReports.setSystemInfo("Tester", "Bhavesh");
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
    }

    @AfterSuite
    public void teardownReport() {
        // Flush the report
        extentReports.flush();
    }
}
