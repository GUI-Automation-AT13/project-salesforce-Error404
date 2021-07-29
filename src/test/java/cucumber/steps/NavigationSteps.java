/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.steps;

import io.cucumber.java.en.When;
import salesforce.ui.PageTransporter;

public class NavigationSteps {
    @When("I navigate to the {string} page")
    public void iNavigateToThePage(final String pageName) {
        //Navigate to web site
        PageTransporter pageTransporter = new PageTransporter();
        pageTransporter.goToPage(pageName);
    }
}
