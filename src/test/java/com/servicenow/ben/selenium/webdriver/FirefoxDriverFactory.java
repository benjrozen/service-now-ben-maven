package com.servicenow.ben.selenium.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverFactory extends WebDriverFactory{
    @Override
    public WebDriver createWebDriver() {
        if (isCI) {
            return WebDriverManager.firefoxdriver().browserInDocker().enableVnc().enableRecording()
                                                   .dockerRecordingPrefix("firefox--").dockerRecordingOutput(recordingsPath)
                                                   .create();
        }
        WebDriverManager.firefoxdriver().setup();
        WebDriver webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        return webDriver;
    }
}
