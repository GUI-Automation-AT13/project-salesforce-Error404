/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package salesforce.ui.pages.applauncher;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;
import salesforce.utils.FileTranslator;
import java.util.List;

/**
 * This class returns an instance of AppLauncherModalPage.
 */
public class AppLauncherModalPage extends BasePage {
    @FindBy(xpath = "//lightning-input[contains(@class,'searchBar')]/div/input[@type='search']")
    private WebElement searcher;

    private By resultApps = By.xpath(" //div[contains(@class,'slds-grid_pull-padded')]//one-app-launcher-app-tile");
    private By resultItems = By.xpath("//ul[contains(@class,'al-modal-list')]//a");
    private By searchTextBox = By.xpath("//input[@type='search'][contains(@placeholder,'"
            + FileTranslator.translateValue("AppLauncherSearch", "searchPlaceHolder") + "')]");

    /**
     * Waits for the page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(searcher));
    }

    /**
     * Sets text in the search text box.
     *
     * @param text to set.
     */
    public void setSearchTextBox(final String text) {
        getWebElementAction().setTextField(getDriver().findElement(searchTextBox), text);
    }

    /**
     * Gets the results of the search.
     *
     * @param type the type of list result(Apps or Items).
     * @return a list of the results.
     */
    public List<WebElement> getResult(final String type) {
        if ("Apps".equals(type)) {
            return getDriver().findElements(resultApps);
        } else {
            return getDriver().findElements(resultItems);
        }
    }

    /**
     * Validates that all results match with the searched text.
     *
     * @param text that should be in the results.
     * @param list with the results.
     * @param type the type of list result(Apps or Items).
     * @return true if all results contain the searched text, false otherwise.
     */
    public boolean containsText(final String text, final List<WebElement> list, final String type) {
        boolean match = false;
        for (WebElement element: list) {
            if ("Apps".equals(type)) {
                match = element.getAttribute("data-name").contains(text);
            } else {
                match = element.getAttribute("data-label").contains(text);
            }
        }
        return match;
    }
}
