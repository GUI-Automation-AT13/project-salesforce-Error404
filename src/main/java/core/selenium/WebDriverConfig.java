/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.selenium;

import static core.utils.LoadEnvironmentFile.*;

public final class WebDriverConfig {
    private String browser;
    private int implicitWaitTime;
    private int explicitWaitTime;

    private static WebDriverConfig webDriverConfig;

    private WebDriverConfig() {
        initialize();
    }

    /**
     * Gets web driver's configuration.
     *
     * @return an instance of the web driver's configuration
     */
    public static WebDriverConfig getWebDriverConfig() {
        if (webDriverConfig == null) {
            webDriverConfig = new WebDriverConfig();
        }
        return webDriverConfig;
    }

    private void initialize() {
        browser = getTheBrowser();
        implicitWaitTime = getTheImplicitWaitTime();
        explicitWaitTime = getTheExplicitWaitTime();
    }

    /**
     * Gets the browser.
     *
     * @return a String with the browser
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * Gets the implicit wait time.
     *
     * @return an int with the time in seconds
     */
    public int getImplicitWaitTime() {
        return implicitWaitTime;
    }

    /**
     * Gets the explicit wait time.
     *
     * @return an int with the time in seconds
     */
    public int getExplicitWaitTime() {
        return explicitWaitTime;
    }
}
