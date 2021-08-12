/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.legalentity;

import org.openqa.selenium.WebElement;
import salesforce.ui.pages.AppPageFactory;
import salesforce.ui.pages.BasePage;

public abstract class LegalEntitiesPageAbstract extends BasePage {

    public LegalEntitiesPageAbstract() {
        waitForPageToLoad();
    }

    @Override
    protected void waitForPageToLoad() {
    }

    protected abstract WebElement getLocator();

    public abstract String getLegalEntityId(String name);

    /**
     * Clicks on new button.
     *
     * @return a NewLegalEntityPageAbstract with the correct instance.
     */
    public NewLegalEntityPageAbstract clickOnNew() {
        WebElement locatorNewButton = getLocator();
        getWebElementAction().clickOnWebElement(locatorNewButton);
        return AppPageFactory.getNewLegalEntityPage();
    }
}
