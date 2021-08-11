/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.opportunity;

import core.selenium.WebElementAction;
import salesforce.ui.pages.BasePage;
import salesforce.utils.FileTranslator;

import java.util.HashMap;
import java.util.Map;

public class OpportunityDetails extends BasePage {
    private final int sleepTime = 2000;
    private Map<String, String> detailFields;
    private WebElementAction webElementAction  = new WebElementAction();
    private static final String CREATED_DETAIL = "//div[./div[./span[contains(text(),'%s')]]]"
            + "//lightning-formatted-text";
    private static final String CREATED_SEARCH = "//div[./div[./span[contains(text(),'%s')]]]/"
            + "div[@class='slds-form-element__control']";
    private static final String CREATED_ACCOUNT_DETAIL = "//div[./div[./span[contains(text(),'%s')]]]//a/span";

    @Override
    protected void waitForPageToLoad() {

    }

    public OpportunityDetails() {
        clickDetails();
        setDetailMap();
    }

    /**
     * Clicks the detail button for created Opportunity.
     */
    private void clickDetails() {
        webElementAction.clickOnWebElement(
                webElementAction.getWebElementByXpathAndValue("//a[@data-tab-value='detailTab']", ""));
        //NEEDED TO WAIT FOR JAVASCRIPT TO LOAD
        try {
            Thread.sleep(sleepTime);
            setDetailMap();
        } catch (InterruptedException ie) {
            //There is no need to handle.
        }
    }

    /**
     * Gets the Map with all the details fields.
     * @return Map with details fields.
     */
    public Map<String, String> getDetailMap() {
        return detailFields;
    }

    /**
     * Sets the Map with all the detail fields text.
     */
    private void setDetailMap() {
        detailFields = new HashMap<>();
        detailFields.put("OpportunityName", webElementAction.getDetailText(CREATED_DETAIL,
                FileTranslator.translateValue("Opportunity", "opportunityName")));
        detailFields.put("Type", webElementAction.getDetailText(CREATED_DETAIL,
                FileTranslator.translateValue("Opportunity", "type")));
        detailFields.put("LeadSource", webElementAction.getDetailText(CREATED_DETAIL,
                FileTranslator.translateValue("Opportunity", "leadSource")));
        detailFields.put("Amount", webElementAction.getDetailText(CREATED_DETAIL,
                FileTranslator.translateValue("Opportunity", "amount")));
        detailFields.put("CloseDate", webElementAction.getDetailText(CREATED_DETAIL,
                FileTranslator.translateValue("Opportunity", "closeDate")));
        detailFields.put("NextStep", webElementAction.getDetailText(CREATED_DETAIL,
                FileTranslator.translateValue("Opportunity", "nextStep")));
        detailFields.put("Stage", webElementAction.getDetailText(CREATED_DETAIL,
                FileTranslator.translateValue("Opportunity", "stage")));
        detailFields.put("Probability", webElementAction.getDetailText(CREATED_SEARCH,
                FileTranslator.translateValue("Opportunity", "probability")));
        detailFields.put("Account", webElementAction.getDetailText(CREATED_ACCOUNT_DETAIL,
                FileTranslator.translateValue("Opportunity", "account")));
    }
}
