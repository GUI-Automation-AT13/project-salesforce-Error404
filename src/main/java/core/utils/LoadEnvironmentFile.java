/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils;

import io.github.cdimascio.dotenv.Dotenv;

public final class LoadEnvironmentFile {
    private LoadEnvironmentFile() {
    }

    private static final Dotenv DOTENV = Dotenv.configure().load();

    /**
     * Gets the Dotenv.
     *
     * @return the Dotenv
     */
    public static Dotenv getDotenv() {
        return DOTENV;
    }

    /**
     * Gets the browser from environment file.
     *
     * @return a String with the browser
     */
    public static String getTheBrowser() {
        return getDotenv().get("BROWSER");
    }

    /**
     * Gets the explicit wait time from environment file.
     *
     * @return an int with the explicit wait time
     */
    public static int getTheExplicitWaitTime() {
        return Integer.parseInt(getDotenv().get("EXPLICIT_WAIT_TIME"));
    }

    /**
     * Gets the implicit wait time from environment file.
     *
     * @return an int with the implicit wait time
     */
    public static int getTheImplicitWaitTime() {
        return Integer.parseInt(getDotenv().get("IMPLICIT_WAIT_TIME"));
    }

    /**
     * Gets the base url from environment file.
     *
     * @return a String with the base url
     */
    public static String getTheBaseUrl() {
        return getDotenv().get("BASE_URL");
    }

    /**
     * Gets the login url from environment file.
     *
     * @return a String with the login url
     */
    public static String getTheLoginUrl() {
        return getDotenv().get("LOGIN_URL");
    }

    /**
     * Gets the salesforce username from environment file.
     *
     * @return a String with the salesforce username
     */
    public static String getTheSalesforceUsername() {
        return getDotenv().get("SALESFORCE_USERNAME");
    }

    /**
     * Gets the salesforce password from environment file.
     *
     * @return a String with the salesforce password
     */
    public static String getTheSalesforcePassword() {
        return getDotenv().get("SALESFORCE_PASSWORD");
    }

    /**
     * Gets the salesforce client id from environment file.
     *
     * @return a String with the salesforce client id
     */
    public static String getTheSalesforceClientId() {
        return getDotenv().get("SALESFORCE_CLIENT_ID");
    }

    /**
     * Gets the salesforce client secret from environment file.
     *
     * @return a String with the salesforce client secret
     */
    public static String getTheSalesforceClientSecret() {
        return getDotenv().get("SALESFORCE_CLIENT_SECRET");
    }

    /**
     * Gets the salesforce token from environment file.
     *
     * @return a String with the salesforce token
     */
    public static String getTheSalesforceToken() {
        return getDotenv().get("SALESFORCE_TOKEN");
    }
}
