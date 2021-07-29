/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.selenium.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements IBrowser {
    /**
     * Gets the browser's driver.
     *
     * @return the web driver
     */
    @Override
    public WebDriver getDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
