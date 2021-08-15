/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import salesforce.config.EnvironmentConfig;
import static core.selenium.MyWebDriverManager.getWebDriverManager;

public class Hooks {
    private WebDriver driver;

    @Before(order = 0)
    public void setUp() {
        driver = getWebDriverManager().getDriver();
        driver.get(EnvironmentConfig.getEnvironmentConfig().getLogin());
    }

    @After
    public void takeScreenShootOnFailure(final Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) getWebDriverManager().getDriver();
            byte[] src = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshoot");
        }
    }

    @After(order = 1)
    public void tearDown() {
        getWebDriverManager().quitDriver();
    }
}
