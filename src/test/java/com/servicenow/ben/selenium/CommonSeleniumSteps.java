package com.servicenow.ben.selenium;

import com.google.inject.Inject;
import com.servicenow.ben.InputParser;
import com.servicenow.ben.selenium.webdriver.InjectedWebDriver;
import com.servicenow.ben.selenium.webdriver.WebDriverWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

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

    @When("^the user (?:enters|types in) \"(.*)\" (?:in|to) \"(.*)\"")
    public void enterText(String input, String selector) {
        String parsedInput = InputParser.parse(input);
        By parsedSelector = WebElementSelectorParser.parse(selector);
        webDriverWrapper.enterText(parsedSelector, parsedInput);
    }

    @Then("the user should see {string}")
    @Then("the {string} should appear")
    @Then("the user sees {string}")
    public void theUserShouldSee(String selector) {
        By parsedWebElement = WebElementSelectorParser.parse(selector);
        webDriverWrapper.waitForVisibilityOfElement(parsedWebElement);
    }
}
