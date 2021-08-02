package cucumber.hooks;

import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.After;
import salesforce.entities.legalentity.LegalEntity;

public class LegalEntityHooks {
    private ApiRequestBuilder requestBuilder;
    private ApiResponse apiResponse;
    private LegalEntity legalEntity;

    public LegalEntityHooks(ApiRequestBuilder requestBuilder, ApiResponse apiResponse, LegalEntity legal) {
        this.requestBuilder = requestBuilder;
        this.apiResponse = apiResponse;
        this.legalEntity = legal;
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
