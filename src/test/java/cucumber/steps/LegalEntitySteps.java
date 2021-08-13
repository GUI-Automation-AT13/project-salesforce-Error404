/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import salesforce.entities.LegalEntity;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.legalentity.LegalEntityPageAbstract;
import salesforce.ui.pages.legalentity.NewLegalEntityPageAbstract;
import static salesforce.config.EnvironmentConfig.getSalesforceVersion;

public class LegalEntitySteps {

    private final Logger logger = LogManager.getLogger(getClass());
    SoftAssert softAssert = new SoftAssert();
    private String lightningSkin = "lightning";
    LegalEntity legalEntity;

    public LegalEntitySteps(final LegalEntity newLegalEntity) {
        this.legalEntity = newLegalEntity;
    }

    /**
     * Creates a legal entity with provided values.
     *
     * @param table a map with the fields and values
     * @throws JsonProcessingException when invalid json provided
     */
    @When("^I create a new LegalEntity with fields$")
    public void iCreateAnNewLegalEntityWithFields(final Map<String, String> table) throws JsonProcessingException, InterruptedException {
        logger.info("=================== When I create a new legal entity ==========================");
        String json = new ObjectMapper().writeValueAsString(table);
        legalEntity.setEntity(new ObjectMapper().readValue(json, LegalEntity.class));
        NewLegalEntityPageAbstract newLegalEntityPageAbstract = AppPageFactory.getLegalEntitiesPage().clickOnNew();
        newLegalEntityPageAbstract.createLegalEntity(table.keySet(), legalEntity);
    }

    /**
     * Verifies that a success message is displayed on created legal entity.
     */
    @Then("A successful message should be displayed")
    public void aSuccessfulMessageIsDisplayed() {
        logger.info("=================== Then A successful message should be displayed ==========================");
        if (getSalesforceVersion().equals(lightningSkin)) {
            LegalEntityPageAbstract legalEntityPageAbstract = AppPageFactory.getLegalEntityPage();
            boolean message = legalEntityPageAbstract.getSuccessMessage().contains(legalEntity.getName());
            softAssert.assertTrue(message, "Message is incorrect");
        }
    }

    /**
     * Verifies that the legal entity headers match the entity.
     */
    @And("The header name should match in the created legal entity page")
    public void theHeaderNameShouldMatchInTheCreatedLegalEntityPage() {
        logger.info("=================== And The header name should match ==========================");
        softAssert.assertEquals(legalEntity.getName(), AppPageFactory.getLegalEntityPage().getHeaderEntityNameText(),
                "Header name is incorrect");
    }

    /**
     * Verifies that the legal entity details match the entity.
     */
    @And("All given details fields should match in the created legal entity page")
    public void allGivenDetailsFieldsShouldMatchesInTheCreatedLegalEntityPage() {
        logger.info("=================== And All the given details fields should match ==========================");
        softAssert.assertEquals(legalEntity.summaryMap(), AppPageFactory.getLegalEntityPage().entityMap(),
                "Fields doesn't match");
    }

    /**
     * Verifies that the created legal entity is displayed on legal entities page.
     */
    @Then("The created legal entity should be displayed on the legal entities table")
    public void theCreatedLegalEntityShouldBeDisplayedOnTheLegalEntitiesTable() {
        logger.info("=================== Then The created legal entity should be on table ==========================");
        legalEntity.setId(AppPageFactory.getLegalEntitiesPage().getLegalEntityId(legalEntity.getName()));
    }

}
