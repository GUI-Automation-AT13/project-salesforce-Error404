/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.api.petitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import salesforce.entities.Account;

public class AccountPetition {

    /**
     * Creates an Account.
     *
     * @param account to set.
     * @param accountName name of the account.
     * @param accountId id of the account.
     * @param requestBuilder the request builder.
     * @param apiResponse the api response.
     * @throws JsonProcessingException exception to be thrown.
     */
    public void createAccount(final Account account, final String accountName, String accountId,
                              final ApiRequestBuilder requestBuilder, final ApiResponse apiResponse)
            throws JsonProcessingException {
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

    /**
     * Deletes an Account.
     *
     * @param accountId id of the account.
     * @param requestBuilder the request builder.
     * @param apiResponse the api response.
     */
    public void deleteAccount(String accountId, final ApiRequestBuilder requestBuilder,
                              final ApiResponse apiResponse) {
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Account/{accountID}")
                .addPathParams("accountID", accountId)
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
        accountId = null;
    }
}
