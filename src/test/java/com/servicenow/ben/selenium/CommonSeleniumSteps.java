package com.servicenow.ben.selenium;

import com.google.inject.Inject;
import com.servicenow.ben.selenium.webdriver.InjectedWebDriver;
import com.servicenow.ben.selenium.webdriver.WebDriverWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class CommonSeleniumSteps {



    WebDriverWrapper webDriverWrapper;


    @Inject
    public CommonSeleniumSteps(InjectedWebDriver injectedWebDriver) {
        this.webDriverWrapper = new WebDriverWrapper(injectedWebDriver.getDriver());
    }

    @Given("the user browsed to {string}")
    public void aUserBrowsesTo(String url) {
        webDriverWrapper.browseTo(url);
    }

    @And("clicks {string}")
    public void click(String selector) {
        webDriverWrapper.waitForElementAndClick(WebElementSelectorParser.parse(selector));
    }
}
