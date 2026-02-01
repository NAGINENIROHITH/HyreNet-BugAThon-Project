package pages;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import locators.LoginLocators;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage(WebDriver driver, String url, ExtentTest test) {
        super(driver, test);
        driver.get(url);
    }

    public void enterEmail(String email) {
        try {
            type(LoginLocators.EMAIL_FIELD, email);
        } catch (Exception e) {
            test.fail("Failed to enter email: " + e.getMessage());
        }
    }

    public void enterPassword(String password) {
        try {
            type(LoginLocators.PASSWORD_FIELD, password);
        } catch (Exception e) {
            test.fail("Failed to enter password: " + e.getMessage());
        }
    }

    public void clickLoginButton() {
        click(LoginLocators.LOGIN_BUTTON);
    }

    public void login(String email, String password) {
        if (test != null)
            test.info("Attempting login with: " + email);
        enterEmail(email);
        enterPassword(password);
        if (test != null)
            test.info("Clicking the login button");
        clickLoginButton();
        waitForPageToLoad();
    }

    // Keeping utility methods just in case, but they rely on default locators which
    // might be gone
    // Removing them for cleaner code as per "start fresh" instruction.
}
