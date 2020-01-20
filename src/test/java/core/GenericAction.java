package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class GenericAction implements IGenericAction {

    private WebDriver driver;

    public GenericAction(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void click(WebElement element) {
        waitForElementVisible(element);
        element.click();
    }

    @Override
    public void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    @Override
    public void assertDisplayed(WebElement element) {
        assertTrue(element.isDisplayed());
    }

    @Override
    public void chooseValue(By by, String value) {
        new Select(driver.findElement(by)).selectByVisibleText(value);
    }

    @Override
    public void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}