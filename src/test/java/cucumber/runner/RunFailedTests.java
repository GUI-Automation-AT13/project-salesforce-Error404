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

@CucumberOptions(
        features = {"@target/failed_scenarios.txt"},
        plugin = {"html:target/site/cucumber-pretty-rerun.html", "json:target/cucumber/cucumber_rerun.json"},
        glue = {"cucumber"}
)
public class RunFailedTests extends AbstractTestNGCucumberTests {
}
