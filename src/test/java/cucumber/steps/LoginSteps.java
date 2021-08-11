/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.steps;

import io.cucumber.java.en.Given;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.ui.pages.HomePage;
import salesforce.ui.pages.LoginPage;
import static salesforce.config.EnvironmentConfig.getPassword;
import static salesforce.config.EnvironmentConfig.getUsername;

public class LoginSteps {
    private Logger logger = LogManager.getLogger(getClass());

    /**
     * Logins to salesforce web site.
     *
     * @param userType the role the user has
     */
    @Given("^I login to salesforce as an? (.*?) user$")
    public void iLoginToSalesforceAsAnAdminUser(final String userType) {
        logger.info("=================== Given I login to Salesforce site ==========================");
        LoginPage loginPage = new LoginPage();
        loginPage.loginSuccessful(getUsername(), getPassword());
        HomePage homePage = new HomePage();
    }
}
