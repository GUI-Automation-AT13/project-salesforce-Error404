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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import salesforce.utils.Reports;
import static cucumber.hooks.AccountHooks.deleteAccount;
import static cucumber.hooks.ContactHooks.deleteContact;

@CucumberOptions(
        glue = {"cucumber"},
        features = {"src\\test\\resources\\feature\\"},
        plugin = {"html:target/site/cucumber-pretty.html", "json:target/cucumber/cucumber.json",
                "rerun:target/failed_scenarios.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class RunTests extends AbstractTestNGCucumberTests {

    /**
     * Sets the previous tasks to framework's execution.
     */
    @BeforeTest
    public void beforeExecution() {
        System.out.println("Before Execution");
    }

    /**
     * Performs the tasks after the framework's execution.
     */
    @AfterTest
    public void afterExecution() {
        Reports.generateJVMReport();
        deleteRemainingEntities();
    }

    /**
     * Deletes the created entities to run the scenarios.
     */
    public void deleteRemainingEntities() {
        deleteContact();
        deleteAccount();
    }
}
