/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

import static salesforce.ui.pages.SingleCasePage.INTERVAL_TIME;

public class CasesPage extends BasePage {
    @FindBy(css = "div[title=\"New\"]")
    private WebElement buttonNew;
    private String caseNumberCellXpath = "//*[@title='%s']";
    private String subjectCellXpath = "//*[@title='%s']/../../.."
            + "//div[contains(@class,'outputLookupContainer')]";
    private String statusCellXpath = "//*[@title='%s']/../../..//*[@class='slds-truncate']";
    private String dateTimeOpenedCellXpath = "//*[@title='%s']/../../.."
            + "//*[contains(@class,'uiOutputDateTime')]";
    private String caseOwnerAliasXpath = "//*[@title='%s']/../../.."
            + "//*[contains(@class,'uiOutputText')]";

    /**
     * Creates the Cases Page.
     */
    public CasesPage() {
        super();
    }

    /**
     * Waits for the new button to appear on Cases page.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(buttonNew));
    }

    /**
     * Clicks on the new button.
     *
     * @return the salesforce.cases form site
     */
    public CasesFormPage clickOnNew() {
        getWebElementAction().clickOnWebElement(buttonNew);
        return new CasesFormPage();
    }

    /**
     * Gets the text on the Case Number cell.
     *
     * @param caseNumber a String with the value
     * @return a String with the case number
     */
    public String getCaseNumberCellText(final String caseNumber) {
        return getWebElementAction().getTextOnWebElement(getWebElementAction()
                .getWebElementByXpathAndValue(caseNumberCellXpath, caseNumber));
    }

    /**
     * Gets the text on the subject cell.
     *
     * @param caseNumber a String with the value
     * @return a String with the subject
     */
    public String getSubjectCellText(final String caseNumber) {
        if (getWebElementAction().isElementPresent(
                By.xpath(String.format(subjectCellXpath, caseNumber)), INTERVAL_TIME)) {
            if (getDriver().findElement(
                    By.xpath(String.format(subjectCellXpath, caseNumber))).getText().equals("-")) {
                return "";
            } else {
                return getDriver().findElement(
                        By.xpath(String.format(subjectCellXpath, caseNumber))).getText();
            }
        } else {
            return "";
        }
    }

    /**
     * Gets the text on the status cell.
     *
     * @param caseNumber a String with the value
     * @return a String with the status
     */
    public String getStatusCellText(final String caseNumber) {
        return getWebElementAction().getTextOnWebElement(getWebElementAction()
                .getWebElementByXpathAndValue(statusCellXpath, caseNumber));
    }

    /**
     * Gets the text on Date/Time Opened cell.
     *
     * @param caseNumber a String with the value
     * @return a String with the Date/Time Opened
     */
    public String getDateTimeOpenedCellText(final String caseNumber) {
        return getWebElementAction().getTextOnWebElement(getWebElementAction()
                .getWebElementByXpathAndValue(dateTimeOpenedCellXpath, caseNumber));
    }

    /**
     * Gets the text on the Case Owner Alias cell.
     *
     * @param caseNumber a String with the value
     * @return a String with the case owner alias
     */
    public String getCaseOwnerAliasCellText(final String caseNumber) {
        return getWebElementAction().getTextOnWebElement(getWebElementAction()
                .getWebElementByXpathAndValue(caseOwnerAliasXpath, caseNumber));
    }

    /**
     * Gets the case id.
     *
     * @param caseNumber a String with the value
     * @return the case id
     */
    public String getCaseId(final String caseNumber) {
        return getWebElementAction().getAttributeFromWebElement(getWebElementAction()
                .getWebElementByXpathAndValue(caseNumberCellXpath, caseNumber),
                "data-recordid");
    }

    /**
     * Creates a map of all the row fields of the case.
     *
     * @param caseNumber the case we want to extract the row
     * @return a map with all the row fields
     */
    public Map<String, String> getRowFields(final String caseNumber) {
        Map<String, String> map = new HashMap<>();
        map.put("caseNumber", getCaseNumberCellText(caseNumber));
        map.put("subject", getSubjectCellText(caseNumber));
        map.put("status", getStatusCellText(caseNumber));
        map.put("dateTimeOpened", getDateTimeOpenedCellText(caseNumber));
        return map;
    }
}
