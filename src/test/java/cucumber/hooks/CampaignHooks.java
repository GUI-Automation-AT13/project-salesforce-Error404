package cucumber.hooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import salesforce.api.SalesforceApiResponse;
import salesforce.entities.Campaign;

public class CampaignHooks {
    private ApiRequestBuilder requestBuilder;
    private ApiResponse apiResponse;
    private Campaign campaign;
    final String campaignName = "Opportunity Campaign";

    public CampaignHooks(ApiRequestBuilder requestBuilder, ApiResponse apiResponse, Campaign newCampaign) {
        this.requestBuilder = requestBuilder;
        this.apiResponse = apiResponse;
        this.campaign = newCampaign;
    }

    @Before(value = "@CreateCampaign")
    public void createACampaign() throws JsonProcessingException {
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

    @After(value = "@CreateCampaign", order = 0)
    public void deleteACampaign() {
        requestBuilder
                .clearPathParams()
                .addEndpoint("/services/data/v52.0/sobjects/Campaign/{campaignId}")
                .addPathParams("campaignId", campaign.getId())
                .addMethod(ApiMethod.DELETE)
                .build();
        ApiManager.execute(requestBuilder.build(), apiResponse);
    }
}
