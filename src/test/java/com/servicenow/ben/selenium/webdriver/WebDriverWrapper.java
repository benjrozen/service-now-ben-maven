package com.servicenow.ben.selenium.webdriver;

import com.servicenow.ben.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverWrapper {
    WebDriver driver;

    public WebDriverWrapper(WebDriver driver) {
        this.driver = driver;
    }

    public void browseTo(String url) {
        driver.get(url);
        Log.info("Browsed to page: " + url);
    }

    public void enterText(By selector, String text) {
        waitForPresenceOfElementInDOM(selector);
        waitForVisibilityOfElement(selector);
        waitForElementToBeClickable(selector);
        driver.findElement(selector).sendKeys(text);
        Log.info("Successfully entered text to WebElement with selector:\n" + selector + " -- text = " + text);
    }

    public void waitForElementAndClick(By selector) {
        waitForPresenceOfElementInDOM(selector);
        waitForVisibilityOfElement(selector);
        waitForElementToBeClickable(selector);
        driver.findElement(selector).click();
        Log.info("Successful click on WebElement with selector:\n" + selector);
    }

    private void waitForPresenceOfElementInDOM(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForInVisibilityOfElement(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    private void waitForElementToBeClickable(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitForIframeAndSwitchToIt(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
    }

    public void waitForVisibilityOfElement(By by) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}
