package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHelper {

    private static WebDriver driver;

    public DriverHelper() {
    }

    public void start() {
        driver = new ChromeDriver();
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
