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
import salesforce.entities.LegalEntity;

public class LegalEntityHooks {
    private ApiRequestBuilder requestBuilder;
    private ApiResponse apiResponse;
    private LegalEntity legalEntity;

    public LegalEntityHooks(final ApiRequestBuilder newRequestBuilder, final ApiResponse newApiResponse,
                            final LegalEntity newLegalEntity) {
        this.requestBuilder = newRequestBuilder;
        this.apiResponse = newApiResponse;
        this.legalEntity = newLegalEntity;
    }

    @After(value = "@DeleteLegalEntity", order = 2)
    public void deleteALegalEntity() {
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/LegalEntity/{legalId}")
                .addPathParams("legalId", legalEntity.getId())
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
    }
}
