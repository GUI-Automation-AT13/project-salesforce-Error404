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

    private String login;
    private String baseUrl;
    private String baseUrlClassic;
    private String salesforceVersion;
    private String adminUrl;
    private static String username;
    private static String password;

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
        login = getTheLoginUrl();
        baseUrl = getTheBaseUrl();
        baseUrlClassic = getTheBaseUrlClassic();
        salesforceVersion = getTheSalesforceVersion();
        username = getTheSalesforceUsername();
        password = getTheSalesforcePassword();
        adminUrl = getTheAdminUrl();
    }

    /**
     * Gets the login url.
     *
     * @return a String with the login url
     */
    public String getLogin() {
        return login;
    }

    /**
     * Gets the salesforce.base url.
     *
     * @return a String with the salesforce.base url
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * Gets the salesforce.base url classic.
     *
     * @return a String with the salesforce.base url classic
     */
    public String getBaseUrlClassic() {
        return baseUrlClassic;
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
     * Gets the salesforce admin url.
     *
     * @return a String with the salesforce admin url.
     */
    public String getAdminUrl() {
        return adminUrl;
    }

    /**
     * Gets the salesforce username.
     *
     * @return a String with the username
     */
    public static String getUsername() {
        return username;
    }

    /**
     * Gets the salesforce password.
     *
     * @return a String with the password
     */
    public static String getPassword() {
        return password;
    }
}
