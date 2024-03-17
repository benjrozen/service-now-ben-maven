package com.servicenow.ben.selenium;

import com.google.inject.Inject;
import com.servicenow.ben.selenium.webdriver.InjectedWebDriver;
import com.servicenow.ben.selenium.webdriver.WebDriverWrapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.val;
import org.junit.jupiter.api.Assertions;

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
        val parsedInput = InputParser.parse(input);
        val parsedSelector = WebElementSelectorParser.parse(selector);
        webDriverWrapper.enterText(parsedSelector, parsedInput);
    }

    @Then("the user should see {string}")
    @Then("the {string} should appear")
    @Then("the user sees {string}")
    public void theUserShouldSee(String selector) {
        val parsedWebElement = WebElementSelectorParser.parse(selector);
        webDriverWrapper.waitForVisibilityOfElement(parsedWebElement);
    }

    @Then("the url should contain {string}")
    public void theUrlShouldContain(String path) {
        val urlIsCorrect = webDriverWrapper.urlContains(path);
        if (!urlIsCorrect) {
            Assertions.fail("Url did not contain: " + path);
        }
    }
}
