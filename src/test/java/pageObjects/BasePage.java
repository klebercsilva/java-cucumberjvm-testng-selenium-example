package pageObjects;

import core.GenericAction;

public class BasePage extends GenericAction {

    private String currentPage;

    public BasePage() {

    }

    public String getCurrentPage() {
        return currentPage;
    }
}
