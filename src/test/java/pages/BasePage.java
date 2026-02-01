package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.WaitHelper;

import com.aventstack.extentreports.ExtentTest;
import java.util.List;

public class BasePage {

    protected WebDriver driver;
    protected WaitHelper waitHelper;
    protected ExtentTest test;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    public BasePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        this.waitHelper = new WaitHelper(driver);
        PageFactory.initElements(driver, this);
    }

    protected void click(By locator) {
        waitHelper.waitForElementToBeClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitHelper.waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitHelper.waitForElementToBeVisible(locator).getText();
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return waitHelper.waitForElementToBeVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementEnabled(By locator) {
        return waitHelper.waitForElementToBeVisible(locator).isEnabled();
    }

    protected void selectDropdownByValue(By locator, String value) {
        WebElement element = waitHelper.waitForElementToBeVisible(locator);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    protected void selectDropdownByText(By locator, String text) {
        WebElement element = waitHelper.waitForElementToBeVisible(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    protected void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void clickUsingJavaScript(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    protected String getAttributeValue(By locator, String attribute) {
        return waitHelper.waitForElementToBeVisible(locator).getAttribute(attribute);
    }

    protected List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    protected void waitForPageToLoad() {
        waitHelper.waitForPageLoad();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }
}
