/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package cucumber.steps;

import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.ui.PageTransporter;

public class NavigationSteps {

    private Logger logger = LogManager.getLogger(getClass());

    /**
     * Goes to the provided web page.
     *
     * @param pageName an enum with the page's site.
     * @throws Exception
     */
    @When("I navigate to the {string} page")
    public void iNavigateToThePage(final String pageName) throws Exception {
        logger.info("=================== When I navigate to a feature page ==========================");
        PageTransporter pageTransporter = new PageTransporter();
        pageTransporter.goToPage(pageName);
    }
}
