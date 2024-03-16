package com.servicenow.ben.selenium.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeDriverFactory extends WebDriverFactory {

    @Override
    public WebDriver createWebDriver() {
        if (isCI) {
            return WebDriverManager.chromedriver().browserInDocker().enableVnc().enableRecording()
                                                  .dockerRecordingPrefix("chrome--").dockerRecordingOutput(recordingsPath)
                                                  .create();
        }
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
    }
}
