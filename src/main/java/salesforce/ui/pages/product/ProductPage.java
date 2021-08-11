/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package salesforce.ui.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;
import salesforce.utils.FileTranslator;

/**
 * This class returns an instance of ProductPage.
 */
public class ProductPage extends BasePage {

    @FindBy(css = ".slds-theme--success")
    private WebElement successMessage;

    @FindBy(css = ".slds-page-header__title > .uiOutputText")
    private WebElement productTitle;

    @FindBy(xpath = "//div/span[text()='Product Description']/../..//span/span")
    private WebElement descriptionTextArea;

    private By createdByDate = By.xpath("//span[text()='"
            + FileTranslator.translateValue("Products", "createdBy")
            + "']/../..//span[contains(@class,'uiOutputDateTime')]");
    private By activeCheckBoxChecked = By.xpath("//span[text()='"
            + FileTranslator.translateValue("Products", "active") + "']/../..//img");

    private static final String SPAN_XPATH = "//div/span[text()='%s']/../..//span/span";

    /**
     * Waits for the page to load.
     */
    @Override
    protected void waitForPageToLoad() {
        getWait().until(ExpectedConditions.visibilityOf(productTitle));
    }

    /**
     * Gets the text of spans.
     *
     * @param fieldName the name of the field
     * @return the text of a span
     */
    public String getSpanText(final String fieldName) {
        return getWebElementAction()
                .getTextOnWebElement(getDriver().findElement(By.xpath(String.format(SPAN_XPATH, fieldName))));
    }

    /**
     * Gets if product is active.
     *
     * @return true if it is active, false if not
     */
    public boolean isActive() {
        WebElement checkbox = getDriver().findElement(activeCheckBoxChecked);
        return  checkbox.getAttribute("alt").contains("True");
    }

    /**
     * Gets the description of the product.
     *
     * @return the description
     */
    public String getDescription() {
        return getWebElementAction().getTextOnWebElement(descriptionTextArea);
    }

    /**
     * Gets the success message.
     *
     * @return a String with the message.
     */
    public String getUserSuccessMessage() {
        return getWebElementAction().getTextOnWebElement(successMessage);
    }

    /**
     * Gets the date in which the product was created.
     *
     * @return a String with the date.
     */
    public String getCreatedByDate() {
        return getWebElementAction().getTextOnWebElement(getDriver().findElement(createdByDate));
    }

    /**
     * Gets the product title.
     *
     * @return a String with the title.
     */
    public String getProductTitle() {
        return getWebElementAction().getTextOnWebElement(productTitle);
    }

    /**
     * Gets the product's id.
     *
     * @return a string with the value
     */
    public String getProductId() {
        String url = getWebElementAction().getSiteCurrentUrl();
        String preIdString = "Product2/";
        String posIdString = "/view";
        return url.substring(url.indexOf(preIdString) + preIdString.length(), url.indexOf(posIdString));
    }
}
