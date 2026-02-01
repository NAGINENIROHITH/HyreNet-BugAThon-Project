package locators;

import org.openqa.selenium.By;

public class TemplatesLocators {
    // Verified User Locators
    public static final By CREATE_TEMPLATE_BUTTON = By.xpath("//a[@class='custom-btn custom-btn--primary']");
    public static final By AUTO_CONFIGURE_OPTION = By
            .xpath("//span[contains(text(),'Automatically configure parameters and')]");
    public static final By TEMPLATE_NAME_FIELD = By.xpath("//input[@id='role-test-name']");
    public static final By SELECT_ROLE_INPUT = By.xpath("//input[@id='role-select-role-selectized']");
    public static final By OBJECTIVE_COUNT_FIELD = By.id("role-obj-count");
    public static final By PROGRAMMING_COUNT_FIELD = By.id("role-pgm-count");
    public static final By SAVE_AND_CONTINUE_BUTTON = By.id("step1-submit");
    public static final By SAVE_AND_SUBMIT_BUTTON = By
            .xpath("//a[@class='custom-btn custom-btn--primary save-and-submit']");
    public static final By SUCCESS_MESSAGE = By.className("success-message");
}
