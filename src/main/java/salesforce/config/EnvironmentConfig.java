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

    private String login;
    private String baseUrl;
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
        username = getTheSalesforceUsername();
        password = getTheSalesforcePassword();
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
