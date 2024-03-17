package com.servicenow.ben.pageObjects;

import com.google.inject.Inject;
import com.servicenow.ben.selenium.webdriver.InjectedWebDriver;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class ProductPage extends WebPage{

    @Inject
    public ProductPage(InjectedWebDriver injectedWebDriver) {
        super(injectedWebDriver);
    }

    public void clickWatchDemoButton() {
        val watchDemoButtonSelector = By.cssSelector("[class='hero-inner print-no-margin'] > [class*='d-flex'] > [class='btn btn-primary']");
        webDriverWrapper.waitForElementAndClick(watchDemoButtonSelector);
    }

    public void verifyDemoVideo() {
        webDriverWrapper.waitForIframeAndSwitchToIt(By.xpath("//iframe[contains(@src, 'https://www.youtube.com/embed')]"));
        webDriverWrapper.waitForVisibilityOfElement(By.id("player"));
    }

    public void verifyVRXDashboardGif() {
        if (!webDriverWrapper.isVisible(By.cssSelector(".mock-wrapper  [class*='is-loaded']"))) {
            Assertions.fail("VRX dashboard gif was not displayed!");
        }
    }

    public void clickLearnMoreButtonInPatchlessProtectionSection() {
        webDriverWrapper.waitForElementAndClick(By.cssSelector("[href='/product/patchless-protection'][class*='btn btn-secondary']"));
    }
}
