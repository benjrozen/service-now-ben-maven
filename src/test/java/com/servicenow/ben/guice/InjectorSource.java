package com.servicenow.ben.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import io.cucumber.guice.CucumberModules;


public class InjectorSource implements io.cucumber.guice.InjectorSource {
    @Override
    public Injector getInjector() {
        return Guice.createInjector(Stage.DEVELOPMENT, CucumberModules.createScenarioModule(),
                                    new Module());
    }
}
