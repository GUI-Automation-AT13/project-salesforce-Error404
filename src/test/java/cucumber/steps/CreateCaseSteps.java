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
import salesforce.ui.pages.cases.PopUpMessage;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import static salesforce.utils.FileTranslator.translateValue;

public class CreateCaseSteps {
    private Case newCase;
    SoftAssert softAssert;
    String featureName = "Cases";
    private Logger logger = LogManager.getLogger(getClass());

    public CreateCaseSteps(final Case aNewCase, final SoftAssert newSoftAssert) {
        this.newCase = aNewCase;
        this.softAssert = newSoftAssert;
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
        newCase.updateCase(casePage.getCaseNumber());
        newCase.setId(casePage.getCaseId());
    }

    /**
     * Verifies that a message matches a certain regex.
     */
    @Then("a case created message should be displayed")
    public void aCaseCreatedMessageShouldBeDisplayed() {
        logger.info("=================== Then A successful message should be displayed ==========================");
        PopUpMessage popUpMessage = new PopUpMessage();
        String actualMessage = popUpMessage.getPopUpMessage();
        String expectedRegex = translateValue(featureName, "popup.message.regexp");
        softAssert.assertTrue(actualMessage.matches(expectedRegex),
                "\nactual: " + actualMessage + "\nexpected regex: " + expectedRegex);
    }

    /**
     * Verifies that the headers match the entity.
     */
    @And("all header's fields should match the created case")
    public void allHeaderSFieldsShouldMatchTheCreatedCase() throws IllegalAccessException {
        CasePage casePage = new CasePage();
        Map actualCaseHeadersValues = casePage.getAllHeadersFields();
        Map expectedCaseHeadersValues = newCase.createMapOnKeySetFromCase(actualCaseHeadersValues.keySet());
        expectedCaseHeadersValues.put("title", translateValue(featureName, "title.case"));
        softAssert.assertEquals(actualCaseHeadersValues, expectedCaseHeadersValues);
    }

    /**
     * Verifies that all the details match the entity.
     */
    @Then("all detail's fields should match the created case")
    public void allDetailSFieldsShouldMatchTheCreatedCase() throws IllegalAccessException {
        CasePage casePage = new CasePage();
        Map actualCaseDetailsValues = casePage.getDetailsFields();
        Map expectedCaseDetailsValues = newCase.createMapOnKeySetFromCase(actualCaseDetailsValues.keySet());
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
        Map actualCaseRowValues = casesPage.getRowFields(newCase.getCaseNumber());
        Map expectedCaseRowValues = newCase.createMapOnKeySetFromCase(actualCaseRowValues.keySet());
        softAssert.assertEquals(actualCaseRowValues, expectedCaseRowValues);
    }
}
