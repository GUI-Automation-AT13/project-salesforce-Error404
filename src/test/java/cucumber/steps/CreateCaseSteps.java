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
import org.testng.asserts.SoftAssert;
import salesforce.entities.Case;
import salesforce.ui.pages.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static salesforce.config.EnvironmentConfig.getPassword;
import static salesforce.config.EnvironmentConfig.getUsername;
import static salesforce.utils.Translator.translateValue;

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

    public CreateCaseSteps(Case newCase) {
        this.newCase = newCase;
    }

    @Given("I login to salesforce as a(n) {string} user")
    public void iLoginToSalesforceAsAUser(final String userType) {
        LoginPage loginPage = new LoginPage();
        loginPage.loginSuccessful(getUsername(), getPassword());
        HomePage homePage = new HomePage();
    }

    @When("I create a case with fields")
    public void iCreateACaseWith(final Map<String, String> entry)
            throws InvocationTargetException, IllegalAccessException {
        newCase.setCaseWithMap(entry);
        CasesPage casesPage = new CasesPage();
        CasesFormPage casesFormPage = casesPage.clickOnNew();
        newCase.setCaseOwner(casesFormPage.getCaseOwner());
        SingleCasePage singleCasePage = casesFormPage.createCase(entry.keySet(), newCase);
        actualMessage = casesFormPage.getPopUpMessage();
        newCase.updateCase(singleCasePage.getCaseNumber());
        newCase.setId(singleCasePage.getCaseId());
    }

    @Then("a success message is displayed")
    public void aSuccessIsDisplayed() {
        String expectedRegex = translateValue(featureName, "popup.message.regexp");
        softAssert.assertTrue(actualMessage.matches(expectedRegex),
                "\nactual: " + actualMessage + "\nexpected regex: " + expectedRegex);
    }

    @When("I check on the site's headers")
    public void iCheckOnTheSiteSHeaders() throws IllegalAccessException {
        SingleCasePage singleCasePage = new SingleCasePage();
        actualCaseHeadersValues = singleCasePage.getAllHeadersFields();
        System.out.println(actualCaseHeadersValues);
        expectedCaseHeadersValues = newCase.createMapOnKeySetFromCase(actualCaseHeadersValues.keySet());
        expectedCaseHeadersValues.put("title", translateValue(featureName, "title.case"));
    }

    @Then("all header's fields match to the created case")
    public void allHeaderSFieldsMatchToTheCreatedCase() {
        softAssert.assertEquals(actualCaseHeadersValues, expectedCaseHeadersValues);
    }

    @And("I check on the site's details")
    public void iCheckOnTheSiteSDetails() throws IllegalAccessException {
        SingleCasePage singleCasePage = new SingleCasePage();
        actualCaseDetailsValues = singleCasePage.getDetailsFields();
        expectedCaseDetailsValues = newCase.createMapOnKeySetFromCase(actualCaseDetailsValues.keySet());
    }

    @Then("all detail's fields match to the created case")
    public void allDetailSFieldsMatchToTheCreatedCase() {
        softAssert.assertEquals(actualCaseDetailsValues, expectedCaseDetailsValues);
    }

    @Then("the created case is displayed")
    public void theCreatedCaseIsDisplayed() throws IllegalAccessException {
        CasesPage casesPage = new CasesPage();
        actualCaseRowValues = casesPage.getRowFields(newCase.getCaseNumber());
        expectedCaseRowValues = newCase.createMapOnKeySetFromCase(actualCaseRowValues.keySet());
        softAssert.assertEquals(actualCaseRowValues, expectedCaseRowValues);
        softAssert.assertAll();
    }
}
