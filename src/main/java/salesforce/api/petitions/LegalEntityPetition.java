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
import salesforce.entities.LegalEntity;

import static core.config.LoadEnvironmentFile.getTheBaseUrlClassic;
import static salesforce.api.petitions.ApiSetUp.generateToken;

public class LegalEntityPetition {

    /**
     * Deletes a Legal Entity.
     *
     * @param legalEntity to delete.
     */
    public static void deleteLegalEntity(final LegalEntity legalEntity) {
        ApiRequestBuilder requestBuilder = new ApiRequestBuilder();
        ApiResponse apiResponse =  new ApiResponse();
        requestBuilder
                .addHeader("Authorization", generateToken())
                .addBaseUri(getTheBaseUrlClassic())
                .addEndpoint("/services/data/v52.0/sobjects/LegalEntity/{legalId}")
                .addPathParams("legalId", legalEntity.getId())
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
    }
}
