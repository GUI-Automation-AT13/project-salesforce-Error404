/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.selenium;

import core.selenium.browsers.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public final class MyWebDriverManager {
    private static MyWebDriverManager myWebDriverManager;
    private WebDriver driver;
    private WebDriverWait wait;
    private WebDriverConfig webDriverConfig = WebDriverConfig.getWebDriverConfig();

    private MyWebDriverManager() {
        initialize();
    }

    /**
     * Gets the web driver manager or creates one when needed.
     *
     * @return an instance of myWebDriverManager
     */
    public static MyWebDriverManager getWebDriverManager() {
        if (myWebDriverManager == null) {
            myWebDriverManager = new MyWebDriverManager();
        }
        return myWebDriverManager;
    }

    /**
     * Creates the web driver and web driver wait instances.
     */
    private void initialize() {
        driver = new BrowserFactory().getWebDriver(webDriverConfig.getBrowser());
        driver.manage().window().maximize();
        driver.manage().timeouts()
                .implicitlyWait(webDriverConfig.getImplicitWaitTime(), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, webDriverConfig.getExplicitWaitTime());
    }

    /**
     * Gets the driver instance according to its type.
     *
     * @return the Web Driver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Gets the web driver wait instance according to its type.
     *
     * @return the web driver wait
     */
    public WebDriverWait getWebDriverWait() {
        return wait;
    }

    /**
     * Clears the MyWebDriverManager instance.
     */
    public void quitDriver() {
        driver.quit();
        myWebDriverManager = null;
    }
}
