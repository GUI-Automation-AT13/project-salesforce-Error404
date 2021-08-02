package cucumber.steps;

import core.utils.EncryptorAES;
import io.cucumber.java.en.Given;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.ui.pages.HomePage;
import salesforce.ui.pages.LoginPage;

import static salesforce.config.EnvironmentConfig.getPassword;
import static salesforce.config.EnvironmentConfig.getUsername;

public class LoginSteps {
    private Logger logger = LogManager.getLogger(getClass());

    @Given("^I login to salesforce as an? (.*?) user$")
    public void iLoginToSalesforceAsAnAdminUser(final String userType) {
        logger.info("=================== Given I login to Salesforce site ==========================");
        LoginPage loginPage = new LoginPage();
        loginPage.loginSuccessful(getUsername(), getPassword());
        HomePage homePage = new HomePage();
    }
}
