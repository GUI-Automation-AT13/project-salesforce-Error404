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

/**
 * This class returns an instance of AppLauncherNavigationPage.
 */
public class AppLauncherNavigationPage extends BasePage {
    @FindBy(xpath = "//lightning-button/button")
    private WebElement appLauncherLink;

    private By viewAllLink = By.xpath("//button[contains(text(),'"
            + FileTranslator.translateValue("AppLauncherSearch", "viewAllLink") + "')]");

    /**
     * Waits for the page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(appLauncherLink));
    }

    /**
     * Opens the App Launcher Modal.
     *
     * @return an AppLauncherModalPage.
     */
    public AppLauncherModalPage clickView() {
        getWebElementAction().clickOnWebElement(getDriver().findElement(viewAllLink));
        return new AppLauncherModalPage();
    }
}
