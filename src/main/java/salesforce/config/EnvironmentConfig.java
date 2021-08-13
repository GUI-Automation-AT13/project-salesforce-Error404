/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.config;

import static core.config.LoadEnvironmentFile.*;

public final class EnvironmentConfig {

    private static EnvironmentConfig environmentConfig;
    private static String LOGIN_URL;
    private static String SALESFORCE_VERSION;
    private static String BASE_URL;
    private static String BASE_URL_CLASSIC;
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
        LOGIN_URL = getTheLoginUrl();
        BASE_URL = getTheBaseUrl();
        BASE_URL_CLASSIC = getTheBaseUrlClassic();
        SALESFORCE_VERSION = getTheSalesforceVersion();
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
        return LOGIN_URL;
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
    public static String getBaseUrlClassic() {
        return BASE_URL_CLASSIC;
    }

    /**
     * Gets the salesforce version.
     *
     * @return a String with the salesforce version
     */
    public static String getSalesforceVersion() {
        return SALESFORCE_VERSION;
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

    /**
     * Gets the salesforce token.
     *
     * @return a String with the token
     */
    public static String getToken() {
        return SALESFORCE_TOKEN;
    }

    /**
     * Gets the salesforce client id.
     *
     * @return a String with the client id
     */
    public static String getClientId() {
        return SALESFORCE_CLIENT_ID;
    }

    /**
     * Gets the salesforce client secret.
     *
     * @return a String with the client secret
     */
    public static String getClientSecret() {
        return SALESFORCE_CLIENT_SECRET;
    }
}
