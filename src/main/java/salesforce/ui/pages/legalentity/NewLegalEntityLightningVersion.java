/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.legalentity;

import core.selenium.WebElementAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import salesforce.entities.LegalEntity;
import salesforce.ui.pages.AppPageFactory;
import java.util.HashMap;
import static salesforce.utils.FileTranslator.translateValue;

public class NewLegalEntityLightningVersion extends NewLegalEntityPageAbstract {

    private WebElementAction webElementAction = new WebElementAction();

    @FindBy(xpath = "//div/textarea[@class=' textarea']")
    private WebElement descriptionTxtBox;

    private By saveBtnXpath = By.xpath("//button[@title='" + translateValue("LegalEntities", "button.save") + "']");
    private By streetTxtBoxXpath = By.xpath("//div/textarea[@placeholder='"
            + translateValue("LegalEntities", "input.street") + "']");
    private static final String INTERNATIONALIZED_NAME = translateValue("LegalEntities", "input.name");
    private static final String INTERNATIONALIZED_COMPANY_NAME =
            translateValue("LegalEntities", "input.companyname");
    private static final String INPUT_XPATH = "//label/span[text()='%s']/../..//input";
    private static final String INPUT_ADDRESS_CSS = "input.%s";
    private static final String DROPDOWN_XPATH = "//a[@class='%s']";
    private static final String DROPDOWN_OPTION_XPATH = "//div[@class=\"select-options\"]//a[@title='%s']";
    private static final HashMap<String, String> INPUT_FIELDS_NAMES = new HashMap<>();

    static {
        INPUT_FIELDS_NAMES.put("Name", INTERNATIONALIZED_NAME);
        INPUT_FIELDS_NAMES.put("CompanyName", INTERNATIONALIZED_COMPANY_NAME);

    }

    private static final HashMap<String, String> INPUT_ADDRESS_NAMES = new HashMap<>();

    static {
        INPUT_ADDRESS_NAMES.put("City", "city");
        INPUT_ADDRESS_NAMES.put("State", "state");
        INPUT_ADDRESS_NAMES.put("PostalCode", "postalCode");
        INPUT_ADDRESS_NAMES.put("Country", "country");
    }


    /**
     * Introduces text to web email text box.
     *
     * @param fieldName the field name of the map.
     * @param value     a String to input
     */
    public void setInputFieldWithInternationalization(final String fieldName, final String value) {
        webElementAction.setTextField(webElementAction
                .getWebElementByXpathAndValue(INPUT_XPATH, INPUT_FIELDS_NAMES.get(fieldName)), value);
    }

    /**
     * Introduces text to web email text box.
     *
     * @param fieldName the field name of the map.
     * @param value     a String to input
     */
    public void setInputFieldByClass(final String fieldName, final String value) {
        webElementAction.setTextField(webElementAction
                .getWebElementByCssAndValue(INPUT_ADDRESS_CSS, INPUT_ADDRESS_NAMES.get(fieldName)), value);
    }

    /**
     * Selects an option from a dropdown menu.
     *
     * @param fieldName the name of the menu field.
     * @param option    the option to select.
     */
    public void selectFromDropDown(final String fieldName, final String option) {
        webElementAction.clickOnWebElement(getDriver().findElement(By.xpath(String.format(DROPDOWN_XPATH, fieldName))));
        webElementAction.clickOnWebElement(getDriver().findElement(
                By.xpath(String.format(DROPDOWN_OPTION_XPATH, translateValue("LegalEntities", "option.status")))));
    }

    /**
     * Sets the street.
     *
     * @param street a String with the street.
     */
    public void setStreetTxtBox(final String street) {
        webElementAction.setTextField(getDriver().findElement(streetTxtBoxXpath), street);
    }

    /**
     * Sets the description.
     *
     * @param description a String with the description.
     */
    public void setDescriptionTxtBox(final String description) {
        webElementAction.setTextField(descriptionTxtBox, description);
    }

    /**
     * Click the save button.
     *
     * @return LegalEntityPageAbstract.
     */
    @Override
    protected LegalEntityPageAbstract clickSaveBtn() {
        webElementAction.clickOnWebElement(getDriver().findElement(saveBtnXpath));
        return AppPageFactory.getLegalEntityPage();
    }

    /**
     * Builds the map.
     *
     * @param legalEntity to obtain the values to be set.
     * @return HashMap<String, Runnable>.
     */
    @Override
    protected HashMap<String, Runnable> buildMap(final LegalEntity legalEntity) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> setInputFieldWithInternationalization("Name", legalEntity.getName()));
        strategyMap.put("CompanyName", () -> setInputFieldWithInternationalization("CompanyName",
                legalEntity.getCompanyName()));
        strategyMap.put("LegalEntityState", () -> setInputFieldByClass("State", legalEntity.getLegalEntityState()));
        strategyMap.put("LegalEntityCity", () -> setInputFieldByClass("City", legalEntity.getLegalEntityCity()));
        strategyMap.put("LegalEntityPostalCode", () -> setInputFieldByClass("PostalCode",
                legalEntity.getLegalEntityPostalCode()));
        strategyMap.put("LegalEntityCountry", () -> setInputFieldByClass("Country",
                legalEntity.getLegalEntityCountry()));
        strategyMap.put("LegalEntityStreet", () -> setStreetTxtBox(legalEntity.getLegalEntityStreet()));
        strategyMap.put("Description", () -> setDescriptionTxtBox(legalEntity.getDescription()));
        strategyMap.put("Status", () -> selectFromDropDown("select", legalEntity.getStatus()));
        return strategyMap;
    }


}
