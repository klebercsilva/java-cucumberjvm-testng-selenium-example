package com.example.selenium.steps;

import com.example.selenium.SpringContextConfiguration;
import com.example.selenium.core.SpringPropertiesConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = {SpringContextConfiguration.class})
@Slf4j
public class Hooks {

    @Autowired
    private WebDriver driver;

    @Autowired
    private SpringPropertiesConfiguration properties;

    @Before
    public void openBrowser() {
        driver.get(properties.getHost());
    }

    @After(order = 1)
    public void attachScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }

    @After(order = 0)
    public void closeBrowser(Scenario scenario) {
        driver.quit();
    }
}
