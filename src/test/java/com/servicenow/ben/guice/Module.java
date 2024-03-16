package com.servicenow.ben.guice;

import com.google.inject.AbstractModule;
import com.servicenow.ben.selenium.webdriver.InjectedWebDriver;
import io.cucumber.guice.ScenarioScoped;

public class Module extends AbstractModule {

    @Override
    protected void configure()
    {
        bind(InjectedWebDriver.class).in(ScenarioScoped.class);
    }
}
