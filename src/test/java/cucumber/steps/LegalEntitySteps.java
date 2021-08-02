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
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import salesforce.entities.legalentity.LegalEntity;
import salesforce.ui.pages.HomePage;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.legalentity.LegalEntitiesPage;
import salesforce.ui.pages.legalentity.LegalEntityPage;
import salesforce.ui.pages.legalentity.NewLegalEntityPage;
import static salesforce.config.EnvironmentConfig.getPassword;
import static salesforce.config.EnvironmentConfig.getUsername;

public class LegalEntitySteps {

    LegalEntity legalEntity;
    private final Logger logger = LogManager.getLogger(getClass());
    SoftAssert softAssert = new SoftAssert();

    public LegalEntitySteps(LegalEntity legalEntity) {
        this.legalEntity = legalEntity;
    }

    @When("^I create a new LegalEntity with fields$")
    public void iCreateAnNewLegalEntityWithFields(final Map<String, String> table) throws JsonProcessingException {
        logger.info("=================== When I create a new legal entity ==========================");
        String json = new ObjectMapper().writeValueAsString(table);
        legalEntity = new ObjectMapper().readValue(json, LegalEntity.class);
        LegalEntitiesPage legalEntitiesPage = new LegalEntitiesPage();
        NewLegalEntityPage newLegalEntityPage = legalEntitiesPage.clickOnNew();
        newLegalEntityPage.createLegalEntity(table.keySet(), legalEntity);
    }

    @Then("A successful message should be displayed")
    public void aSuccessfulMessageIsDisplayed() {
        logger.info("=================== Then A successful message should be displayed ==========================");
        LegalEntityPage legalEntityPage  = new LegalEntityPage();
        boolean message = legalEntityPage.getUserSuccessMessage().contains(legalEntity.getName());
        softAssert.assertTrue(message, "Message is incorrect");
    }

    @And("The header name should match in the created legal entity page")
    public void theHeaderNameShouldMatchInTheCreatedLegalEntityPage() {
        logger.info("=================== And The header name should match ==========================");
        LegalEntityPage legalEntityPage = new LegalEntityPage();
        softAssert.assertEquals(legalEntity.getName(), legalEntityPage.getHeaderEntityNameText(),
                "Header name is incorrect");
    }

    @And("All given details fields should match in the created legal entity page")
    public void allGivenDetailsFieldsShouldMatchesInTheCreatedLegalEntityPage() {
        logger.info("=================== And All the given details fields should match ==========================");
        LegalEntityPage legalEntityPage = new LegalEntityPage();
        softAssert.assertEquals(legalEntity.summaryMap(), legalEntityPage.entityMap(), "Fields doesn't match");
    }

    @Then("The created legal entity should be displayed on the legal entities table")
    public void theCreatedLegalEntityShouldBeDisplayedOnTheLegalEntitiesTable() {
        logger.info("=================== Then The created legal entity should be on table ==========================");
        LegalEntitiesPage legalEntitiesPage = new LegalEntitiesPage();
        legalEntity.setId(legalEntitiesPage.getLegalEntityId(legalEntity.getName()));
        softAssert.assertAll();
    }

}
