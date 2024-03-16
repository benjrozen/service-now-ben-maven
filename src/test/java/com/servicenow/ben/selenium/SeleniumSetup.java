package com.servicenow.ben.selenium;

import com.google.inject.Inject;
import com.servicenow.ben.selenium.webdriver.ChromeDriverFactory;
import com.servicenow.ben.selenium.webdriver.FirefoxDriverFactory;
import com.servicenow.ben.selenium.webdriver.InjectedWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class SeleniumSetup {

    InjectedWebDriver injectedWebDriver;

    @Inject
    public SeleniumSetup(InjectedWebDriver injectedWebDriver) {
        this.injectedWebDriver = injectedWebDriver;
    }


    @Before
    public void before() throws IOException {
        if (System.getProperty("envFile") != null) {
            Properties prop = System.getProperties();
            String dir = System.getProperty("user.dir");
            InputStream in = new FileInputStream(dir + "/" + System.getProperty("envFile"));
            prop.load(in);
            in.close();
            System.setProperties(prop);
        }
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
