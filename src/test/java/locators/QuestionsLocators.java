package locators;

import org.openqa.selenium.By;

public class QuestionsLocators {
        public static final By CREATE_QUESTION_BUTTON = By.id("objectMyLib-add-mcq");

        // User provided:
        // //*[@id='modal-create-obj-mcq']/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/p/br
        // We target the 'p' tag to type into it.
        public static final By QUESTION_TEXT_AREA = By.xpath(
                        "//*[@id='modal-create-obj-mcq']//div[@contenteditable='true']//p | //*[@id='modal-create-obj-mcq']/div/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/p");

        public static final By ADD_NEW_OPTION_BUTTON = By.id("addNewOption");

        public static final By OPTION_A = By.id("mcq-option-a");
        public static final By OPTION_B = By.id("mcq-option-b");
        public static final By OPTION_C = By.id("mcq-option-c");
        public static final By OPTION_D = By.id("mcq-option-d");

        // Mandatory Fields
        public static final By SCORE_FIELD = By.xpath("//input[@id='mcq-question-score']");
        public static final By DIFFICULTY_DROPDOWN = By.xpath("//input[@id='mcq-question-difficulty-selectized']");
        public static final By CATEGORY_DROPDOWN = By.xpath("//input[@id='mcq-question-category-selectized']");
        public static final By TAGS_FIELD = By.xpath("//*[@id='mcq-question-tags-selectized']");

        // Updated Correct Answer Locator
        public static final By CORRECT_ANSWER_DROPDOWN = By.xpath("//input[@id='mcq-answer-selectized']");

        // Class: custom-btn mcq-library-btn custom-btn--primary add-to-library
        public static final By SAVE_BUTTON = By
                        .cssSelector(".custom-btn.mcq-library-btn.custom-btn--primary.add-to-library");
}
