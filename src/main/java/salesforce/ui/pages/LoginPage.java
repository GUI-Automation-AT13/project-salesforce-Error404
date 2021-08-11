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

public class LoginPage extends BasePage {
    @FindBy(id = "username")
    private WebElement usernameTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "Login")
    private WebElement loginButton;

    /**
     * Waits for the page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(loginButton));
    }

    /**
     * Sets the username text box value.
     *
     * @param newUsername a String with the value
     */
    private void setUsernameTextBox(final String newUsername) {
        getWebElementAction().setTextField(usernameTextBox, newUsername);
    }

    /**
     * Sets the password text box value.
     *
     * @param newPassword a String with the value
     */
    private void setPasswordTextBox(final String newPassword) {
        getWebElementAction().setTextField(passwordTextBox, newPassword);
    }

    /**
     * Clicks on the login button.
     */
    private void clickLoginButton() {
        loginButton.click();
    }

    /**
     * Creates an instance of home page on successful login.
     *
     * @param username a String with the username
     * @param password a String with the password
     */
    public void loginSuccessful(final String username, final String password) {
        setUsernameTextBox(username);
        setPasswordTextBox(password);
        clickLoginButton();
    }
}
