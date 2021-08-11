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

public class Hooks {
    private WebDriver driver;
    private ApiRequestBuilder requestBuilder;
    private ApiResponse tokenApiResponse;
    String token;

    public Hooks(ApiRequestBuilder requestBuilder, ApiResponse tokenApiResponse) {
        this.requestBuilder = requestBuilder;
        this.tokenApiResponse = tokenApiResponse;
    }

    @Before(order = 0)
    public void generateToken() {
        requestBuilder
                .addBaseUri(getTheLoginUrl())
                .addEndpoint("/services/oauth2/token")
                .addQueryParams("grant_type", "password")
                .addQueryParams("client_id", getTheSalesforceClientId())
                .addQueryParams("client_secret", getTheSalesforceClientSecret())
                .addQueryParams("username", getTheSalesforceUsername())
                .addQueryParams("password", getTheSalesforcePassword().concat(getTheSalesforceToken()))
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
                .addBaseUri(getTheBaseUrl());
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
}
