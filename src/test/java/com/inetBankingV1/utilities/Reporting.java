package com.inetBankingV1.utilities;

// Listener class used to generate Extent reports
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    // This method runs before the test starts
    public void onStart(ITestContext testContext)
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // time stamp
        String repName = "Test-Report-" + timeStamp + ".html";

        // Define the report location and name
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "test-output" + File.separator + repName); // Specify location of the report

        // Attach reporter and set up system info
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Set system information in the report (such as environment, user, etc.)
        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Felix");

        // Report configurations (title, name, and theme)
        sparkReporter.config().setDocumentTitle("InetBanking Test Project"); // Title of the report
        sparkReporter.config().setReportName("Functional Test Automation Report"); // Name of the report
        sparkReporter.config().setTheme(Theme.DARK); // Set the theme for the report
    }

    // This method logs when a test is successful
    public void onTestSuccess(ITestResult tr)
    {
        logger = extent.createTest(tr.getName()); // Create a new entry in the report
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // Mark the test as passed in the report
    }

    // This method logs when a test fails
    public void onTestFailure(ITestResult tr) {
        logger = extent.createTest(tr.getName()); // Create a new entry in the report
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // Mark the test as failed in the report

        // Capture screenshot path
        String screenshotPath = System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + tr.getName() + ".png";
        File f = new File(screenshotPath);

        if (f.exists())
        {
            // Attach screenshot to the report if it exists
            logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
        }
    }

    // This method logs when a test is skipped
    public void onTestSkipped(ITestResult tr)
    {
        logger = extent.createTest(tr.getName()); // Create a new entry in the report
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE)); // Mark the test as skipped in the report
    }

    // This method runs after all tests are completed
    public void onFinish(ITestContext testContext)
    {
        extent.flush(); // Write everything to the report
    }
}
