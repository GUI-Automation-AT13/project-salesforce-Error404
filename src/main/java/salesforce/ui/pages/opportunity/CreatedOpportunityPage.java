/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.opportunity;

import core.selenium.WebElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;
import salesforce.utils.FileTranslator;
import java.util.HashMap;
import java.util.Map;

public class CreatedOpportunityPage extends BasePage {
    private Map<String, String> headersFields;
    private WebElementAction webElementAction  = new WebElementAction();
    public OpportunityDetails opportunityDetails = new OpportunityDetails();

    @FindBy(css = ".slds-theme--success span a div")
    private WebElement textCreatedSuccessfull;

    @FindBy(xpath = "//h1//slot//lightning-formatted-text")
    private WebElement createdOpportunityTitle;

    @FindBy(css = ".current + span")
    private WebElement createdOpportunityStage;

    @FindBy(xpath = "//a[@data-tab-value='detailTab']")
    private WebElement detailBtn;

    private By menuBtn = By.xpath("//li[contains(@class,'slds-dropdown-trigger_click')]");
    private By deleteOption = By.xpath("//div[@role='menu']//*[@title='"
            + FileTranslator.translateValue("Opportunity", "delete")
            + "']//a");
    private By deleteBtnConfirm = By.xpath("//button[@title='"
            + FileTranslator.translateValue("Opportunity", "delete") + "']");
    private static final String CREATED_HEADER = "//div[./p[text()='%s']]//%s";

    public CreatedOpportunityPage() {
        setHeadersFields();
    }

    /**
     * Waits for a specific element to load on the page.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(detailBtn));
    }

    /**
     * Gets the alert text when an opportunity is created correctly.
     * @return the text of the alert when opportunity is created.
     */
    public String getSuccessfulAlert() {
        return webElementAction.getTextOnWebElement(textCreatedSuccessfull);
    }

    /**
     * Gets the Title of the created opportunity page.
     * @return the current text of the title header.
     */
    public String getTitleHeader() {
        return webElementAction.getTextOnWebElement(createdOpportunityTitle);
    }

    /**
     * Gets a Map with all the headers fields of created opportunity page.
     */
    public void setHeadersFields() {
        headersFields = new HashMap<>();
        headersFields.put("OpportunityName", getTitleHeader());
        headersFields.put("Account", webElementAction.getHeaderString(CREATED_HEADER,
                FileTranslator.translateValue("Opportunity", "accountName"), "a/span"));
        headersFields.put("CloseDate", webElementAction.getHeaderString(CREATED_HEADER,
                FileTranslator.translateValue("Opportunity", "closeDate"), "lightning-formatted-text"));
        headersFields.put("Amount", webElementAction.getHeaderString(CREATED_HEADER,
                FileTranslator.translateValue("Opportunity", "amount"), "lightning-formatted-text"));
        headersFields.put("Stage", getCurrentStage());
    }

    /**
     * Gets all the headers fields.
     * @return Map with all headers fields.
     */
    public Map<String, String> getHeadersFields() {
        return headersFields;
    }

    /**
     * Gets the Stage form the created Opportunity page.
     * @return A string with the current text of the Stage.
     */
    public String getCurrentStage() {
        return webElementAction.getTextOnWebElement(createdOpportunityStage);
    }

    /**
     * Gets the text of created opportunity in salesforce.
     *
     * @return String with date of created opportunity.
     */
    public String getCreatedDate() {
        WebElement element = getDriver().findElement(By.cssSelector(".forceRelatedListSingleContainer .uiOutputDateTime"));
        System.out.println(getWebElementAction().getTextOnWebElement(element));
        return getWebElementAction().getTextOnWebElement(element);

    }
}
