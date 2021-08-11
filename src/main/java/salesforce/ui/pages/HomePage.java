/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.applauncher.AppLauncherNavigationPage;

/**
 * This class returns an instance of HomePage.
 */
public class HomePage extends BasePage {

//    @FindBy(css = ".slds-icon-waffle")
//    @FindBy(xpath = "//button[contains(@data-aura-class,' salesforceIdentityAppLauncherHeader')]")
//    private WebElement appLauncherButton;

    @FindBy(css = "[placeholder^=\"Search\"][role=\"combobox\"]")
    private WebElement appLauncherButton;

    /**
     * Creates the Home page.
     */
    public HomePage() {
        super();
    }

    /**
     * Waits for the app launcher button to be available.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(appLauncherButton));
    }

    /**
     * Opens the App Launcher Navigation.
     *
     * @return an AppLauncherNavigationPage.
     */
    public AppLauncherNavigationPage openAppLauncherNavigation() {
        getWebElementAction().clickOnWebElement(appLauncherButton);
        return new AppLauncherNavigationPage();
    }
}
