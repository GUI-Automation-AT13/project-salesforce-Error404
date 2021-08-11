/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package core.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static core.selenium.MyWebDriverManager.getWebDriverManager;

public class WebElementAction {
    private final WebDriver driver = getWebDriverManager().getDriver();
    private final WebDriverWait wait = getWebDriverManager().getWebDriverWait();
    private final int  waitTime = 20;

    /**
     * Creates web element action.
     */
    public WebElementAction() {
    }

    /**
     * Sets a value into a text box field.
     *
     * @param webElement the text box to set
     * @param value the value to set
     */
    public void setTextField(final WebElement webElement, final String value) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(value);
    }

    /**
     * Clicks on web element.
     *
     * @param webElement the element to click on
     */
    public void clickOnWebElement(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
    }

    /**
     * Gets the web element with xpath and a value to replace in it.
     *
     * @param xpath the element's xpath
     * @param value the value to replace the xpath
     * @return a web element with the provided features
     */
    public WebElement getWebElementByXpathAndValue(final String xpath, final String value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(xpath, value))));
        return driver.findElement(By.xpath(String.format(xpath, value)));
    }

    /**
     * Gets the web element with xpath and a value to replace in it.
     *
     * @param cssLocator the element's xpath
     * @param value the value to replace the xpath
     * @return a web element with the provided features
     */
    public WebElement getWebElementByCssAndValue(final String cssLocator, final String value) {
        return driver.findElement(By.cssSelector(String.format(cssLocator, value)));
    }

    /**
     * Selects an option of a dropdown menu.
     *
     * @param webElement the dropdown menu
     * @param value the value to choose
     */
    public void selectOnDropdownMenu(final WebElement webElement, final String value) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
        driver.findElement(By.linkText(value)).click();
    }

    /**
     * Selects an option of a dropdown menu.
     *
     * @param webElement the dropdown menu
     * @param value the value to choose
     * @param xpath the displayed values xpath
     */
    public void selectOnDropDownMenu(final WebElement webElement, final String value, final String xpath) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
        driver.findElement(By.xpath(String.format(xpath, value))).click();
    }

    /**
     * Selects a value on autocomplete text box.
     *
     * @param webElement the text box
     * @param value the value to choose
     * @param displayedElementPath the element to select
     */
    public void selectOnAutoCompleteTextBox(final WebElement webElement, final String value,
                                            final String displayedElementPath) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        webElement.click();
        webElement.sendKeys(value);
        clickOnWebElement(getWebElementByXpathAndValue(displayedElementPath, value));
    }

    /**
     * Gets a web element's text.
     *
     * @param webElement any web element on page
     * @return a String with the text
     */
    public String getTextOnWebElement(final WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * Gets the attribute value on web element.
     *
     * @param webElement any web element on page
     * @param attributeName an attribute of the web element
     * @return a String with the value
     */
    public String getAttributeFromWebElement(final WebElement webElement,
                                             final String attributeName) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getAttribute(attributeName);
    }

    /**
     * Verifies if an element is present.
     * Uses an interval time to wait and find the element and return true if it is present.
     *
     * @param by - Selector of element to Find.
     * @param intervalTime - Time in milliseconds to wait.
     * @return True if the element is present, false otherwise.
     */
    public boolean isElementPresent(final By by, final int intervalTime) {
        driver.manage().timeouts().implicitlyWait(intervalTime, TimeUnit.MILLISECONDS);
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(WebDriverConfig
                    .getWebDriverConfig().getImplicitWaitTime(), TimeUnit.MILLISECONDS);
        }
    }

    /**
     * Gets the current web site's url.
     *
     * @return a String with the url
     */
    public String getSiteCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Clicks the checkbox elements.
     *
     * @param webElement checkbox.
     * @param stateOfCheckbox true to select, false to deselect.
     */
    public void selectCheckBox(final WebElement webElement, final boolean stateOfCheckbox) {
        if (!webElement.isSelected() && stateOfCheckbox) {
            webElement.click();
        }
        if (webElement.isSelected() && !stateOfCheckbox) {
            webElement.click();
        }
    }

    /**
     * Gets the generic text from the header in a created opportunity page.
     *
     * @param xpath initial Xpath of the element.
     * @param field name of the field to get the String.
     * @param headerType type of the element field.
     * @return the current text of the specific field.
     */
    public String getHeaderString(final String xpath, final String field, final String headerType) {
        By byElement =  By.xpath(String.format(xpath, field, headerType));
        if (isElementPresent(byElement, waitTime)) {
            WebElement createdHeader = driver.findElement(byElement);
            return createdHeader.getText();
        }
        return null;
    }

    /**
     * Gets text from detail fields.
     *
     * @param xpath the path for the field.
     * @param field name of the field.
     * @return the text from the detail field.
     */
    public String getDetailText(final String xpath, final String field) {
        By xpathElement = By.xpath(String.format(xpath, field));
        if (isElementPresent(xpathElement, waitTime)) {
            WebElement element = driver.findElement(xpathElement);
            return element.getText();
        }
        return null;
    }
}
