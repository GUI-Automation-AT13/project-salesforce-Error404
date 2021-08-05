/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.asserts.SoftAssert;
import salesforce.entities.Case;
import salesforce.ui.pages.cases.CasePage;
import salesforce.ui.pages.cases.CasesPage;
import salesforce.ui.pages.cases.NewCasesPage;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
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

    public CreateCaseSteps(final Case aNewCase) {
        this.newCase = aNewCase;
    }

    /**
     * Creates a case with provided values.
     *
     * @param entry a map with the fields and values
     * @throws InvocationTargetException when invalid target
     * @throws IllegalAccessException when unprovided access
     */
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

    /**
     * Verifies that a message matches a certain regex.
     */
    @Then("a success message is displayed")
    public void aSuccessIsDisplayed() {
        logger.info("=================== Then A successful message should be displayed ==========================");
        String expectedRegex = translateValue(featureName, "popup.message.regexp");
        softAssert.assertTrue(actualMessage.matches(expectedRegex),
                "\nactual: " + actualMessage + "\nexpected regex: " + expectedRegex);
    }

    /**
     * Creates a map with the headers.
     *
     * @throws IllegalAccessException
     */
    @When("I check on the site's headers")
    public void iCheckOnTheSiteSHeaders() throws IllegalAccessException {
        logger.info("=================== When I check on the site's headers ==========================");
        CasePage casePage = new CasePage();
        actualCaseHeadersValues = casePage.getAllHeadersFields();
        expectedCaseHeadersValues = newCase.createMapOnKeySetFromCase(actualCaseHeadersValues.keySet());
        expectedCaseHeadersValues.put("title", translateValue(featureName, "title.case"));
    }

    /**
     * Verifies that the headers match the entity.
     */
    @Then("all header's fields match to the created case")
    public void allHeaderSFieldsMatchToTheCreatedCase() {
        logger.info("=================== Then All header's fields should match ==========================");
        softAssert.assertEquals(actualCaseHeadersValues, expectedCaseHeadersValues);
    }

    /**
     * Creates a map with the details.
     *
     * @throws IllegalAccessException
     */
    @And("I check on the site's details")
    public void iCheckOnTheSiteSDetails() throws IllegalAccessException {
        logger.info("=================== And I check on the site's details ==========================");
        CasePage casePage = new CasePage();
        actualCaseDetailsValues = casePage.getDetailsFields();
        expectedCaseDetailsValues = newCase.createMapOnKeySetFromCase(actualCaseDetailsValues.keySet());
    }

    /**
     * Verifies that all the details match the entity.
     */
    @Then("all detail's fields match to the created case")
    public void allDetailSFieldsMatchToTheCreatedCase() {
        logger.info("=================== Then All the given details fields should match ==========================");
        softAssert.assertEquals(actualCaseDetailsValues, expectedCaseDetailsValues);
    }

    /**
     * Verifies that the created case is displayed on the cases page.
     * @throws IllegalAccessException
     */
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
