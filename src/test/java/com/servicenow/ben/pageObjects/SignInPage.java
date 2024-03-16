package com.servicenow.ben.pageObjects;

import com.google.inject.Inject;
import com.servicenow.ben.selenium.webdriver.InjectedWebDriver;
import org.openqa.selenium.By;

public class SignInPage extends WebPage{



    @Inject
    public SignInPage(InjectedWebDriver injectedWebDriver) {
        super(injectedWebDriver);
    }

    public void enterEmail(String email) {
        webDriverWrapper.enterText(By.cssSelector("[placeholder='Work e-mail']"), email);
    }

    public void waitForSignInToast() {
        webDriverWrapper.waitForVisibilityOfElement(By.cssSelector("[class='notification type-email']"));
    }
}
