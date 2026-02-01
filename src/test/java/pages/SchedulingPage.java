package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class SchedulingPage extends BasePage {

    private By scheduleButton = By.xpath("//button[contains(text(),'Schedule Test')]");
    private By selectTestDropdown = By.id("test-select");
    private By candidateEmailField = By.id("candidate-email");
    private By scheduleNowButton = By.xpath("//button[contains(text(),'Schedule Now')]");
    private By successMessage = By.className("success-message");

    public SchedulingPage(WebDriver driver) {
        super(driver);
    }

    public SchedulingPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public void clickScheduleTest() {
        click(scheduleButton);
    }

    public void selectTest(String testName) {
        selectDropdownByText(selectTestDropdown, testName);
    }

    public void enterCandidateEmail(String email) {
        type(candidateEmailField, email);
    }

    public void clickScheduleNow() {
        click(scheduleNowButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return isElementDisplayed(successMessage);
    }
}
