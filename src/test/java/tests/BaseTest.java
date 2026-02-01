package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.ConfigReader;
import utils.DriverManager;
import utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseTest {
    
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;
    
    @BeforeSuite
    public void setUpSuite() {
        extent = ExtentReportManager.createInstance();
    }
    
    @BeforeMethod
    @Parameters({"browser", "headless"})
    public void setUp(@Optional("chrome") String browser, @Optional("false") String headless) {
        // Override with system properties if provided
        String browserName = System.getProperty("browser", browser);
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", headless));
        
        driver = DriverManager.initializeDriver(browserName, isHeadless);
        driver.get(ConfigReader.getAppUrl());
    }
    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            DriverManager.quitDriver();
        }
        ExtentReportManager.removeTest();
    }
    
    @AfterSuite
    public void tearDownSuite() {
        ExtentReportManager.flush();
    }
}
