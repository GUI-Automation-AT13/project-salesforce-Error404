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
import io.cucumber.java.Before;
import salesforce.entities.Account;
import static core.config.LoadEnvironmentFile.getTheBaseUrlClassic;
import static cucumber.hooks.Hooks.getCreatedToken;

public class AccountHooks {
    private ApiRequestBuilder requestBuilder;
    private ApiResponse apiResponse;
    private Account account;
    final String accountName = "Punisher";
    private static String accountId;

    public AccountHooks(final ApiRequestBuilder newRequestBuilder, final ApiResponse newApiResponse,
                        final Account newAccount) {
        this.requestBuilder = newRequestBuilder;
        this.apiResponse = newApiResponse;
        this.account = newAccount;
    }

    /**
     * Creates an account through the API.
     *
     * @throws JsonProcessingException when invalid json provided
     */
    public void createAnAccount() throws JsonProcessingException {
        account.setName(accountName);
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Account/")
                .addBody(new ObjectMapper().writeValueAsString(account))
                .addMethod(ApiMethod.POST)
                .build();
        ApiManager.executeWithBody(requestBuilder.build(), apiResponse);
        accountId = apiResponse.getPath("id");
    }

    @Before(value = "@CreateAccount")
    public void checkAccountCreation() throws JsonProcessingException {
        if (accountId == null) {
            createAnAccount();
        }
    }

    @Before(value = "not @CreateAccount")
    public void checkAccountDeletion() {
        if (accountId != null) {
            deleteAnAccount();
        }
    }

    /**
     * Deletes an account through API.
     */
    public void deleteAnAccount() {
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Account/{accountID}")
                .addPathParams("accountID", accountId)
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
        accountId = null;
    }

    /**
     * Deletes an account.
     */
    public static void deleteAccount() {
        if (accountId != null) {
            ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
            ApiResponse response = new ApiResponse();
            apiRequestBuilder
                    .addHeader("Authorization", getCreatedToken())
                    .addBaseUri(getTheBaseUrlClassic())
                    .addEndpoint("/services/data/v52.0/sobjects/Contact/{contactID}")
                    .addPathParams("contactID", accountId)
                    .addMethod(ApiMethod.DELETE)
                    .build();
            ApiManager.execute(apiRequestBuilder.build(), response);
            accountId = null;
        }
    }
}
