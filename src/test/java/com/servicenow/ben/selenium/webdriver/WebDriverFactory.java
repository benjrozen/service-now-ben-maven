package com.servicenow.ben.selenium.webdriver;

import org.openqa.selenium.WebDriver;

import java.nio.file.Path;
import java.text.SimpleDateFormat;

public abstract class WebDriverFactory {

    public abstract WebDriver createWebDriver();

    final boolean isCI = Boolean.parseBoolean(System.getenv("JENKINS_HOME")) || Boolean.parseBoolean(System.getenv("CI"));

    Path recordingsPath = Path.of(System.getProperty("user.dir") + "/target/cucumber-report/record/" + new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new java.util.Date()) + "recording.mp4");
}
