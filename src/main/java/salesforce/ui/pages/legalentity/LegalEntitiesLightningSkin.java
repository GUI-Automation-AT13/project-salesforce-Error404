/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.legalentity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LegalEntitiesLightningSkin extends LegalEntitiesPageAbstract {

    @FindBy(xpath = "//li[contains(@class,'slds-button--neutral')]//a")
    private WebElement newEntityBtn;

    private String legalEntityNumberCellXpath = "//table//*[@title='%s']";

    /**
     * Gets the locator of the new entity button.
     *
     * @return a WebElement.
     */
    @Override
    protected WebElement getLocator() {
        return newEntityBtn;
    }

    /**
     * Gets the legal entity id.
     *
     * @param name a string with the name of the entity.
     * @return a string with the id.
     */
    @Override
    public String getLegalEntityId(final String name) {
        return getWebElementAction().getAttributeFromWebElement(getWebElementAction()
                        .getWebElementByXpathAndValue(legalEntityNumberCellXpath, name),
                "href").substring(1);
    }
}
