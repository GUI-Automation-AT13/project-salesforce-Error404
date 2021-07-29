/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.hooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import salesforce.api.SalesforceApiResponse;
import salesforce.config.EnvironmentConfig;
import salesforce.entities.Account;
import salesforce.entities.Case;
import salesforce.entities.Contact;

import java.util.HashMap;
import java.util.Map;

import static core.selenium.MyWebDriverManager.getWebDriverManager;
import static core.utils.LoadEnvironmentFile.*;

public class Hooks {
    private WebDriver driver;
    private ApiRequestBuilder requestBuilder;
    private ApiResponse apiResponse;
    private ApiResponse tokenApiResponse;
    private Map<String, String> idMap = new HashMap<>();
    private Account account = new Account();
    private Case newCase;
    private Contact contact = new Contact();
    final String accountName = "Punisher";
    final String contactName = "Frank";
    final String contactLastName = "Castle";
    String token;

    public Hooks(ApiRequestBuilder requestBuilder, ApiResponse apiResponse,
                 ApiResponse tokenApiResponse, Case newCase) {
        this.requestBuilder = requestBuilder;
        this.apiResponse = apiResponse;
        this.tokenApiResponse = tokenApiResponse;
        this.newCase = newCase;
    }

    @Before(order = 0)
    public void generateToken() throws JsonProcessingException {
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

    @Before(value = "@CreateAccount")
    public void createAnAccount() throws JsonProcessingException {
        account.setName(accountName);
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Account/")
                .addBody(new ObjectMapper().writeValueAsString(account))
                .addMethod(ApiMethod.POST)
                .build();
        ApiManager.executeWithBody(requestBuilder.build(), apiResponse);
        idMap.put("accountId", apiResponse.getBody(SalesforceApiResponse.class).getId());
    }

    @After(value = "@DeleteAccount", order = 0)
    public void deleteAnAccount() {
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Account/{accountID}")
                .addPathParams("accountID", idMap.get("accountId"))
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
    }

    @Before(value = "@CreateContact")
    public void createAContact() throws JsonProcessingException {
        contact.setFirstName(contactName);
        contact.setLastName(contactLastName);
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Contact/")
                .addBody(new ObjectMapper().writeValueAsString(contact))
                .addMethod(ApiMethod.POST)
                .build();
        ApiManager.executeWithBody(requestBuilder.build(), apiResponse);
        idMap.put("contactId", apiResponse.getBody(SalesforceApiResponse.class).getId());
    }

    @After(value = "@DeleteContact", order = 1)
    public void deleteAContact() {
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Contact/{contactID}")
                .addPathParams("contactID", idMap.get("contactId"))
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
    }

    @After(value = "@DeleteCase",order = 2)
    public void deleteACase() {
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Case/{caseID}")
                .addPathParams("caseID", newCase.getId())
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
    }

    @After
    public void tearDown() {
        getWebDriverManager().quitDriver();
    }
}
