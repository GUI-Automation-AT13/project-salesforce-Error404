/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.hooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.Before;
import salesforce.api.petitions.AccountPetition;
import salesforce.entities.Account;
import static core.config.LoadEnvironmentFile.getTheBaseUrlClassic;
import static cucumber.hooks.Hooks.getCreatedToken;

public class AccountHooks {
    private ApiRequestBuilder requestBuilder;
    private ApiResponse apiResponse;
    private Account account;
    final String accountName = "Punisher";
    private static String accountId;
    private AccountPetition accountPetition = new AccountPetition();

    public AccountHooks(final ApiRequestBuilder newRequestBuilder, final ApiResponse newApiResponse,
                        final Account newAccount) {
        this.requestBuilder = newRequestBuilder;
        this.apiResponse = newApiResponse;
        this.account = newAccount;
    }

    @Before(value = "@CreateAccount")
    public void checkAccountCreation() throws JsonProcessingException {
        if (accountId == null) {
            accountPetition.createAccount(account, accountName, accountId, requestBuilder, apiResponse);
        }
    }

    @Before(value = "not @CreateAccount")
    public void checkAccountDeletion() {
        if (accountId != null) {
            accountPetition.deleteAccount(accountId, requestBuilder, apiResponse);
        }
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
