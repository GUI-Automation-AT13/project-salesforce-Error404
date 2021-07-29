package cucumber.hooks;

import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.After;
import salesforce.entities.Case;

public class CaseHooks {
    private ApiRequestBuilder requestBuilder;
    private ApiResponse apiResponse;
    private Case newCase;

    public CaseHooks(ApiRequestBuilder requestBuilder, ApiResponse apiResponse, Case newCase) {
        this.requestBuilder = requestBuilder;
        this.apiResponse = apiResponse;
        this.newCase = newCase;
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
}
