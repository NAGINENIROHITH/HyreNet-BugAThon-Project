package locators;

import org.openqa.selenium.By;

public class TestsLocators {
    // Verified User Locators for Test Creation (Drive)
    public static final By USE_THIS_TO_DRIVE_BUTTON = By.id("use-this-to-drive");
    public static final By DRIVE_NAME_FIELD = By.id("drive-name");
    public static final By DRIVE_DATES_PICKER = By.id("drive-dates");
    public static final By CALENDAR_APPLY_BUTTON = By.xpath("//button[normalize-space()='Apply']");
    public static final By DRIVE_TAGS_INPUT = By.xpath("//input[@id='drive-tags-selectized']");
    public static final By JOB_DESCRIPTION_AREA = By.xpath("//p[@data-placeholder='Job Description ']");
    public static final By SAVE_DRIVE_BUTTON = By
            .xpath("//button[@class='custom-btn custom-btn--primary mt-5 save-drive']");
    public static final By SUCCESS_MESSAGE = By.className("success-message");
}
