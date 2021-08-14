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
import static core.config.LoadEnvironmentFile.getTheBaseUrlClassic;
import static core.config.LoadEnvironmentFile.getTheLoginUrl;
import static salesforce.config.EnvironmentConfig.*;

public class ApiSetUp {

    /**
     * Generates the token.
     *
     * @param requestBuilder the request builder.
     * @param tokenApiResponse the api response.
     * @return the generated token.
     */
    public String generateToken(final ApiRequestBuilder requestBuilder, final ApiResponse tokenApiResponse) {
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
        String token = tokenApiResponse.getPath("token_type").concat(" ")
                .concat(tokenApiResponse.getPath("access_token"));

        return token;
    }

    /**
     * Sets the token and Base Uri.
     *
     * @param requestBuilder the request builder.
     * @param token the token generated.
     */
    public void setTokenBaseUri(final ApiRequestBuilder requestBuilder, final String token) {
        requestBuilder
                .addHeader("Authorization", token)
                .addBaseUri(getTheBaseUrlClassic());
    }
}
