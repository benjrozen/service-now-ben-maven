package com.servicenow.ben.selenium;

import org.openqa.selenium.By;


public class WebElementSelectorParser {

    public static By parse(String selector) {
        if (selector.startsWith("cssSelector:")) {
            selector = selector.replaceAll("cssSelector:", "");
            return By.cssSelector(":not([style*='display: none']) > " + selector);
        } else if (selector.startsWith("xpath:")) {
            selector = selector.replaceAll("xpath:", "");
            return By.xpath("//*[not(contains(@style,'display: none'))]" + selector);
        } else if (selector.startsWith("id:")) {
            selector = selector.replaceAll("id:", "");
            return By.id(selector);
        }
        throw new IllegalArgumentException("Invalid selector : " + selector);
    }
}
