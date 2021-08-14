/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.api.petitions;

import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import salesforce.config.EnvironmentConfig;
import static core.config.LoadEnvironmentFile.getTheLoginUrl;
import static salesforce.config.EnvironmentConfig.*;

public class ApiSetUp {

    /**
     * Generates the token.
     *
     * @return the generated token.
     */
    public static String generateToken() {
        EnvironmentConfig.getEnvironmentConfig();
        ApiRequestBuilder requestBuilder = new ApiRequestBuilder();
        ApiResponse apiResponse = new ApiResponse();
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
        ApiManager.executeWithoutLog(requestBuilder.build(), apiResponse);
        return apiResponse.getPath("token_type").concat(" ")
                .concat(apiResponse.getPath("access_token"));
    }
}
