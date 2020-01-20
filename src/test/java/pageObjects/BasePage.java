package pageObjects;

import core.GenericAction;
import org.openqa.selenium.WebDriver;

public class BasePage extends GenericAction {

    private String currentPage;

    public BasePage(WebDriver driver) {
        super(driver);
    }

    public String getCurrentPage() {
        return currentPage;
    }
}
