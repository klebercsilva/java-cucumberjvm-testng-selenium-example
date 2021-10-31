package com.example.selenium.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface IGenericAction {
    void click(WebElement element);
    void chooseValue(By by, String value);
    void assertDisplayed(WebElement element);
    void enterText(WebElement element, String text);
    void waitForElementVisible(WebElement element);
}
