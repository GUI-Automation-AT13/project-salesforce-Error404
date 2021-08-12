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

public class LegalEntitiesClassicVersion extends LegalEntitiesPageAbstract {

    @FindBy(xpath = "//input[@name='new']")
    private WebElement newEntityBtn;

    private String legalEntityNumberCellXpath = "//tr[@class='dataRow even first']//a[text()='%s']";
    private By dialogWindow = By.xpath("(//div[@class='topLeft']//a[@class='dialogClose'])[last()]");
    private final int time = 2000;

    /**
     * Gets the locator of the new entity button.
     *
     * @return a WebElement.
     */
    @Override
    protected WebElement getLocator() {
        if (getWebElementAction().isElementPresent(dialogWindow, time)) {
            closeWindow();
        }
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
                "href");
    }

    /**
     * Closes the add window.
     */
    private void closeWindow() {
        getWebElementAction().clickOnWebElement(getDriver().findElement(dialogWindow));
    }
}
