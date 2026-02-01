package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.Constants;

import java.io.File;

public class ExtentReportManager {
    
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    public static ExtentReports createInstance() {
        File reportDir = new File(Constants.EXTENT_REPORT_PATH);
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }
        
        String reportPath = Constants.EXTENT_REPORT_PATH + Constants.EXTENT_REPORT_NAME;
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        
        sparkReporter.config().setDocumentTitle("HyreNet BugAThon - Test Report");
        sparkReporter.config().setReportName("Automation Test Results");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "HyreNet Platform");
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("Tester", "Automation Team");
        
        return extent;
    }
    
    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }
    
    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }
    
    public static ExtentTest getTest() {
        return test.get();
    }
    
    public static void removeTest() {
        test.remove();
    }
    
    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
