/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static core.utils.StringAdapter.replaceSpecialCharacters;
import static salesforce.utils.AdaptStringToAttribute.changeFieldName;
import static salesforce.utils.CaseAttributeNameAdapter.getCaseAttributeName;
import static salesforce.utils.FileTranslator.translateValue;

public class CasePage extends BasePage {
    private String headersSubjectXpath = "//slot[@slot='primaryField']"
            + "//div/lightning-formatted-text";
    @FindBy(xpath = "//h1/div")
    private WebElement headersTitle;
    private String headersFields = "//p[@class='slds-text-title slds-truncate']";
    private String headersValues = "//slot[@class='slds-grid slds-page-header__detail-row']//lightning-formatted-text";
    private String detailsFields = "//records-lwc-detail-panel"
            + "//div[contains(@class,'slds-form-element__label')]";
    private String detailsValues = "//*[@data-output-element-id='output-field']";
    private String caseNumberXpath = "//p[%s]/../p/slot/lightning-formatted-text";
    public static final int INTERVAL_TIME = 40000;
    private String featureName = "Cases";

    /**
     * Waits for the edit button to appear on single case page.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(headersTitle));
    }

    /**
     * Gets the headers title.
     *
     * @return a String with the title
     */
    public String getHeadersTitle() {
        return getWebElementAction().getTextOnWebElement(headersTitle);
    }

    /**
     * Gets the headers subject.
     *
     * @return a String with the subject
     */
    public String getHeadersSubject() {
        if (getWebElementAction().isElementPresent(By.xpath(headersSubjectXpath), INTERVAL_TIME)) {
            return getDriver().findElement(By.xpath(headersSubjectXpath)).getText();
        } else {
            return "";
        }
    }

    /**
     * Creates a map of all the headers fields on a Case.
     *
     * @return the map with the headers and values
     */
    public Map<String, String> getAllHeadersFields() {
        Map<String, String> map = getHeadersFields();
        map.put("title", getHeadersTitle());
        map.put("subject", getHeadersSubject());
        return map;
    }

    /**
     * Gets all the fields and values of the headers section.
     *
     * @return a map with all the values
     */
    public Map<String, String> getHeadersFields() {
        List<WebElement> fieldsList = getDriver().findElements(By.xpath(headersFields));
        List<WebElement> valuesList = getDriver().findElements(By.xpath(headersValues));
        if (fieldsList.size() == valuesList.size()) {
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < fieldsList.size(); i++) {
                String text = fieldsList.get(i).getText();
                map.put(getCaseAttributeName(changeFieldName(
                        replaceSpecialCharacters(text))), valuesList.get(i).getText());
            }
            return map;
        }
        return null;
    }

    /**
     * Gets the case's number.
     *
     * @return a string with the value
     */
    public String getCaseNumber() {
        return getWebElementAction().getTextOnWebElement(getWebElementAction()
                .getWebElementByXpathAndValue(caseNumberXpath, translateValue(featureName, "header.caseNumber")));
    }

    /**
     * Gets all the fields and values on the details section.
     *
     * @return a map with all the values
     */
    public Map<String, String> getDetailsFields() {
        List<WebElement> fieldsList = getDriver().findElements(By.xpath(detailsFields));
        List<WebElement> valuesList = getDriver().findElements(By.xpath(detailsValues));
        if (fieldsList.size() == valuesList.size()) {
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < fieldsList.size(); i++) {
                String text = fieldsList.get(i).getText();
                if (valuesList.get(i).getText().contains(translateValue(featureName, "details.open"))
                        && valuesList.get(i).getText().contains(translateValue(featureName, "details.preview"))) {
                    if (valuesList.get(i).getText().contains(",")) {
                        String value = valuesList.get(i).getText();
                        map.put(getCaseAttributeName(changeFieldName(
                                replaceSpecialCharacters(text))),
                                value.substring(0, value.indexOf(translateValue(featureName, "details.open")) - 1)
                                .concat(value.substring(value.indexOf(","))));
                    } else {
                        String value = valuesList.get(i).getText();
                        map.put(getCaseAttributeName(changeFieldName(replaceSpecialCharacters(text))),
                                value.substring(0, value.indexOf(translateValue(featureName, "details.open")) - 1));
                    }
                } else {
                    map.put(getCaseAttributeName(changeFieldName(replaceSpecialCharacters(text))),
                            valuesList.get(i).getText());
                }
            }
            return map;
        }
        return null;
    }

    /**
     * Gets the case's id.
     *
     * @return a string with the value
     */
    public String getCaseId() {
        String url = getWebElementAction().getSiteCurrentUrl();
        String preIdString = "Case/";
        String posIdString = "/view";
        return url.substring(url.indexOf(preIdString) + preIdString.length(), url.indexOf(posIdString));
    }
}
