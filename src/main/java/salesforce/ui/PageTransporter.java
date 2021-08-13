/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui;

import core.selenium.MyWebDriverManager;
import salesforce.config.EnvironmentConfig;
import salesforce.ui.pages.cases.CasesPage;
import salesforce.ui.urls.SalesforceClassicUrl;
import salesforce.ui.urls.SalesforceUrl;

public class PageTransporter {
    private final String baseUrl = EnvironmentConfig.getEnvironmentConfig().getBaseUrl();
    private final String baseUrlClassic = EnvironmentConfig.getEnvironmentConfig().getBaseUrlClassic();
    private final String salesforceVersion = EnvironmentConfig.getEnvironmentConfig().getSalesforceVersion();

    /**
     * Creates page transporter.
     */
    public PageTransporter() throws Exception {
    }

    /**
     * Navigates to the provided url.
     *
     * @param url a String with the url
     */
    public void goToUrl(final String url) {
        MyWebDriverManager.getWebDriverManager().getDriver().navigate().to(url);
    }

    /**
     * Navigates to the salesforce web page.
     *
     * @param pageName a String with the page name
     */
    public void goToPage(final String pageName) {
        if (salesforceVersion.equals("classic")) {
            goToUrl(baseUrlClassic.concat(SalesforceClassicUrl.valueOf(pageName).getUrl()));
        } else {
            goToUrl(baseUrl.concat(SalesforceUrl.valueOf(pageName).getUrl()));
        }
    }
}
