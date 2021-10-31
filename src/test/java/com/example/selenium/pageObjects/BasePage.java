package com.example.selenium.pageObjects;

import com.example.selenium.core.MobileAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("cucumber-glue")
public class BasePage {

    @Autowired
    private WebDriver driver;

    @Autowired
    protected MobileAction action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @PostConstruct
    private void initElements() {
        PageFactory.initElements(driver, this);
    }
}
