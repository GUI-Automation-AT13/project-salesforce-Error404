/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.utils;

import io.github.cdimascio.dotenv.Dotenv;
import salesforce.utils.EnvironmentInitialConfig;

import java.io.File;
import java.util.Locale;
import static core.utils.EncryptorAES.getDecryptedValue;

public final class LoadEnvironmentFile {

    private static String key = "error404";

    public LoadEnvironmentFile() { }

    /**
     * Checks if env file exists.
     *
     * @return true if the env file already exists.
     */
    private static boolean envFileExists() {
        File envFile = new File(".env");
        return envFile.exists();
    }

    /**
     * Gets the Dotenv.
     *
     * @return the Dotenv
     */
    public static Dotenv getDotenv() {
        if (!envFileExists()) {
            EnvironmentInitialConfig initialEnvFile = new EnvironmentInitialConfig();
            initialEnvFile.createEnvFile();
        }
        return Dotenv.configure().load();
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
     * Gets the base url classic from environment file.
     *
     * @return a String with the base url classic
     */
    public static String getTheBaseUrlClassic() {
        return getDotenv().get("BASE_URL_CLASSIC");
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
        return getDecryptedValue(getDotenv().get("SALESFORCE_USERNAME"), key);
    }

    /**
     * Gets the salesforce password from environment file.
     *
     * @return a String with the salesforce password
     */
    public static String getTheSalesforcePassword() {
        return getDecryptedValue(getDotenv().get("SALESFORCE_PASSWORD"), key);
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

    /**
     * Gets the salesforce version.
     *
     * @return a String with the salesforce version
     */
    public static String getTheSalesforceVersion() {
        return getDotenv().get("SALESFORCE_VERSION");
    }

    /**
     * Gets the internationalization language.
     *
     * @return Locale with language.
     */
    public static Locale getLanguage() {
        return new Locale(getDotenv().get("LANGUAGE"));
    }
}
