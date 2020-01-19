package core;

import org.openqa.selenium.By;

public interface IGenericAction {
    void click();
    void enterText(By by);
    void waitForElementVisible();
}
