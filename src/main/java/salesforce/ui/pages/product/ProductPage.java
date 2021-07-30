package salesforce.ui.pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import salesforce.ui.pages.BasePage;

/**
 * This class returns an instance of ProductPage.
 */
public class ProductPage extends BasePage {

    @FindBy(css = ".slds-theme--success")
    private WebElement successMessage;

    @FindBy(css = ".slds-page-header__title > .uiOutputText")
    private WebElement productTitle;

    @FindBy(css = "img.checked")
    private WebElement activeCheckBoxChecked;

    @FindBy(css = "img.unchecked")
    private WebElement activeCheckBoxUnchecked;

    @FindBy(xpath = "//span[text()='Created By']/../..//span[contains(@class,'uiOutputDateTime')]")
    private WebElement createdByDate;

    @FindBy(xpath = "//div/span[text()='Product Description']/../..//span/span")
    private WebElement descriptionTextArea;

    private static final String SPAN_XPATH = "//div/span[text()='%s']/../..//span/span";

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
        return getWebElementAction().getTextOnWebElement(getDriver().findElement(By.xpath(String.format(SPAN_XPATH, fieldName))));
    }

    /**
     * Gets the description of the product.
     *
     * @return the description
     */
    public String getDescription() {
        return getWebElementAction().getTextOnWebElement(descriptionTextArea);
    }

//    /**
//     * Verifies if an element is present.
//     *
//     * @param fieldName the name of the field.
//     * @return True if the element is present, false otherwise.
//     */
//    public Boolean isPresent(final String fieldName) {
//        return webElementAction.isElementPresent(By.xpath(String.format(SPAN_XPATH, fieldName)), 10000);
//    }

    /**
     * Verifies if an element is empty.
     *
     * @param fieldName the name of the field.
     * @return True if the element is empty, false otherwise.
     */
    public Boolean isEmpty(final String fieldName) {
        return getWebElementAction().getTextOnWebElement(getDriver().findElement(By.xpath(String.format(SPAN_XPATH, fieldName)))).isEmpty();
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
        return getWebElementAction().getTextOnWebElement(createdByDate);
    }

    /**
     * Gets the product tittle.
     *
     * @return a String with the tittle.
     */
    public String getProductTittle() {
        return getWebElementAction().getTextOnWebElement(productTitle);
    }
}
