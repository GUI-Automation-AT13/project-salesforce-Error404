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
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import static salesforce.config.EnvironmentConfig.getPassword;
import static salesforce.config.EnvironmentConfig.getUsername;

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
    private Logger logger = LogManager.getLogger(getClass());

    public CreateCaseSteps(Case newCase) {
        this.newCase = newCase;
    }

    @Given("I login to salesforce as a(n) {string} user")
    public void iLoginToSalesforceAsAUser(final String userType) {
        logger.info("=================== Given I login to Salesforce site ==========================");
        //get user credentials
        String username = getUsername();
        String password = getPassword();
        //login
        LoginPage loginPage = new LoginPage();
        loginPage.loginSuccessful(username, password);
        HomePage homePage = new HomePage();
    }

    @When("I create a case with fields")
    public void iCreateACaseWith(final Map<String, String> entry)
            throws InvocationTargetException, IllegalAccessException {
        logger.info("=================== When I create a new case ==========================");
        newCase.setCaseWithMap(entry);
        CasesPage casesPage = new CasesPage();
        CasesFormPage casesFormPage = casesPage.clickOnNew();
        newCase.setCaseOwner(casesFormPage.getCaseOwner());
        SingleCasePage singleCasePage = casesFormPage.createCase(entry.keySet(), newCase);
        actualMessage = casesFormPage.getPopUpMessage();
        newCase.updateCase(singleCasePage.getHeadersField("Case Number"));
    }

    @Then("a success message is displayed")
    public void aSuccessIsDisplayed() {
        logger.info("=================== Then A successful message should be displayed ==========================");
        String expectedRegex = "Case \"[0-9]{8}\" was created.";
        softAssert.assertTrue(actualMessage.matches(expectedRegex),
                "\nactual: " + actualMessage + "\nexpected regex: " + expectedRegex);
    }

    @When("I check on the site's headers")
    public void iCheckOnTheSiteSHeaders() throws IllegalAccessException {
        logger.info("=================== When I check on the site's headers ==========================");
        SingleCasePage singleCasePage = new SingleCasePage();
        actualCaseHeadersValues = singleCasePage.getHeadersFields();
        expectedCaseHeadersValues = newCase.createMapOnKeySetFromCase(actualCaseHeadersValues.keySet());
        expectedCaseHeadersValues.put("title", newCase.getClass().getSimpleName());
    }

    @Then("all header's fields match to the created case")
    public void allHeaderSFieldsMatchToTheCreatedCase() {
        logger.info("=================== Then All header's fields should match ==========================");
        softAssert.assertEquals(actualCaseHeadersValues, expectedCaseHeadersValues);
    }

    @And("I check on the site's details")
    public void iCheckOnTheSiteSDetails() throws IllegalAccessException {
        logger.info("=================== And I check on the site's details ==========================");
        SingleCasePage singleCasePage = new SingleCasePage();
        actualCaseDetailsValues = singleCasePage.getDetailsFields();
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
        newCase.setId(casesPage.getCaseId(newCase.getCaseNumber()));
        actualCaseRowValues = casesPage.getRowFields(newCase.getCaseNumber());
        expectedCaseRowValues = newCase.createMapOnKeySetFromCase(actualCaseRowValues.keySet());
        softAssert.assertEquals(actualCaseRowValues, expectedCaseRowValues);
        softAssert.assertAll();
    }
}
