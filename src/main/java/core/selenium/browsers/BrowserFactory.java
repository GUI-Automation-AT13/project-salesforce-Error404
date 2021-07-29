/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.selenium.browsers;

import org.openqa.selenium.WebDriver;

public class BrowserFactory {

    /**
     * Gets the proper web driver.
     *
     * @param webDriver a String with the web driver's name
     * @return the web driver
     */
    public WebDriver getWebDriver(final String webDriver) {
        if (webDriver == null) {
            return null;
        }
        switch (webDriver) {
            case "CHROME":
                return new ChromeBrowser().getDriver();
            case "EDGE":
                return new EdgeBrowser().getDriver();
            case "FIREFOX":
                return new FirefoxBrowser().getDriver();
            default:
                break;
        }
        return null;
    }
}
