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
import core.utils.EncryptorAES;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
import java.util.Map;

public class LegalEntitySteps {

    private Logger logger = LogManager.getLogger(getClass());
    LoginPage loginPage;
    LegalEntitiesPage legalEntitiesPage;
    NewLegalEntityPage newLegalEntityPage;
    LegalEntity legalEntity;
    LegalEntityPage legalEntityPage;
    EncryptorAES encryptorAES;

    public LegalEntitySteps(LegalEntity legalEntity) {
        this.legalEntity = legalEntity;
    }

    @Given("^I login to Salesforce site as an admin user$")
    public void iLoginToSalesforceSiteAsAnAdminUser() {
        logger.info("=================== Given I login to Salesforce site ==========================");
        encryptorAES = new EncryptorAES();
        loginPage = new LoginPage();
        loginPage.loginSuccessful(getUsername(), getPassword());
        HomePage homePage = new HomePage();
    }

    @When("^I create a new LegalEntity with fields$")
    public void iCreateAnNewLegalEntityWithFields(final Map<String, String> table) throws JsonProcessingException {
        logger.info("=================== When I create a new legal entity ==========================");
        String json = new ObjectMapper().writeValueAsString(table);
        legalEntity = new ObjectMapper().readValue(json, LegalEntity.class);
        legalEntitiesPage = new LegalEntitiesPage();
        newLegalEntityPage = legalEntitiesPage.clickOnNew();
        newLegalEntityPage.createLegalEntity(table.keySet(), legalEntity);
    }

    @Then("A successful message should be displayed")
    public void aSuccessfulMessageIsDisplayed() {
        logger.info("=================== Then A successful message should be displayed ==========================");
        SoftAssert softAssert = new SoftAssert();
        legalEntityPage  = new LegalEntityPage();
        boolean message = legalEntityPage.getUserSuccessMessage().contains(legalEntity.getName());
        softAssert.assertTrue(message, "Message is incorrect");
        softAssert.assertAll();
    }

    @And("The header name should match in the created legal entity page")
    public void theHeaderNameShouldMatchInTheCreatedLegalEntityPage() {
        logger.info("=================== And The header name should match ==========================");
        SoftAssert softAssert = new SoftAssert();
        legalEntityPage = new LegalEntityPage();
        softAssert.assertEquals(legalEntity.getName(), legalEntityPage.getHeaderEntityNameText(),
                "Header name is incorrect");
        softAssert.assertAll();
    }

    @And("All given details fields should match in the created legal entity page")
    public void allGivenDetailsFieldsShouldMatchesInTheCreatedLegalEntityPage() {
        logger.info("=================== And All the given details fields should match ==========================");
        SoftAssert softAssert = new SoftAssert();
        legalEntityPage = new LegalEntityPage();
        softAssert.assertEquals(legalEntity.summaryMap(), legalEntityPage.entityMap(),
                "Fields doesn't match");
        softAssert.assertAll();
    }

    @Then("The created legal entity should be displayed on the legal entities table")
    public void theCreatedLegalEntityShouldBeDisplayedOnTheLegalEntitiesTable() {
        logger.info("=================== And The created legal entity should be on table ==========================");
        SoftAssert softAssert = new SoftAssert();
        LegalEntitiesPage legalEntitiesPage = new LegalEntitiesPage();
        legalEntity.setId(legalEntitiesPage.getLegalEntityId(legalEntity.getName()));
        softAssert.assertAll();
    }

}
