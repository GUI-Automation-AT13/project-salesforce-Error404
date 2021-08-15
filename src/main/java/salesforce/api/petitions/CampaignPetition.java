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
import salesforce.entities.Campaign;
import static core.config.LoadEnvironmentFile.getTheBaseUrlClassic;
import static salesforce.api.petitions.ApiSetUp.generateToken;

public class CampaignPetition {

    /**
     * Creates a Campaign.
     *
     * @param campaign the campaign to set.
     * @return a String with the campaign id.
     * @throws JsonProcessingException the exception to be thrown.
     */
    public static String createCampaign(final Campaign campaign) throws JsonProcessingException {
        ApiRequestBuilder requestBuilder = new ApiRequestBuilder();
        ApiResponse apiResponse =  new ApiResponse();
        requestBuilder
                .addHeader("Authorization", generateToken())
                .addBaseUri(getTheBaseUrlClassic())
                .addEndpoint("/services/data/v52.0/sobjects/Campaign/")
                .addBody(new ObjectMapper().writeValueAsString(campaign))
                .addMethod(ApiMethod.POST)
                .build();
        ApiManager.executeWithBody(requestBuilder.build(), apiResponse);
        return apiResponse.getPath("id");
    }

    /**
     * Deletes a Campaign.
     *
     * @param campaign the campaign to delete.
     */
    public static void deleteCampaign(final Campaign campaign) {
        ApiRequestBuilder requestBuilder = new ApiRequestBuilder();
        ApiResponse apiResponse =  new ApiResponse();
        requestBuilder
                .addHeader("Authorization", generateToken())
                .addBaseUri(getTheBaseUrlClassic())
                .addEndpoint("/services/data/v52.0/sobjects/Campaign/{campaignId}")
                .addPathParams("campaignId", campaign.getId())
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
    }
}
