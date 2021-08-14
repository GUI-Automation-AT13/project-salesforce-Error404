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
import salesforce.api.SalesforceApiResponse;
import salesforce.entities.Campaign;

public class CampaignPetition {

    /**
     * Creates a Campaign.
     *
     * @param campaign the campaign to set.
     * @param campaignName the name of the campaign.
     * @param requestBuilder the request builder.
     * @param apiResponse the api response.
     * @throws JsonProcessingException the exception to be thrown.
     */
    public void createCampaign(final Campaign campaign, final String campaignName,
                               final ApiRequestBuilder requestBuilder, final ApiResponse apiResponse)
            throws JsonProcessingException {
        campaign.setName(campaignName);
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Campaign/")
                .addBody(new ObjectMapper().writeValueAsString(campaign))
                .addMethod(ApiMethod.POST)
                .build();
        ApiManager.executeWithBody(requestBuilder.build(), apiResponse);
        campaign.setId(apiResponse.getBody(SalesforceApiResponse.class).getId());
    }

    /**
     * Deletes a Campaign.
     *
     * @param campaign the campaign to set.
     * @param requestBuilder the request builder.
     * @param apiResponse the api response.
     */
    public void deleteCampaign(final Campaign campaign, final ApiRequestBuilder requestBuilder,
                               final ApiResponse apiResponse) {
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Campaign/{campaignId}")
                .addPathParams("campaignId", campaign.getId())
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
    }
}
