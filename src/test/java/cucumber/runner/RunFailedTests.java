/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import static cucumber.hooks.AccountHooks.getAccountId;
import static cucumber.hooks.ContactHooks.getContactId;
import static salesforce.api.petitions.AccountPetition.deleteAccount;
import static salesforce.api.petitions.ContactPetition.deleteContact;

@CucumberOptions(
        glue = {"cucumber"},
        features = {"@target/failed_scenarios.txt"},
        plugin = {"html:target/site/cucumber-pretty-rerun.html", "json:target/cucumber/cucumber_rerun.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class RunFailedTests extends AbstractTestNGCucumberTests {
    private Logger logger = LogManager.getLogger(getClass());

    /**
     * Sets the previous tasks to framework's execution.
     */
    @BeforeTest
    public void beforeExecution() {
        logger.info("=================== Before Execution ==========================");
    }

    /**
     * Performs the tasks after the framework's execution.
     */
    @AfterTest
    public void afterExecution() {
        logger.info("=================== After Execution ==========================");
        deleteAccount(getAccountId());
        deleteContact(getContactId());
    }
}
