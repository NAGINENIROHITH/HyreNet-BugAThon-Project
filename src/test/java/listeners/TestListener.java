package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReportManager;
import utils.ScreenshotUtil;
import utils.DriverManager;
import com.aventstack.extentreports.Status;

public class TestListener implements ITestListener {
    
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().log(Status.PASS, "Test Passed: " + result.getName());
        }
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().log(Status.FAIL, "Test Failed: " + result.getName());
            ExtentReportManager.getTest().log(Status.FAIL, result.getThrowable());
            
            // Capture screenshot on failure
            if (DriverManager.getDriver() != null) {
                String screenshotPath = ScreenshotUtil.captureScreenshot(
                    DriverManager.getDriver(), 
                    result.getName() + "_failure"
                );
                if (screenshotPath != null) {
                    ExtentReportManager.getTest().addScreenCaptureFromPath(screenshotPath);
                }
            }
        }
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
        if (ExtentReportManager.getTest() != null) {
            ExtentReportManager.getTest().log(Status.SKIP, "Test Skipped: " + result.getName());
        }
    }
    
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite Started: " + context.getName());
    }
    
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite Finished: " + context.getName());
    }
}
