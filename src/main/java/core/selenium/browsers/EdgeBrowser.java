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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeBrowser implements IBrowser {
    private EdgeOptions edgeOptions;

    /**
     * Configures Edge driver options.
     */
    public void configOptions() {
        edgeOptions = new EdgeOptions();
        edgeOptions.setCapability("w3c", false);
    }

    /**
     * Gets the browser's driver.
     *
     * @return the web driver
     */
    @Override
    public WebDriver getDriver() {
        WebDriverManager.edgedriver().setup();
        configOptions();
        return new EdgeDriver(edgeOptions);
    }
}
