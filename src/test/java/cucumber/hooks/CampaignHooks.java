/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.hooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import salesforce.entities.Campaign;
import static salesforce.api.petitions.CampaignPetition.createCampaign;
import static salesforce.api.petitions.CampaignPetition.deleteCampaign;

public class CampaignHooks {
    private Campaign campaign;
    final String campaignName = "Opportunity Campaign";

    public CampaignHooks(final Campaign newCampaign) {
        this.campaign = newCampaign;
    }

    @Before(value = "@CreateCampaign")
    public void createACampaign() throws JsonProcessingException {
        campaign.setName(campaignName);
        createCampaign(campaign);
    }

    @After(value = "@CreateCampaign", order = 0)
    public void deleteACampaign() {
        deleteCampaign(campaign);
    }
}
