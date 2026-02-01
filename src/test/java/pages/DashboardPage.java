package pages;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import locators.DashboardLocators;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public DashboardPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public boolean isDashboardDisplayed() {
        return isElementDisplayed(DashboardLocators.DASHBOARD_TITLE);
    }

    public String getDashboardTitle() {
        return getText(DashboardLocators.DASHBOARD_TITLE);
    }

    public void navigateToQuestions() {
        if (test != null)
            test.info("Navigating to Questions module via URL");
        driver.get("https://app.hyrenet.in/library");
    }

    public void navigateToTemplates() {
        if (test != null)
            test.info("Navigating to Templates module via URL");
        driver.get("https://app.hyrenet.in/templates");
    }

    public void navigateToTests() {
        if (test != null)
            test.info("Navigating to Tests module");
        try {
            click(DashboardLocators.TESTS_MENU);
        } catch (Exception e) {
            if (test != null)
                test.warning("Standard click failed, trying JS click");
            clickUsingJavaScript(DashboardLocators.TESTS_MENU);
        }
    }

    public void logout() {
        if (test != null)
            test.info("Navigating to Settings for logout");
        driver.get("https://app.hyrenet.in/settings");
        click(DashboardLocators.LOGOUT_BUTTON);
    }
}
