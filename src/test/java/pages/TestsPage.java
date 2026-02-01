package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import com.aventstack.extentreports.ExtentTest;
import locators.TestsLocators;

public class TestsPage extends BasePage {

    public TestsPage(WebDriver driver) {
        super(driver);
    }

    public TestsPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public void clickUseThisToDrive() {
        click(TestsLocators.USE_THIS_TO_DRIVE_BUTTON);
    }

    public void enterTestName(String name) {
        type(TestsLocators.DRIVE_NAME_FIELD, name);
    }

    public void selectDates() {
        // Clicking the date picker to open calendar
        click(TestsLocators.DRIVE_DATES_PICKER);
        // User mentioned picking dates and clicking apply.
        // For simplicity, we assume clicking picker then clicking apply selects
        // current/default dates.
        click(TestsLocators.CALENDAR_APPLY_BUTTON);
    }

    public void selectTag(String tag) {
        clickUsingJavaScript(TestsLocators.DRIVE_TAGS_INPUT);
        type(TestsLocators.DRIVE_TAGS_INPUT, tag);
        driver.findElement(TestsLocators.DRIVE_TAGS_INPUT).sendKeys(Keys.ENTER);
    }

    public void enterJobDescription(String description) {
        type(TestsLocators.JOB_DESCRIPTION_AREA, description);
    }

    public void clickSave() {
        click(TestsLocators.SAVE_DRIVE_BUTTON);
    }

    public boolean isSuccessMessageDisplayed() {
        return isElementDisplayed(TestsLocators.SUCCESS_MESSAGE);
    }

    // Unified creation flow
    public void createDrive(String testName, String tag, String description) {
        clickUseThisToDrive();
        enterTestName(testName);
        selectDates();
        selectTag(tag);
        enterJobDescription(description);
        clickSave();
    }
}
