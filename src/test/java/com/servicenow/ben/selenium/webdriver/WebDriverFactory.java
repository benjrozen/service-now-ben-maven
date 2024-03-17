package com.servicenow.ben.selenium.webdriver;

import org.openqa.selenium.WebDriver;

import java.nio.file.Path;
import java.text.SimpleDateFormat;

public abstract class WebDriverFactory {

    final static public boolean isCI = Boolean.parseBoolean(System.getenv("JENKINS_HOME")) || Boolean.parseBoolean(System.getenv("CI"));

    protected Path dockerRecordingsPath = Path.of(System.getProperty("user.dir") + "/target/cucumber-report/record/" +
                            new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new java.util.Date()) + "recording.mp4");

    protected abstract WebDriver createWebDriver();
}
