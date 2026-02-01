package pages;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import locators.QuestionsLocators;
import org.openqa.selenium.Keys;

public class QuestionsPage extends BasePage {

    public QuestionsPage(WebDriver driver) {
        super(driver);
    }

    public QuestionsPage(WebDriver driver, ExtentTest test) {
        super(driver, test);
    }

    public void clickCreateQuestion() {
        click(QuestionsLocators.CREATE_QUESTION_BUTTON);
    }

    public void enterQuestionText(String text) {
        // User provided logic: click the SVG/Button (formatting toolbar?)
        // Assuming this activates the editor or is the field itself
        click(QuestionsLocators.QUESTION_TEXT_AREA);
        // After clicking, if it's a focusable element, we might need to send keys to
        // the active element
        // or the element itself accepts text.
        // For now, attempting to type into the element clicked.
        try {
            type(QuestionsLocators.QUESTION_TEXT_AREA, text);
        } catch (Exception e) {
            // If normal type fails (likely for SVG/Button), we might need to use Actions or
            // JS
            // or simply click it and assume focus is set for next interaction.
            // But usually 'type' works on input/textarea.
            // If user said "xpath for question text area", we treat it as input.
            if (test != null)
                test.warning("Could not type directly into text area locator, trying Actions");
            new org.openqa.selenium.interactions.Actions(driver)
                    .sendKeys(text).perform();
        }
    }

    public void addOptions() {
        // User instruction: "click this 2 times for adding total 4 options"
        click(QuestionsLocators.ADD_NEW_OPTION_BUTTON);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        click(QuestionsLocators.ADD_NEW_OPTION_BUTTON);
    }

    public void enterOptions(String[] options) {
        // User provided specific IDs for 4 options
        if (options.length > 0)
            type(QuestionsLocators.OPTION_A, options[0]);
        if (options.length > 1)
            type(QuestionsLocators.OPTION_B, options[1]);
        if (options.length > 2)
            type(QuestionsLocators.OPTION_C, options[2]);
        if (options.length > 3)
            type(QuestionsLocators.OPTION_D, options[3]);
    }

    // --- Mandatory Fields Methods ---

    public void enterScore(String score) {
        type(QuestionsLocators.SCORE_FIELD, score);
    }

    // Helper for 'selectized' inputs (Click -> Type -> Enter)
    public void fillSelectizedField(org.openqa.selenium.By locator, String value) {
        clickUsingJavaScript(locator);
        type(locator, value);
        // Press Enter to confirm selection
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    public void selectDifficulty(String difficulty) {
        fillSelectizedField(QuestionsLocators.DIFFICULTY_DROPDOWN, difficulty);
    }

    public void selectCategory(String category) {
        fillSelectizedField(QuestionsLocators.CATEGORY_DROPDOWN, category);
    }

    public void enterTags(String tag) {
        fillSelectizedField(QuestionsLocators.TAGS_FIELD, tag);
    }

    // Refactored Select Correct Answer to use Keys.ENTER like other selectized
    // fields
    public void selectCorrectAnswer(int optionIndex) {
        // Option index is typically 1-based or A/B/C/D.
        // Assuming we map index 1 -> "Option A", 2 -> "Option B", etc.
        // Or if the user just wants to select the first one generally.
        // We will assume 'Option A' logic or just pass "Option A" as text.

        String optionText = "Option A"; // Default logic
        if (optionIndex == 2)
            optionText = "Option B";
        if (optionIndex == 3)
            optionText = "Option C";
        if (optionIndex == 4)
            optionText = "Option D";

        fillSelectizedField(QuestionsLocators.CORRECT_ANSWER_DROPDOWN, optionText);
    }

    public void clickSave() {
        click(QuestionsLocators.SAVE_BUTTON);
    }

    // Updated flow method
    public void createMCQQuestion(String questionText, String[] options, int correctOptionIndex) {
        clickCreateQuestion();

        // Enter Question Text
        enterQuestionText(questionText);

        // Add Options (Default 2 present, add 2 more for total 4)
        addOptions();
        enterOptions(options);

        // --- Enter Mandatory Fields ---
        enterScore("1"); // Default score
        selectDifficulty("Easy"); // Default difficulty
        selectCategory("Java"); // Default category (Assume 'Java' exists or type custom)
        enterTags("Automation"); // Default tag

        // Select Correct Answer
        selectCorrectAnswer(correctOptionIndex);

        clickSave();
    }
}
