package locators;

import org.openqa.selenium.By;

public class DashboardLocators {
    public static final By DASHBOARD_TITLE = By
            .xpath("//h1[contains(.,'Dashboard')] | //span[contains(.,'Dashboard')]");
    public static final By QUESTIONS_MENU = By.xpath("//span[normalize-space()='My QLibrary']");
    public static final By TEMPLATES_MENU = By.xpath("//span[normalize-space()='Template']");
    public static final By TESTS_MENU = By.xpath("//span[normalize-space()='Test']");
    public static final By USER_PROFILE = By.className("user-profile"); // Keeping default for now unless user updates
    public static final By LOGOUT_BUTTON = By.id("logout");
}
