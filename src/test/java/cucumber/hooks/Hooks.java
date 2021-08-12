/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.hooks;

import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import salesforce.config.EnvironmentConfig;
import static core.selenium.MyWebDriverManager.getWebDriverManager;
import static core.config.LoadEnvironmentFile.*;
import static salesforce.config.EnvironmentConfig.*;

public class Hooks {
    private WebDriver driver;
    private ApiRequestBuilder requestBuilder;
    private ApiResponse tokenApiResponse;
    private static String token;

    public Hooks(final ApiRequestBuilder newRequestBuilder, final  ApiResponse newTokenApiResponse) {
        this.requestBuilder = newRequestBuilder;
        this.tokenApiResponse = newTokenApiResponse;
    }

    @Before(order = 0)
    public void generateToken() {
        EnvironmentConfig.getEnvironmentConfig();
        requestBuilder
                .addBaseUri(getTheLoginUrl())
                .addEndpoint("/services/oauth2/token")
                .addQueryParams("grant_type", "password")
                .addQueryParams("client_id", getClientId())
                .addQueryParams("client_secret", getClientSecret())
                .addQueryParams("username", getUsername())
                .addQueryParams("password", getPassword().concat(getToken()))
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addMethod(ApiMethod.POST);
        ApiManager.executeWithoutLog(requestBuilder.build(), tokenApiResponse);
        token = tokenApiResponse.getPath("token_type").concat(" ")
                .concat(tokenApiResponse.getPath("access_token"));
    }

    @Before(order = 1)
    public void setUp() {
        requestBuilder
                .addHeader("Authorization", token)
                .addBaseUri(getTheBaseUrlClassic());
        driver = getWebDriverManager().getDriver();
        driver.get(EnvironmentConfig.getEnvironmentConfig().getLogin());
    }

    @After
    public void takeScreenShootOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) getWebDriverManager().getDriver();
            byte[] src = screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(src, "image/png", "screenshoot");
        }
    }

    @After(order = 1)
    public void tearDown() {
        getWebDriverManager().quitDriver();
    }

    /**
     * Gets the created token.
     *
     * @return a String with the token
     */
    public static String getCreatedToken() {
        return token;
    }
}
