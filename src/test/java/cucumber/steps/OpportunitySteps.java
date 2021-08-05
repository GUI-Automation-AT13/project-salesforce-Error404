/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import salesforce.entities.Opportunity;
import salesforce.ui.pages.opportunity.CreatedOpportunityPage;
import salesforce.ui.pages.opportunity.NewOpportunityPage;
import salesforce.ui.pages.opportunity.OpportunityPage;
import salesforce.utils.FileTranslator;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class OpportunitySteps {

    private Logger logger = LogManager.getLogger(getClass());
    Opportunity opportunity;
    NewOpportunityPage formOpportunity;
    CreatedOpportunityPage createdForm;
    OpportunityPage opportunityPage;
    SoftAssert softAssert = new SoftAssert();
    Set<String> fields;

    /**
     * Creates an opportunity with provided values.
     *
     * @param dataTable a map with the fields and values
     * @throws IOException
     */
    @When("I create a new Opportunity with fields")
    public void iCreateAFeatureWithFields(final Map<String, String> dataTable) throws IOException {
        logger.info("=================== When I create a new Opportunity with fields ==========================");
        opportunity = new ObjectMapper().readValue(new ObjectMapper().writeValueAsString(dataTable), Opportunity.class);
        opportunity.setOpportunityDetailField();
        opportunityPage  = new OpportunityPage();
        formOpportunity = opportunityPage.openNewOpportunityForm();
        fields = dataTable.keySet();
        createdForm = formOpportunity.createNewOpportunity(fields, opportunity);
    }

    /**
     * Verifies that a success message is displayed.
     */
    @Then("Successful message appear with Opportunity name")
    public void successfulMessageAppearAndMatches() {
        logger.info("=================== Then a successful message appear ==========================");
        softAssert.assertEquals(createdForm.getSuccessfulAlert(), "\"" + opportunity.getOpportunityName() + "\"");
    }

    /**
     * Verifies that the opportunities headers match the entity.
     */
    @Then("All Opportunity headers match with previous fields")
    public void headersMatchWithPreviousFields() {
        logger.info("=================== Then opportunity headers match with previous fields =======================");
        softAssert.assertEquals(createdForm.getTitleHeader(), opportunity.getOpportunityName());
        softAssert.assertEquals(createdForm.getHeaderString(FileTranslator
                .translateValue("Opportunity", "accountName"),
                "span[@class='slds-assistive-text']"), "Open " + opportunity.getSearchAccount() + " Preview");
        softAssert.assertEquals(createdForm.getHeaderString(FileTranslator
                .translateValue("Opportunity", "closeDate"), "lightning-formatted-text"), opportunity.getCloseDate());
        softAssert.assertEquals(createdForm.getCurrentStage(), opportunity.getOpportunityStage());
    }

    /**
     * Verifies that the opportunity details match the entity.
     */
    @And("Opportunity details match with previous fields")
    public void detailsMatchWithPreviousFields() {
        logger.info("=================== And details match with previous fields ==========================");
        createdForm.clickDetails();
        softAssert.assertTrue(opportunity.getMapFields().equals(createdForm.getDetailMap()));
    }
}
