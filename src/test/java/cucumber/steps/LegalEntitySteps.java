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
    Map<String, String> tableData;
    EncryptorAES encryptorAES;

    public LegalEntitySteps(LegalEntity legalEntity) {
        this.legalEntity = legalEntity;
    }

    @Given("^I login to Salesforce site as an? (.*?) user$")
    public void iLoginToSalesforceSiteAsAnUser(final String userType) throws Exception {
        encryptorAES = new EncryptorAES();
        loginPage = new LoginPage();
        loginPage.loginSuccessful(getUsername(), getPassword());
        HomePage homePage = new HomePage();
    }

    @When("^I create a new (.*?) with fields$")
    public void iCreateAnNewFeatureWithFields(final String feature, final Map<String, String> table) throws JsonProcessingException, IllegalAccessException {
        tableData = table;
        String json = new ObjectMapper().writeValueAsString(tableData);
        legalEntity = new ObjectMapper().readValue(json, LegalEntity.class);
        legalEntitiesPage = new LegalEntitiesPage();
        newLegalEntityPage = legalEntitiesPage.clickOnNew();
        newLegalEntityPage.createLegalEntity(tableData.keySet(), legalEntity);
    }

    @Then("A successful message is displayed")
    public void aSuccessfulMessageIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        legalEntityPage  = new LegalEntityPage();
        boolean message = legalEntityPage.getUserSuccessMessage().contains(legalEntity.getName());
        softAssert.assertTrue(message, "Message is incorrect");
        softAssert.assertAll();
    }

    @And("The title matches")
    public void theTitleMatches() {
        SoftAssert softAssert = new SoftAssert();
        legalEntityPage = new LegalEntityPage();
        softAssert.assertEquals(legalEntity.getName(), legalEntityPage.getHeaderEntityNameText(), "Header name is incorrect");
        softAssert.assertAll();
    }

    @And("All given details fields matches")
    public void allGivenDetailsFieldsMatches() {
        SoftAssert softAssert = new SoftAssert();
        legalEntityPage = new LegalEntityPage();
        softAssert.assertEquals(legalEntity.summaryMap(), legalEntityPage.entityMap(), "Fields doesn't match");
        softAssert.assertAll();
    }

    @Then("the created legal entity is displayed")
    public void theCreatedCaseIsDisplayed() {
        SoftAssert softAssert = new SoftAssert();
        LegalEntitiesPage legalEntitiesPage = new LegalEntitiesPage();
        legalEntity.setId(legalEntitiesPage.getLegalEntityId(legalEntity.getName()));
        softAssert.assertAll();
    }

}
