package com.example.selenium.core;

import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.testng.Assert.assertTrue;

@NoArgsConstructor
@Component
@Scope("cucumber-glue")
public class MobileAction implements IGenericAction {

    @Autowired
    private WebDriver driver;

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