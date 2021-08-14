/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.hooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import salesforce.api.petitions.CampaignPetition;
import salesforce.entities.Campaign;

public class CampaignHooks {
    private ApiRequestBuilder requestBuilder;
    private ApiResponse apiResponse;
    private Campaign campaign;
    final String campaignName = "Opportunity Campaign";
    private CampaignPetition campaignPetition = new CampaignPetition();

    public CampaignHooks(final ApiRequestBuilder newRequestBuilder, final ApiResponse newApiResponse,
                         final Campaign newCampaign) {
        this.requestBuilder = newRequestBuilder;
        this.apiResponse = newApiResponse;
        this.campaign = newCampaign;
    }

    @Before(value = "@CreateCampaign")
    public void createACampaign() throws JsonProcessingException {
        campaignPetition.createCampaign(campaign, campaignName, requestBuilder, apiResponse);
    }

    @After(value = "@CreateCampaign", order = 0)
    public void deleteACampaign() {
        campaignPetition.deleteCampaign(campaign, requestBuilder, apiResponse);
    }
}
