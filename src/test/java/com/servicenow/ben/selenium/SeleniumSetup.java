package com.servicenow.ben.selenium;

import com.google.inject.Inject;
import com.servicenow.ben.selenium.webdriver.ChromeDriverFactory;
import com.servicenow.ben.selenium.webdriver.FirefoxDriverFactory;
import com.servicenow.ben.selenium.webdriver.InjectedWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class SeleniumSetup {

    InjectedWebDriver injectedWebDriver;

    @Inject
    public SeleniumSetup(InjectedWebDriver injectedWebDriver) {
        this.injectedWebDriver = injectedWebDriver;
    }

    @Before("@default-webdriver")
    public void createDefaultWebdriver() {
        injectedWebDriver.setDriver(new ChromeDriverFactory().createWebDriver());
    }


    @Given("a {string} browser")
    public void createCustomBrowser(String browser) {
        switch (browser) {
            case "CHROME" -> injectedWebDriver.setDriver(new ChromeDriverFactory().createWebDriver());
            case "FIREFOX" -> injectedWebDriver.setDriver(new FirefoxDriverFactory().createWebDriver());
        }
    }

    @After()
    public void after() {
        if (injectedWebDriver.getDriver() != null) {
            injectedWebDriver.getDriver().quit();
        }
    }
}
