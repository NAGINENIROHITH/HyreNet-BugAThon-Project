package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import com.aventstack.extentreports.ExtentTest;
import locators.TemplatesLocators;

public class TemplatesPage extends BasePage {

    public TemplatesPage(WebDriver driver) {
        super(driver);
    }

    public TemplatesPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public void clickCreateTemplate() {
        click(TemplatesLocators.CREATE_TEMPLATE_BUTTON);
    }

    public void selectAutoConfigure() {
        click(TemplatesLocators.AUTO_CONFIGURE_OPTION);
    }

    public void enterTemplateName(String name) {
        type(TemplatesLocators.TEMPLATE_NAME_FIELD, name);
    }

    private void fillSelectizedField(org.openqa.selenium.By locator, String value) {
        clickUsingJavaScript(locator);
        type(locator, value);
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public void selectRole(String role) {
        fillSelectizedField(TemplatesLocators.SELECT_ROLE_INPUT, role);
    }

    public void enterObjectiveCount(String count) {
        type(TemplatesLocators.OBJECTIVE_COUNT_FIELD, count);
    }

    public void enterProgrammingCount(String count) {
        type(TemplatesLocators.PROGRAMMING_COUNT_FIELD, count);
    }

    public void clickSaveAndContinue() {
        click(TemplatesLocators.SAVE_AND_CONTINUE_BUTTON);
    }

    public void clickSaveAndSubmit() {
        click(TemplatesLocators.SAVE_AND_SUBMIT_BUTTON);
    }

    public boolean isSuccessMessageDisplayed() {
        return isElementDisplayed(TemplatesLocators.SUCCESS_MESSAGE);
    }

    // Unified creation flow
    public void createTemplate(String name, String role, String objCount, String pgmCount) {
        clickCreateTemplate();
        selectAutoConfigure();
        enterTemplateName(name);
        selectRole(role);
        enterObjectiveCount(objCount);
        enterProgrammingCount(pgmCount);
        clickSaveAndContinue();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        clickSaveAndSubmit();
    }
}
