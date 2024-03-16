package com.servicenow.ben.selenium.webdriver;

import org.openqa.selenium.WebDriver;


public class InjectedWebDriver {
    private WebDriver driver;


    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
