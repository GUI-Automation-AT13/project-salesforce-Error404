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
import static core.config.LoadEnvironmentFile.getTheBaseUrlClassic;
import static salesforce.api.petitions.ApiSetUp.generateToken;

public class AccountPetition {

    /**
     * Creates an Account.
     *
     * @param account to set.
     * @return a String with the account id
     * @throws JsonProcessingException exception to be thrown.
     */
    public static String createAccount(final Account account) throws JsonProcessingException {
        ApiRequestBuilder requestBuilder = new ApiRequestBuilder();
        ApiResponse apiResponse =  new ApiResponse();
        requestBuilder
                .addHeader("Authorization", generateToken())
                .addBaseUri(getTheBaseUrlClassic())
                .addEndpoint("/services/data/v52.0/sobjects/Account/")
                .addBody(new ObjectMapper().writeValueAsString(account))
                .addMethod(ApiMethod.POST)
                .build();
        ApiManager.executeWithBody(requestBuilder.build(), apiResponse);
        return apiResponse.getPath("id");
    }

    /**
     * Deletes an Account.
     *
     * @param accountId id of the account.
     */
    public static void deleteAccount(final String accountId) {
        ApiRequestBuilder requestBuilder = new ApiRequestBuilder();
        ApiResponse apiResponse =  new ApiResponse();
        requestBuilder
                .addHeader("Authorization", generateToken())
                .addBaseUri(getTheBaseUrlClassic())
                .addEndpoint("/services/data/v52.0/sobjects/Account/{accountID}")
                .addPathParams("accountID", accountId)
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
    }
}
