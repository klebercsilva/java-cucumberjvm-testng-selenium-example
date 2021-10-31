package com.example.selenium.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WebDriverManager {

    private static final String BROWSER = "chrome";

    @Autowired
    private SpringPropertiesConfiguration properties;

    @Bean
    @Scope("cucumber-glue")
    public WebDriver webDriverFactory() throws IOException {
        return properties.getBrowser().equalsIgnoreCase(BROWSER) ?
                new ChromeDriver() : getRemoteWebDriver(properties.getBrowser());
    }

    private WebDriver getRemoteWebDriver(String browser) throws IOException {
        return browser.equalsIgnoreCase("firefox") ?
               new FirefoxDriver() : new ChromeDriver();
    }
}