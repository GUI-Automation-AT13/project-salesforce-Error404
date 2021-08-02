/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import salesforce.entities.Case;
import salesforce.ui.pages.*;
import salesforce.ui.pages.cases.CasePage;
import salesforce.ui.pages.cases.CasesPage;
import salesforce.ui.pages.cases.NewCasesPage;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import static salesforce.config.EnvironmentConfig.getPassword;
import static salesforce.config.EnvironmentConfig.getUsername;
import static salesforce.utils.FileTranslator.translateValue;

public class CreateCaseSteps {
    Case newCase;
    String actualMessage;
    Map actualCaseDetailsValues;
    Map expectedCaseDetailsValues;
    Map actualCaseHeadersValues;
    Map expectedCaseHeadersValues;
    Map actualCaseRowValues;
    Map expectedCaseRowValues;
    SoftAssert softAssert = new SoftAssert();
    String featureName = "Cases";
    private Logger logger = LogManager.getLogger(getClass());

    public CreateCaseSteps(Case newCase) {
        this.newCase = newCase;
    }

    @When("I create a case with fields")
    public void iCreateACaseWith(final Map<String, String> entry)
            throws InvocationTargetException, IllegalAccessException {
        logger.info("=================== When I create a new case ==========================");
        newCase.setCaseWithMap(entry);
        CasesPage casesPage = new CasesPage();
        NewCasesPage newCasesPage = casesPage.clickOnNew();
        newCase.setCaseOwner(newCasesPage.getCaseOwner());
        CasePage casePage = newCasesPage.createCase(entry.keySet(), newCase);
        actualMessage = newCasesPage.getPopUpMessage();
        newCase.updateCase(casePage.getCaseNumber());
        newCase.setId(casePage.getCaseId());
    }

    @Then("a success message is displayed")
    public void aSuccessIsDisplayed() {
        logger.info("=================== Then A successful message should be displayed ==========================");
        String expectedRegex = translateValue(featureName, "popup.message.regexp");
        softAssert.assertTrue(actualMessage.matches(expectedRegex),
                "\nactual: " + actualMessage + "\nexpected regex: " + expectedRegex);
    }

    @When("I check on the site's headers")
    public void iCheckOnTheSiteSHeaders() throws IllegalAccessException {
        logger.info("=================== When I check on the site's headers ==========================");
        CasePage casePage = new CasePage();
        actualCaseHeadersValues = casePage.getAllHeadersFields();
        expectedCaseHeadersValues = newCase.createMapOnKeySetFromCase(actualCaseHeadersValues.keySet());
        expectedCaseHeadersValues.put("title", translateValue(featureName, "title.case"));
    }

    @Then("all header's fields match to the created case")
    public void allHeaderSFieldsMatchToTheCreatedCase() {
        logger.info("=================== Then All header's fields should match ==========================");
        softAssert.assertEquals(actualCaseHeadersValues, expectedCaseHeadersValues);
    }

    @And("I check on the site's details")
    public void iCheckOnTheSiteSDetails() throws IllegalAccessException {
        logger.info("=================== And I check on the site's details ==========================");
        CasePage casePage = new CasePage();
        actualCaseDetailsValues = casePage.getDetailsFields();
        expectedCaseDetailsValues = newCase.createMapOnKeySetFromCase(actualCaseDetailsValues.keySet());
    }

    @Then("all detail's fields match to the created case")
    public void allDetailSFieldsMatchToTheCreatedCase() {
        logger.info("=================== Then All the given details fields should match ==========================");
        softAssert.assertEquals(actualCaseDetailsValues, expectedCaseDetailsValues);
    }

    @Then("the created case is displayed")
    public void theCreatedCaseIsDisplayed() throws IllegalAccessException {
        logger.info("=================== Then The created case should be displayed ==========================");
        CasesPage casesPage = new CasesPage();
        actualCaseRowValues = casesPage.getRowFields(newCase.getCaseNumber());
        expectedCaseRowValues = newCase.createMapOnKeySetFromCase(actualCaseRowValues.keySet());
        softAssert.assertEquals(actualCaseRowValues, expectedCaseRowValues);
        softAssert.assertAll();
    }
}
