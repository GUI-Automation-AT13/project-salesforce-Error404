/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.hooks;

import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.After;
import salesforce.api.petitions.CasePetition;
import salesforce.entities.Case;

public class CaseHooks {
    private ApiRequestBuilder requestBuilder;
    private ApiResponse apiResponse;
    private Case newCase;
    private CasePetition casePetition = new CasePetition();

    public CaseHooks(final ApiRequestBuilder newRequestBuilder, final ApiResponse newApiResponse, final Case aNewCase) {
        this.requestBuilder = newRequestBuilder;
        this.apiResponse = newApiResponse;
        this.newCase = aNewCase;
    }

    @After(value = "@DeleteCase", order = 2)
    public void deleteACase() {
        casePetition.deleteCase(requestBuilder, apiResponse, newCase);
    }
}
