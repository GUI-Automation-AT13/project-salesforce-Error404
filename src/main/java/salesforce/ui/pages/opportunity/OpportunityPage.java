/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.opportunity;

import core.selenium.WebElementAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

public class OpportunityPage extends BasePage {
    @FindBy(css = ".forceActionLink")
    private WebElement buttonNew;
    WebElementAction webElementAction = new WebElementAction();

    /**
     * Override method for waiting an element.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(buttonNew));
    }

    /**
     * Clicks the new button for Opportunity form.
     */
    private void clickNewBtnOpportunity() {
        webElementAction.clickOnWebElement(buttonNew);
    }

    /**
     * Goes to the New Opportunity page.
     *
     * @return the new Opportunity page.
     */
    public NewOpportunityPage openNewOpportunityForm() {
        clickNewBtnOpportunity();
        return new NewOpportunityPage();
    }
}
