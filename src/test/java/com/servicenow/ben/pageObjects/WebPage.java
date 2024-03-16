package com.servicenow.ben.pageObjects;

import com.google.inject.Inject;
import com.servicenow.ben.selenium.webdriver.InjectedWebDriver;
import com.servicenow.ben.selenium.webdriver.WebDriverWrapper;

public class WebPage {

    WebDriverWrapper webDriverWrapper;

    @Inject
    public WebPage(InjectedWebDriver injectedWebDriver) {
        this.webDriverWrapper = new WebDriverWrapper(injectedWebDriver.getDriver());
    }
}
