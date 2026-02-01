package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.DashboardPage;
import pages.LoginPage;
import pages.QuestionsPage;
import pages.TemplatesPage;
import pages.TestsPage;
import utils.ConfigReader;

public class PlaceOrderTest extends BaseTest {

    ExtentReports extent;
    ExtentTest test;

    @Test
    public void testCompleteBugAThonFlow() throws InterruptedException {
        test = extent.createTest("BugAThon Complete Flow Test");

        // 1. Login Page
        test.info("Starting Login");
        LoginPage loginPage = new LoginPage(driver, ConfigReader.getAppUrl(), test);
        loginPage.login(ConfigReader.getEmail(), ConfigReader.getPassword());
        Thread.sleep(3000);

        // 2. Dashboard & Questions Page
        DashboardPage dashboard = new DashboardPage(driver, test);

        // No need for strict verification logic here as per user request to start
        // fresh/simple
        // But logging is good.

        dashboard.navigateToQuestions();
        Thread.sleep(2000);

        QuestionsPage questions = new QuestionsPage(driver, test);
        String questionText = "What is the primary use of Selenium?";
        String[] options = { "Web Testing", "OS Development", "Data Science", "Mobile Hardware" };

        test.info("Creating MCQ Question");
        questions.createMCQQuestion(questionText, options, 1);
        Thread.sleep(2000);

        // 3. Template Page
        dashboard.navigateToTemplates();
        TemplatesPage templates = new TemplatesPage(driver, test);
        templates.createTemplate("Automation Skills Check", "engineer", "5", "2");
        Thread.sleep(2000);

        // 4. Test Creation Page
        test.info("Creating Test Drive from Template");
        TestsPage tests = new TestsPage(driver, test);
        tests.createDrive("HyreNet Automation Test Feb", "Automation", "Drive for automation role");
        Thread.sleep(2000);

        // 5. Scheduling Page - Still commented out
        /*
         * SchedulingPage scheduling = new SchedulingPage(driver, test);
         * scheduling.clickScheduleTest();
         * scheduling.selectTest("HyreNet Automation Test Feb");
         * scheduling.enterCandidateEmail("candidate.test@example.com");
         * scheduling.clickScheduleNow();
         * Thread.sleep(2000);
         */

        // 6. Logout
        dashboard.logout();
    }

    @BeforeClass
    public void beforeClass() {
        ExtentSparkReporter spark = new ExtentSparkReporter("reports/BugAThonCompleteReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        // BaseTest handles driver initiation in @BeforeMethod, but following user
        // pattern:
        // We ensure driver is ready.
    }

    @AfterClass
    public void afterClass() {
        extent.flush();
        if (driver != null) {
            driver.quit();
        }
    }
}
