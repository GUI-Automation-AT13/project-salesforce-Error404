/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.legalentity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.HashMap;
import static salesforce.utils.FileTranslator.translateValue;

public class LegalEntityLightningSkin extends LegalEntityPageAbstract {

    @FindBy(css = ".slds-theme--success")
    private WebElement successMessage;

    @FindBy(css = "div.slds-form")
    private WebElement informationSection;

    @FindBy(css = "span.uiOutputTextArea")
    private WebElement description;

    private static final String INTERNATIONALIZED_NAME = translateValue("LegalEntities", "input.name");
    private static final String INTERNATIONALIZED_COMPANY_NAME = translateValue("LegalEntities", "input.companyname");

    private By descriptionCss = By.cssSelector("span.uiOutputTextArea");
    private By headerEntityName = By.xpath("//h1//div//span[@class=\"uiOutputText\"]");
    private By statusSpanXpath = By.xpath("//span[text()='" + translateValue("LegalEntities", "span.status")
            + "']/../..//div//span/*");

    private final int time = 2000;
    private static final String NAMES_XPATH = "//span[text()='%s']/../..//div//span[@class=\"uiOutputText\"]";
    private static final String ADDRESS_XPATH = "a.forceOutputAddress div:nth-child(%s)";
    private static final HashMap<String, String> SPAN_NAMES = new HashMap<>();

    static {
        SPAN_NAMES.put("Name", INTERNATIONALIZED_NAME);
        SPAN_NAMES.put("CompanyName", INTERNATIONALIZED_COMPANY_NAME);
    }

    private static final HashMap<String, String> DIV_ADDRESS = new HashMap<>();

    static {
        DIV_ADDRESS.put("Street", "1");
        DIV_ADDRESS.put("CityStatePostalCode", "2");
        DIV_ADDRESS.put("Country", "3");
    }

    /**
     * Waits for the visibility of a web element.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(informationSection));
    }

    /**
     * Builds a map from the ui.
     *
     * @return HashMap<String, String> with the entity map
     */
    @Override
    public HashMap<String, String> entityMap() {
        HashMap<String, String> entityMap = new HashMap<>();
        entityMap.put("Name", getSpanFixedText(getNamesText("Name")));
        entityMap.put("CompanyName", getSpanFixedText(getNamesText("CompanyName")));
        entityMap.put("LegalEntityStreet", getAddressNamesText("Street"));
        entityMap.put("Address", getAddressNamesText("CityStatePostalCode"));
        entityMap.put("Country", getAddressNamesText("Country"));
        entityMap.put("Description", getSpanFixedText(getDescriptionText()));
        entityMap.put("Status", getSpanFixedText(getStatusText()));
        return entityMap;
    }

    /**
     * Gets the success message.
     *
     * @return a String with the message.
     */
    @Override
    public String getSuccessMessage() {
        return getWebElementAction().getTextOnWebElement(successMessage);
    }

    /**
     * Gets the entity name text.
     *
     * @return a string with the entity name text.
     */
    @Override
    public String getHeaderEntityNameText() {
        return getSpanText(headerEntityName);
    }

    /**
     * Gets the description text.
     *
     * @return a String with the description text.
     */
    public String getDescriptionText() {
        return getSpanText(descriptionCss);
    }

    /**
     * Gets the status text.
     *
     * @return a String with the status text.
     */
    public String getStatusText() {
        return getSpanText(statusSpanXpath);
    }

    /**
     * Gets the entity or company name text.
     *
     * @param fieldName string with the name of the field.
     * @return a String with the entity or company name text.
     */
    public String getNamesText(final String fieldName) {
        return getNamesTextWithKeyMapByXpath(fieldName);
    }

    /**
     * Gets the address text.
     *
     * @param fieldName string with the name of the field.
     * @return a String with address text.
     */
    public String getAddressNamesText(final String fieldName) {
        return getAddressTextWithKeyMapByCss(fieldName);
    }

    /**
     * Gets the fixed text of a span.
     *
     * @param span to get text of.
     * @return null if the span is not present, span text otherwise.
     */
    private String getSpanText(final By span) {
        if (getWebElementAction().isElementPresent(span, time)) {
            return getDriver().findElement(span).getText();
        }
        return null;
    }

    /**
     * Gets the description text.
     *
     * @param spanToFixText span with text to fix.
     * @return null if the text obtained is empty, a string with the text otherwise.
     */
    private String getSpanFixedText(final String spanToFixText) {
        if (spanToFixText.isEmpty()) {
            return null;
        }
        return spanToFixText;
    }

    /**
     * Gets the text of a address with key map by css.
     *
     * @param keyMap of the map.
     * @return null if the address is not present, span text otherwise.
     */
    private String getAddressTextWithKeyMapByCss(final String keyMap) {
        if (getWebElementAction().isElementPresent(By.cssSelector(
                String.format(ADDRESS_XPATH, DIV_ADDRESS.get(keyMap))), time)) {
            return getDriver().findElement(By.cssSelector(
                    String.format(ADDRESS_XPATH, DIV_ADDRESS.get(keyMap)))).getText();
        }
        return null;
    }

    /**
     * Gets the text of a name with key map by xpath.
     *
     * @param keyMap of the map.
     * @return null if the name is not present, span text otherwise.
     */
    private String getNamesTextWithKeyMapByXpath(final String keyMap) {
        if (getWebElementAction().isElementPresent(By.xpath(
                String.format(NAMES_XPATH, SPAN_NAMES.get(keyMap))), time)) {
            return getDriver().findElement(By.xpath(
                    String.format(NAMES_XPATH, SPAN_NAMES.get(keyMap)))).getText();
        }
        return null;
    }
}
