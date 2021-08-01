package cucumber.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import salesforce.entities.Opportunity;
import salesforce.ui.pages.LoginPage;
import salesforce.ui.pages.opportunity.CreatedOpportunityPage;
import salesforce.ui.pages.opportunity.NewOpportunityPage;
import salesforce.ui.pages.opportunity.OpportunityPage;
import salesforce.utils.Translator;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import static salesforce.config.EnvironmentConfig.getPassword;
import static salesforce.config.EnvironmentConfig.getUsername;

public class OpportunitySteps {

    LoginPage loginPage = new LoginPage();
    Opportunity opportunity;
    NewOpportunityPage formOpportunity;
    CreatedOpportunityPage createdForm;
    OpportunityPage opportunityPage;
    SoftAssert softAssert = new SoftAssert();
    Set<String> fields;

    @Given("I login to Salesforce site as a developer user")
    public void iLoginToSalesforceSiteAsAnUser() {
        String usernameLogin = getUsername();
        String passwordLogin = getPassword();
        loginPage.loginSuccessful(usernameLogin, passwordLogin );
    }

    @When("I create a new Opportunity with fields")
    public void iCreateAFeatureWithFields(final Map<String, String> dataTable) throws IOException {
        opportunity = new ObjectMapper().readValue(new ObjectMapper().writeValueAsString(dataTable), Opportunity.class);
        opportunity.setOpportunityDetailField();
        opportunityPage  = new OpportunityPage();
        formOpportunity = opportunityPage.openNewOpportunityForm();
        fields = dataTable.keySet();
        createdForm = formOpportunity.createNewOpportunity(fields, opportunity);
    }

    @Then("Successful message appear with Opportunity name")
    public void successfulMessageAppearAndMatches() {
        softAssert.assertEquals(createdForm.getSuccessfulAlert(), "\"" + opportunity.getOpportunityName() + "\"");
    }

    @Then("All Opportunity headers match with previous fields")
    public void headersMatchWithPreviousFields() {
        softAssert.assertEquals(createdForm.getTitleHeader(), opportunity.getOpportunityName());
        softAssert.assertEquals(createdForm.getHeaderString(Translator.translateValue("Opportunity", "accountName"), "span[@class='slds-assistive-text']"), "Open " + opportunity.getSearchAccount() + " Preview");
        softAssert.assertEquals(createdForm.getHeaderString(Translator.translateValue("Opportunity", "closeDate"), "lightning-formatted-text"), opportunity.getCloseDate());
        //softAssert.assertEquals(createdForm.getHeaderString(Translator.translateValue("Opportunity", "amount"), "lightning-formatted-text"), opportunity.getAmount() + " ¤");
        softAssert.assertEquals(createdForm.getCurrentStage(), opportunity.getOpportunityStage());
    }

    @And("Opportunity details match with previous fields")
    public void detailsMatchWithPreviousFields() {
        createdForm.clickDetails();
        softAssert.assertTrue(opportunity.getMapFields().equals(createdForm.getDetailMap()));
    }

    @After(value = "DeleteOpportunity", order = 0)
    public void deleteOpportunity() {
        createdForm.deleteCreatedOpportunity();
        softAssert.assertAll();
    }
}
