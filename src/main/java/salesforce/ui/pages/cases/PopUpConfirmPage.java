/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.cases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

public class PopUpConfirmPage extends BasePage {
    @FindBy(css = "[title='Cancel']")
    private WebElement cancelButton;
    @FindBy(xpath = "//span[text()='Delete']")
    private WebElement deleteButton;

    /**
     * Waits for the delete button to appear.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(deleteButton));
    }

    /**
     * Clicks on the delete button.
     *
     * @return the all cases web site
     */
    public CasesPage clickOnDelete() {
        getWebElementAction().clickOnWebElement(deleteButton);
        return new CasesPage();
    }
}
