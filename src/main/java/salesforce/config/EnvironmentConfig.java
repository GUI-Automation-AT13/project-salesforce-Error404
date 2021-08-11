/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.config;

import static core.utils.LoadEnvironmentFile.*;

public final class EnvironmentConfig {
    private static EnvironmentConfig environmentConfig;

    private String loginUrl;
    private String BASE_URL;
    private String BASE_URL_CLASSIC;
    private String salesforceVersion;
    private static String SALESFORCE_USERNAME;
    private static String SALESFORCE_PASSWORD;
    private static String SALESFORCE_TOKEN;
    private static String SALESFORCE_CLIENT_ID;
    private static String SALESFORCE_CLIENT_SECRET;

    private EnvironmentConfig() {
        initialize();
    }

    /**
     * Gets the environment configuration.
     *
     * @return an instance of the environment's configuration
     */
    public static EnvironmentConfig getEnvironmentConfig() {
        if (environmentConfig == null) {
            environmentConfig = new EnvironmentConfig();
        }
        return environmentConfig;
    }

    private void initialize() {
        loginUrl = getTheLoginUrl();
        BASE_URL = getTheBaseUrl();
        BASE_URL_CLASSIC = getTheBaseUrlClassic();
        salesforceVersion = getTheSalesforceVersion();
        SALESFORCE_USERNAME = getTheSalesforceUsername();
        SALESFORCE_PASSWORD = getTheSalesforcePassword();
        SALESFORCE_TOKEN = getTheSalesforceToken();
        SALESFORCE_CLIENT_ID = getTheSalesforceClientId();
        SALESFORCE_CLIENT_SECRET = getTheSalesforceClientSecret();
    }

    /**
     * Gets the login url.
     *
     * @return a String with the login url
     */
    public String getLogin() {
        return loginUrl;
    }

    /**
     * Gets the salesforce.base url.
     *
     * @return a String with the salesforce.base url
     */
    public String getBaseUrl() {
        return BASE_URL;
    }

    /**
     * Gets the salesforce.base url classic.
     *
     * @return a String with the salesforce.base url classic
     */
    public String getBaseUrlClassic() {
        return BASE_URL_CLASSIC;
    }

    /**
     * Gets the salesforce version.
     *
     * @return a String with the salesforce version
     */
    public String getSalesforceVersion() {
        return salesforceVersion;
    }

    /**
     * Gets the salesforce username.
     *
     * @return a String with the username
     */
    public static String getUsername() {
        return SALESFORCE_USERNAME;
    }

    /**
     * Gets the salesforce password.
     *
     * @return a String with the password
     */
    public static String getPassword() {
        return SALESFORCE_PASSWORD;
    }
}
