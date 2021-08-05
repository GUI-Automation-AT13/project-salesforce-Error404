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
import static cucumber.hooks.AccountHooks.deleteAccount;
import static cucumber.hooks.ContactHooks.deleteContact;

@CucumberOptions(
        features = {"@target/failed_scenarios.txt"},
        plugin = {"html:target/site/cucumber-pretty-rerun.html", "json:target/cucumber/cucumber_rerun.json"},
        glue = {"cucumber"}
)
public class RunFailedTests extends AbstractTestNGCucumberTests {

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
        System.out.println("After Execution");
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
